package kim.aries.myBlog.service;

import kim.aries.myBlog.domain.Blog;

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
	 * 根据id查找博客
	 * 
	 * @param id
	 * @return
	 */
	Blog findBlogById(int id);
}
