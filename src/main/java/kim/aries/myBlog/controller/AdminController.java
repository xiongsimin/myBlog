package kim.aries.myBlog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import kim.aries.myBlog.domain.Admin;
import kim.aries.myBlog.domain.Result;
import kim.aries.myBlog.service.AdminService;
import kim.aries.myBlog.util.HttpUtil;

/**
 * 
 * @author 白羊座
 *
 */
@CrossOrigin
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
	Result login(int id, String password, Result result) {
		Admin admin = this.adminService.findAdminById(id);
		if (admin != null) {
			if (admin.getPassword().equals(password)) {
				HttpSession session = HttpUtil.getSession();
				session.setAttribute("login", "true");
				session.setAttribute("id", admin.getId());
				result.setMsg("登陆成功！");
				result.setSuccess(true);
			} else {
				result.setMsg("账号密码不匹配！");
				result.setSuccess(false);
			}
		} else {
			result.setMsg("账号不存在！");
			result.setSuccess(false);
		}
		return result;
	}

	/**
	 * 处理修改管理员昵称请求
	 * 
	 * @param name
	 * @param id
	 * @return
	 */
	@PostMapping("/editAdminName")
	Result editAdminName(String name, @SessionAttribute("id") int id, Result result) {
		Admin admin = this.adminService.findAdminById(id);
		if (admin.getName().equals(name)) {
			result.setSuccess(false);
			result.setMsg("未做任何修改！");
			return result;
		}
		admin.setName(name);
		this.adminService.editAdminName(admin);
		result.setSuccess(true);
		result.setMsg("修改成功！");
		return result;
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
	Result changePassword(String oldPassword, String newPassword, @SessionAttribute("id") int id, Result result) {
		Admin admin = this.adminService.findAdminById(id);
		if (!admin.getPassword().equals(oldPassword)) {
			result.setMsg("密码修改失败！【原密码错误】");
			result.setSuccess(false);
		} else {
			if (oldPassword.equals(newPassword)) {
				result.setMsg("修改成功！");
				result.setSuccess(true);
			} else {
				admin.setPassword(newPassword);
				this.adminService.changePassword(admin);
				result.setMsg("密码修改失败！【原密码错误】");
				result.setSuccess(false);
			}
		}
		return result;
	}
}
