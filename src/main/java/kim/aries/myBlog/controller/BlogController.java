package kim.aries.myBlog.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kim.aries.myBlog.domain.Blog;
import kim.aries.myBlog.domain.BlogTagType;
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
		if (blog != null) {
			try {
				this.blogService.delBlog(blog);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "删除失败！";
			}
			return "删除成功！";
		} else {
			return "该博客不存在！";
		}

	}

	/**
	 * 修改博客 分类设计：在博客下面，分类只能新增（勾选已存在类型）或删除（针对该篇博客），不能编辑 真正意义上对分类的增删改查在单独的页面实现
	 */
	@PostMapping("/editBlog")
	String editBlog(@RequestBody BlogTagType blogTagType) {
		// 修改博客最后一次更新时间
		Timestamp updateTime = new Timestamp(new Date().getTime());
		Blog blog = blogTagType.getBlog();
		blog.setUpdateTime(updateTime);
		blogTagType.setBlog(blog);
		try {
			this.blogService.editBlog(blogTagType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "修改失败！";
		}
		return "修改成功！";
	}

	@PostMapping("/findBlog")
	String findBlog(int id) {
		Blog blog = this.blogService.findBlogById(id);
		return blog.toString();
	}

	@GetMapping("/findBlogByTypeIdThroughAdmin")
	String findBlogByTypeIdThroughAdmin(int typeId) {
		return this.blogService.findBlogByTypeIdThroughAdmin(typeId).toString();
	}

	@GetMapping("/findBlogByTypeId")
	String findBlogByTypeId(int typeId) {
		return this.blogService.findBlogByTypeId(typeId).toString();
	}
}
