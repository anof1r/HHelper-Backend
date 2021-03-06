package parse;

import com.google.gson.annotations.SerializedName;

public class ResponseItem{

	@SerializedName("date")
	private String date;

	@SerializedName("imageId")
	private int imgId;

	@SerializedName("homeWork")
	private String homeWork;

	@SerializedName("id")
	private Integer id;

	@SerializedName("title")
	private String title;

	@SerializedName("content")
	private String content;

	public String getDate(){
		return date;
	}

	public int getImageId(){
		return imgId;
	}

	public String getHomeWork(){
		return homeWork;
	}

	public int getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public String getContent(){
		return content;
	}
}