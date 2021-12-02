package parse;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Info{

	@SerializedName("literature")
	private List<String> literature;

	@SerializedName("schedule")
	private String schedule;

	@SerializedName("links")
	private List<LinksItem> links;

	public List<String> getLiterature(){
		return literature;
	}

	public String getSchedule(){
		return schedule;
	}

	public List<LinksItem> getLinks(){
		return links;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
}