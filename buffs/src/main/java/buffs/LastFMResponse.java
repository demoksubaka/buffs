package buffs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class LastFMResponse {
	private Album album;

	public LastFMResponse() {
		super();
	}

	@Override
	public String toString() {
		return "\n\nLastFMResponse album summary:\n" + album;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

}
