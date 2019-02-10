package kim.aries.myBlog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kim.aries.myBlog.domain.BlogType;

@Mapper
public interface BlogTypeDao {
	/**
	 * 新增“博客-类型”关系维护记录
	 * 
	 * @param blogType
	 * @return
	 */
	int addBlogType(BlogType blogType);

	/**
	 * 删除维护记录（由删除博客引起的）
	 * 
	 * @param blogId
	 * @return
	 */
	int delBlogTypeByBlogId(@Param("blogId") int blogId);
}
