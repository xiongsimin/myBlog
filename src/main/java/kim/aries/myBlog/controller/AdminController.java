package kim.aries.myBlog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import kim.aries.myBlog.domain.Admin;
import kim.aries.myBlog.service.AdminService;
import kim.aries.myBlog.util.HttpUtil;

/**
 * 
 * @author 白羊座
 *
 */
@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;

	/**
	 * 处理登录请求
	 * 
	 * @param id
	 * @param password
	 * @return
	 */
	@PostMapping("/login")
	String login(int id, String password) {
		Admin admin = this.adminService.findAdminById(id);
		if (admin != null) {
			if (admin.getPassword().equals(password)) {
				HttpSession session = HttpUtil.getSession();
				session.setAttribute("login", "true");
				session.setAttribute("id", admin.getId());
				return "登录成功！";
			} else {
				return "账号密码不匹配！";
			}
		} else {
			return "账号不存在！";
		}
	}

	/**
	 * 处理修改管理员昵称请求
	 * 
	 * @param name
	 * @param id
	 * @return
	 */
	@PostMapping("/editAdminName")
	String editAdminName(String name, @SessionAttribute("id") int id) {
		Admin admin = this.adminService.findAdminById(id);
		if (admin.getName().equals(name)) {
			return "未做任何修改！";
		}
		admin.setName(name);
		this.adminService.editAdminName(admin);
		return "修改成功！";
	}

	/**
	 * 处理修改密码请求
	 * 
	 * @param oldPassword
	 * @param newPassword
	 * @param id
	 * @return
	 */
	@PostMapping("/changePassword")
	String changePassword(String oldPassword, String newPassword, @SessionAttribute("id") int id) {
		Admin admin = this.adminService.findAdminById(id);
		if (!admin.getPassword().equals(oldPassword)) {
			return "密码修改失败！【原密码错误】";
		} else {
			if (oldPassword.equals(newPassword)) {
				return "密码修改失败！【新旧密码相同】";
			} else {
				admin.setPassword(newPassword);
				this.adminService.changePassword(admin);
				return "密码修改成功！";
			}
		}
	}
}
