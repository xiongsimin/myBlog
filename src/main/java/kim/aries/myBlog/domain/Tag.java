package kim.aries.myBlog.domain;

import java.io.Serializable;

public class Tag implements Serializable {
	private int id;
	private String tagName;
	private int blogId;
	private Blog blog;

	public Tag() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tag(int id, String tagName, int blogId, Blog blog) {
		super();
		this.id = id;
		this.tagName = tagName;
		this.blogId = blogId;
		this.blog = blog;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", tagName=" + tagName + ", blogId=" + blogId + ", blog=" + blog + "]";
	}

}
