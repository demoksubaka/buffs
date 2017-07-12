package buffs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Album {
	private String name; 
	private String artist; 
	private String url;
	private Wiki wiki;
	
	public Album() {
		super();
	}
	
	@Override
	public String toString() {
		return "\n  name=" + name + "\n  artist=" + artist + "\n  url=" + url + wiki;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Wiki getWiki() {
		return wiki;
	}

	public void setWiki(Wiki wiki) {
		this.wiki = wiki;
	}

}
