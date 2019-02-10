package kim.aries.myBlog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kim.aries.myBlog.domain.Tag;

@Mapper
public interface TagDao {
	/**
	 * 新增标签
	 * 
	 * @param tag
	 */
	int addTag(Tag tag);

	/**
	 * 删除标签
	 * 
	 * @param tag
	 */
	int delTag(Tag tag);

	/**
	 * 编辑标签
	 * 
	 * @param tag
	 */
	int editTag(Tag tag);

	/**
	 * 根据id查找标签
	 * 
	 * @param id
	 * @return
	 */
	Tag findTagById(@Param("id") int id);

	/**
	 * 查找某篇博客的所有标签
	 * 
	 * @param blogId
	 * @return
	 */
	List<Tag> findTagsByBlogId(@Param("blogId") int blogId);
}
