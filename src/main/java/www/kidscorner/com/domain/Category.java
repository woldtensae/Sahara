package www.kidscorner.com.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Category {
	private Long id;
	private String categoryNmae;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategoryNmae() {
		return categoryNmae;
	}
	public void setCategoryNmae(String categoryNmae) {
		this.categoryNmae = categoryNmae;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryNmae=" + categoryNmae + "]";
	}
}
