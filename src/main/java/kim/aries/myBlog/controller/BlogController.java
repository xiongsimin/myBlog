package kim.aries.myBlog.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kim.aries.myBlog.domain.Blog;
import kim.aries.myBlog.domain.BlogTagType;
import kim.aries.myBlog.domain.Result;
import kim.aries.myBlog.service.BlogService;

@RestController
public class BlogController {
	@Autowired
	private BlogService blogService;

	@PostMapping("/addBlog")
	Result addBlog(@RequestBody Blog blog, Result result) {
		Timestamp createTime = new Timestamp(new Date().getTime());
		blog.setCreateTime(createTime);
		try {
			this.blogService.addBlog(blog);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("添加博客失败！");
			result.setMsg("添加失败！");
			result.setSuccess(false);
			return result;
		}
		result.setMsg("添加成功！");
		result.setSuccess(true);
		return result;
	}

	@PostMapping("/delBlog")
	Result delBlog(int id, Result result) {
		Blog blog = this.blogService.findBlogById(id);
		if (blog != null) {
			try {
				this.blogService.delBlog(blog);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result.setMsg("删除失败！");
				result.setSuccess(false);
				return result;
			}
			result.setMsg("删除成功！");
			result.setSuccess(true);
			return result;
		} else {
			result.setMsg("该博客不存在！");
			result.setSuccess(false);
			return result;
		}

	}

	/**
	 * 修改博客 分类设计：在博客下面，分类只能新增（勾选已存在类型）或删除（针对该篇博客），不能编辑 真正意义上对分类的增删改查在单独的页面实现
	 */
	@PostMapping("/editBlog")
	Result editBlog(@RequestBody BlogTagType blogTagType, Result result) {
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
			result.setMsg("修改失败！");
			result.setSuccess(false);
			return result;
		}
		result.setMsg("修改成功！");
		result.setSuccess(true);
		return result;
	}

	@PostMapping("/findBlog")
	Result findBlog(int id, Result result) {
		Blog blog = this.blogService.findBlogById(id);
		result.setSuccess(true);
		result.setData(blog);
		return result;
	}

	@GetMapping("/findBlogByTypeIdThroughAdmin")
	Result findBlogByTypeIdThroughAdmin(int typeId, Result result) {
		List<Blog> blogList = this.blogService.findBlogByTypeIdThroughAdmin(typeId);
		result.setSuccess(true);
		result.setData(blogList);
		return result;
	}

	@GetMapping("/findBlogByTypeId")
	Result findBlogByTypeId(int typeId, Result result) {
		List<Blog> blogList = this.blogService.findBlogByTypeId(typeId);
		result.setSuccess(true);
		result.setData(blogList);
		return result;
	}
}
