package kim.aries.myBlog.serviceImp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kim.aries.myBlog.dao.AdminDao;
import kim.aries.myBlog.domain.Admin;
import kim.aries.myBlog.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Resource
	private AdminDao adminDao;

	@Override
	public Admin findAdminById(int id) {
		// TODO Auto-generated method stub
		
		return this.adminDao.findAdminById(id);
	}

	@Override
	public void editAdminName(Admin admin) {
		// TODO Auto-generated method stub
		this.adminDao.editAdminName(admin);

	}

	@Override
	public void changePassword(Admin admin) {
		// TODO Auto-generated method stub
		this.adminDao.changePassword(admin);
	}

}
