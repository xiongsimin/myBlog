package kim.aries.myBlog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kim.aries.myBlog.domain.Blog;

@Mapper
public interface BlogDao {
	/**
	 * 新增博客
	 * 
	 * @param blog
	 */
	int addBlog(Blog blog);

	/**
	 * 删除博客
	 * 
	 * @param blog
	 */
	int delBlog(Blog blog);

	/**
	 * 修改博客
	 * 
	 * @param blog
	 */
	int editBlog(Blog blog);

	/**
	 * 通过id查找博客
	 * 
	 * @param id
	 * @return
	 */
	Blog findBlogById(@Param("id") int id);

	/**
	 * 根据关键字搜索博客
	 * 
	 * @param key
	 *            标题关键字
	 * @return
	 */
	List<Blog> searchBlogByKey(@Param("key") String key);

	void getM();
}