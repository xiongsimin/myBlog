package kim.aries.myBlog.service;

import java.util.List;

import kim.aries.myBlog.domain.Type;

public interface TypeService {
	/**
	 * 新增类型
	 * 
	 * @param type
	 * @return
	 */
	int addType(Type type);

	/**
	 * 删除类型
	 * 
	 * @param type
	 * @return
	 */
	int delTypeById(int typeId);

	/**
	 * 编辑文章分类
	 * 
	 * @param type
	 * @return
	 */
	int editType(Type type);

	/**
	 * 获取所有类型（管理员后台）
	 * 
	 * @return
	 */
	List<Type> getAllType();

	/**
	 * 获取主页允许显示的所有类型
	 * 
	 * @return
	 */
	List<Type> getShowType();
}
