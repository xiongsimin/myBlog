package kim.aries.myBlog.service;

import kim.aries.myBlog.domain.Admin;

public interface AdminService {
	/**
	 * 根据id查找Admin
	 * 
	 * @param id
	 * @return
	 */
	Admin findAdminById(int id);

	/**
	 * 修改昵称
	 * 
	 * @param admin
	 */
	void editAdminName(Admin admin);

	/**
	 * 修改密码
	 * 
	 * @param admin
	 */
	void changePassword(Admin admin);
}
