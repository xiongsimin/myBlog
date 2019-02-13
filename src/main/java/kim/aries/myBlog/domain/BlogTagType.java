package kim.aries.myBlog.domain;

import java.util.List;

/**
 * 用于处理编辑博客请求时接收标签、类型更改情况参数
 * 
 * @author 白羊座
 *
 */
public class BlogTagType {
	private Blog blog;
	private String tagChanged;// 标签是否发生变化
	private String typeChanged;// 类型是否变化
	private List<Tag> deleteTags;// 待删除的标签
	private List<Tag> newTags;// 编辑后的标签（新增的只有name没有id，修改的有id）
	private List<Type> types;

	public BlogTagType(Blog blog, String tagChanged, String typeChanged, List<Tag> deleteTags, List<Tag> newTags,
			List<Type> types) {
		super();
		this.blog = blog;
		this.tagChanged = tagChanged;
		this.typeChanged = typeChanged;
		this.deleteTags = deleteTags;
		this.newTags = newTags;
		this.types = types;
	}

	public BlogTagType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public String getTagChanged() {
		return tagChanged;
	}

	public void setTagChanged(String tagChanged) {
		this.tagChanged = tagChanged;
	}

	public String getTypeChanged() {
		return typeChanged;
	}

	public void setTypeChanged(String typeChanged) {
		this.typeChanged = typeChanged;
	}

	public List<Tag> getDeleteTags() {
		return deleteTags;
	}

	public void setDeleteTags(List<Tag> deleteTags) {
		this.deleteTags = deleteTags;
	}

	public List<Tag> getNewTags() {
		return newTags;
	}

	public void setNewTags(List<Tag> newTags) {
		this.newTags = newTags;
	}

	public List<Type> getTypes() {
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}

	@Override
	public String toString() {
		return "BlogTagType [blog=" + blog + ", tagChanged=" + tagChanged + ", typeChanged=" + typeChanged
				+ ", deleteTags=" + deleteTags + ", newTags=" + newTags + ", types=" + types + "]";
	}

}
