package kim.aries.myBlog.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kim.aries.myBlog.domain.Blog;
import kim.aries.myBlog.domain.BlogTagType;

public interface BlogService {
	/**
	 * 新增博客
	 * 
	 * @param blog
	 * @throws Exception
	 */
	void addBlog(Blog blog) throws Exception;

	/**
	 * 删除博客
	 * 
	 * @param blog
	 * @throws Exception
	 */
	void delBlog(Blog blog) throws Exception;

	/**
	 * 编辑博客
	 * 
	 * @param blog
	 * @return
	 * @throws Exception
	 */
	void editBlog(BlogTagType blogTagType) throws Exception;

	/**
	 * 根据id查找博客
	 * 
	 * @param id
	 * @return
	 */
	Blog findBlogById(int id);

	/**
	 * 查找属于某类型的博客（管理员后台）
	 * 
	 * @param typeId
	 * @return
	 */
	List<Blog> findBlogByTypeIdThroughAdmin(int typeId);

	/**
	 * 查找属于某类型的博客（主页）
	 * 
	 * @param typeId
	 * @return
	 */
	List<Blog> findBlogByTypeId(int typeId);

	/**
	 * 获取最近的10篇博客
	 * 
	 * @return
	 */
	List<Blog> getTopTenBlogs();
}
