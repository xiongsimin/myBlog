package kim.aries.myBlog.dao;

import org.apache.ibatis.annotations.Mapper;

import kim.aries.myBlog.domain.User;

@Mapper
public interface UserDao {
	User selectUserByName(String name);
}
