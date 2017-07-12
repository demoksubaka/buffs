package buffs;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TmdbResponse {
	int page;
	
	private ArrayList<Results> results = new ArrayList<>();

	public TmdbResponse() {
		super();
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public ArrayList<Results> getResults() {
		return results;
	}

	public void setResults(ArrayList<Results> results) {
		this.results = results;
	}

	@Override
	public String toString() {	
		return "\n\nThe movie results from tmdb are \n" + results;
	}
	
	


}
