package kim.aries.myBlog.domain;

import java.io.Serializable;

public class BlogType implements Serializable {
	private int blogId;
	private int typeId;

	public BlogType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BlogType(int blogId, int typeId) {
		super();
		this.blogId = blogId;
		this.typeId = typeId;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "BlogType [blogId=" + blogId + ", typeId=" + typeId + "]";
	}

}
