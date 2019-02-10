package kim.aries.myBlog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kim.aries.myBlog.domain.Type;

@Mapper
public interface TypeDao {
	/**
	 * 新增文章类型
	 * 
	 * @param type
	 */
	int addType(Type type);

	/**
	 * 根据id删除文章类型
	 * 
	 * @param id
	 */
	int delTypeById(@Param("id") int id);

	/**
	 * 编辑文章分类
	 * 
	 * @param type
	 */
	int editTypeName(Type type);

	/**
	 * 根据id查找文章类型
	 * 
	 * @param id
	 * @return
	 */
	Type findTypeById(@Param("id") int id);

	/**
	 * 根据类型名查找类型
	 * @param typeName
	 * @return
	 */
	Type findTypeByName(@Param("typeName") String typeName);

	/**
	 * 查找对应博客的类型
	 * 
	 * @param id
	 * @return
	 */
	List<Type> findTypesByBlogId(@Param("id") int id);

	/**
	 * 获取所有文章分类
	 * 
	 * @return
	 */
	List<Type> getAllType();
}
