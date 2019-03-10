package kim.aries.myBlog.domain;

import java.io.Serializable;
import java.util.List;

public class Type implements Serializable {
	private int id;
	private String typeName;
	private int show;
	private int count;//该类型下文章数量
	private List<Blog> blogs;

	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Type(int id, String typeName, int show, int count, List<Blog> blogs) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.show = show;
		this.count = count;
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

	public int getShow() {
		return show;
	}

	public void setShow(int show) {
		this.show = show;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Type [id=" + id + ", typeName=" + typeName + ", show=" + show + ", count=" + count + ", blogs=" + blogs
				+ "]";
	}

}
