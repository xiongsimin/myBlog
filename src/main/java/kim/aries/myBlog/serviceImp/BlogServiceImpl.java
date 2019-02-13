package kim.aries.myBlog.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kim.aries.myBlog.dao.BlogDao;
import kim.aries.myBlog.dao.BlogTypeDao;
import kim.aries.myBlog.dao.TagDao;
import kim.aries.myBlog.dao.TypeDao;
import kim.aries.myBlog.domain.Blog;
import kim.aries.myBlog.domain.BlogTagType;
import kim.aries.myBlog.domain.BlogType;
import kim.aries.myBlog.domain.Tag;
import kim.aries.myBlog.domain.Type;
import kim.aries.myBlog.service.BlogService;

@Service("blogService")
public class BlogServiceImpl implements BlogService {
	@Autowired
	private BlogDao blogDao;
	@Autowired
	private TagDao tagDao;
	@Autowired
	private TypeDao typeDao;
	@Autowired
	private BlogTypeDao blogTypeDao;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addBlog(Blog blog) throws Exception {
		// TODO Auto-generated method stub
		this.blogDao.addBlog(blog);
		for (Tag tag : blog.getTags()) {
			tag.setBlogId(blog.getId());
			this.tagDao.addTag(tag);
		}
		/*
		 * for (Type type : blog.getTypes()) { //
		 * 1.先判断类型是否存在（存在：直接第2步；不存在：先新增类型再执行第2步） // 2.再新增维护“博客-类型”关系记录 Type
		 * tempType = this.typeDao.findTypeByName(type.getTypeName()); if
		 * (tempType != null) {// 非空说明已存在，直接第2步 BlogType blogType = new
		 * BlogType(blog.getId(), tempType.getId());
		 * this.blogTypeDao.addBlogType(blogType); } else {
		 * this.typeDao.addType(type);// 新增后该对象的id会自动赋为主键值 BlogType blogType =
		 * new BlogType(blog.getId(), type.getId());
		 * this.blogTypeDao.addBlogType(blogType); } }
		 */

		// 新增维护“博客-类型”关系记录
		for (Type type : blog.getTypes()) {
			BlogType blogType = new BlogType(blog.getId(), type.getId());
			this.blogTypeDao.addBlogType(blogType);
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delBlog(Blog blog) throws Exception {
		// TODO Auto-generated method stub
		// 1删除属于博客的标签
		// 2删除维护“博客-类型”关系记录
		// 3删除博客
		for (Tag tag : blog.getTags()) {
			this.tagDao.delTag(tag);
		}
		this.blogTypeDao.delBlogTypeByBlogId(blog.getId());
		this.blogDao.delBlog(blog);
	}

	@Override
	public Blog findBlogById(int id) {
		// TODO Auto-generated method stub
		return this.blogDao.findBlogById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void editBlog(BlogTagType blogTagType) throws Exception {
		// TODO Auto-generated method stub
		if (blogTagType.getTagChanged() != null) {
			if (blogTagType.getTagChanged().equals("true")) {// 标签做了修改
				// 删除标签
				for (Tag tag : blogTagType.getDeleteTags()) {
					this.tagDao.delTag(tag);
				}
				// 添加和修改标签
				for (Tag tag : blogTagType.getNewTags()) {
					if (tag.getId() != 0) {// 说明是修改后的标签
						this.tagDao.editTag(tag);
					} else {// 说明是新增的标签
						this.tagDao.addTag(tag);
					}
				}
			}
		}
		if (blogTagType.getTypeChanged() != null) {
			if (blogTagType.getTypeChanged().equals("true")) {// 类型做了修改
				// 先将该博客关联类型记录删除，再写入新的记录
				this.blogTypeDao.delBlogTypeByBlogId(blogTagType.getBlog().getId());
				for (Type type : blogTagType.getTypes()) {
					BlogType blogType = new BlogType(blogTagType.getBlog().getId(), type.getId());
					this.blogTypeDao.addBlogType(blogType);
				}
			}
		}

		// 写入更新后的博客内容
		this.blogDao.editBlog(blogTagType.getBlog());
	}

	@Override
	public List<Blog> findBlogByTypeIdThroughAdmin(int typeId) {
		// TODO Auto-generated method stub
		return this.blogDao.findBlogByTypeIdThroughAdmin(typeId);
	}

	@Override
	public List<Blog> findBlogByTypeId(int typeId) {
		// TODO Auto-generated method stub
		return this.findBlogByTypeId(typeId);
	}

}
