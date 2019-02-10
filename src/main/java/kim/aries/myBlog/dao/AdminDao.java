package kim.aries.myBlog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kim.aries.myBlog.domain.Admin;
@Mapper
public interface AdminDao {
	/**
	 * 根据id查找Admin
	 * 
	 * @param id
	 * @return
	 */
	Admin findAdminById(@Param("id") int id);

	/**
	 * 修改昵称
	 * 
	 * @param admin
	 */
	void editAdminName(Admin admin);

	/**
	 * 修改密码
	 * @param admin
	 */
	void changePassword(Admin admin);
}
