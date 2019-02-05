package kim.aries.myBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kim.aries.myBlog.domain.User;
import kim.aries.myBlog.service.UserService;
@Controller
public class UserController {
	@Autowired
	UserService userservice;
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public String user(ModelMap map){
		User user=userservice.selectUserByName("xiong");
		map.addAttribute("user", user);
		return "hello";
	}
}
