package kim.aries.myBlog.service;

import kim.aries.myBlog.domain.User;

public interface UserService {
	User selectUserByName(String name);
}
