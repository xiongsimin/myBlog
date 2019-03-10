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
	int delTypeById(@Param("typeId") int typeId);

	/**
	 * 编辑文章分类
	 * 
	 * @param type
	 * @return
	 */
	int editType(Type type);

	/**
	 * 根据id查找文章类型
	 * 
	 * @param id
	 * @return
	 */
	Type findTypeById(@Param("id") int id);

	/**
	 * 根据类型名查找类型
	 * 
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
	 * 获取所有文章分类（管理员后台）
	 * 
	 * @return
	 */
	List<Type> getAllType();

	/**
	 * 获取主页允许显示的文章类型
	 * 
	 * @return
	 */
	List<Type> getShowType();

	/**
	 * 获取某类型文章的数量
	 * @param typeId
	 * @return
	 */
	int countBlog(@Param("typeId") int typeId);
}
