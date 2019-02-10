package kim.aries.myBlog.domain;

import java.io.Serializable;
import java.util.List;

public class Type implements Serializable {
	private int id;
	private String typeName;
	private List<Blog> blogs;

	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Type(String typeName) {
		super();
		this.typeName = typeName;
	}

	public Type(int id, String typeName, List<Blog> blogs) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.blogs = blogs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	@Override
	public String toString() {
		return "Type [id=" + id + ", typeName=" + typeName + ", blogs=" + blogs + "]";
	}

}
