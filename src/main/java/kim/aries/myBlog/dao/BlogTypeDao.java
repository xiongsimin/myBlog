package kim.aries.myBlog.dao;

import org.apache.ibatis.annotations.Mapper;

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

}
