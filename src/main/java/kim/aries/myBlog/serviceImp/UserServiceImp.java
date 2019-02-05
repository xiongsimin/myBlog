package kim.aries.myBlog.serviceImp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kim.aries.myBlog.dao.UserDao;
import kim.aries.myBlog.domain.User;
import kim.aries.myBlog.service.UserService;
@Service("userService")
public class UserServiceImp implements UserService{
	@Resource
	private UserDao userdao; 
	@Override
	public User selectUserByName(String name){
		return userdao.selectUserByName(name);
	}
}
