package kim.aries.myBlog.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kim.aries.myBlog.domain.Blog;
import kim.aries.myBlog.service.BlogService;

@RestController
public class BlogController {
	@Autowired
	private BlogService blogService;

	@PostMapping("/addBlog")
	String addBlog(@RequestBody Blog blog) {
		Timestamp createTime = new Timestamp(new Date().getTime());
		blog.setCreateTime(createTime);
		try {
			this.blogService.addBlog(blog);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("添加博客失败！");
			return "添加失败！";
		}
		return "添加成功！";
	}

	@PostMapping("/delBlog")
	String delBlog(int id) {
		Blog blog = this.blogService.findBlogById(id);
		try {
			this.blogService.delBlog(blog);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "删除失败！";
		}
		return "删除成功！";
	}

	@PostMapping("/findBlog")
	String findBlog(int id) {
		Blog blog = this.blogService.findBlogById(id);
		return blog.toString();
	}
}
