package kim.aries.myBlog.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class Blog implements Serializable {
	private int id;
	private String title;
	private String content;
	private Timestamp createTime;
	private Timestamp updateTime;
	private List<Tag> tags;
	private List<Type> types;

	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Blog( String title, String content, Timestamp createTime, Timestamp updateTime, List<Tag> tags,
			List<Type> types) {
		super();
		this.title = title;
		this.content = content;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.tags = tags;
		this.types = types;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Type> getTypes() {
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", content=" + content + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", tags=" + tags + ", types=" + types + "]";
	}

}
