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

	/**
	 * 查找属于某类型的博客（管理员后台）
	 * 
	 * @param typeId
	 * @return
	 */
	List<Blog> findBlogByTypeIdThroughAdmin(@Param("typeId") int typeId);

	/**
	 * 查找属于某类型的博客（主页）
	 * 
	 * @param typeId
	 * @return
	 */
	List<Blog> findBlogByTypeId(@Param("typeId") int typeId);

	/**
	 * 获取最近的10篇博客
	 * 
	 * @return
	 */
	List<Blog> getTopTenBlogs();
}
