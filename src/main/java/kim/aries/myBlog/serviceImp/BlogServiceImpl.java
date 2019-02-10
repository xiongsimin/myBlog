package kim.aries.myBlog.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kim.aries.myBlog.dao.BlogDao;
import kim.aries.myBlog.dao.BlogTypeDao;
import kim.aries.myBlog.dao.TagDao;
import kim.aries.myBlog.dao.TypeDao;
import kim.aries.myBlog.domain.Blog;
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
		for (Type type : blog.getTypes()) {
			// 1.先判断类型是否存在（存在：直接第2步；不存在：先新增类型再执行第2步）
			// 2.再新增维护“博客-类型”关系记录
			Type tempType = this.typeDao.findTypeByName(type.getTypeName());
			if (tempType != null) {// 非空说明已存在，直接第2步
				BlogType blogType = new BlogType(blog.getId(), tempType.getId());
				this.blogTypeDao.addBlogType(blogType);
			} else {
				this.typeDao.addType(type);// 新增后该对象的id会自动赋为主键值
				BlogType blogType = new BlogType(blog.getId(), type.getId());
				this.blogTypeDao.addBlogType(blogType);
			}
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

}
