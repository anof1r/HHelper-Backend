package parse;

import com.google.gson.annotations.SerializedName;

public class LinksItem{

	@SerializedName("description")
	private String description;

	@SerializedName("href")
	private String href;

	public String getDescription(){
		return description;
	}

	public String getHref(){
		return href;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setHref(String href) {
		this.href = href;
	}
}