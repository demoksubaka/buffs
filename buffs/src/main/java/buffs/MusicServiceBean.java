package buffs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class MusicServiceBean implements MusicService {

	public static final String RETRIEVE_ALBUM = "Looking for album information";
	public static final String NO_ALBUM = "Could not retrieve information. Please check artist or album name";
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	private RestTemplate restTemplate;
	
	public MusicServiceBean(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	@Override
	public void getAlbumInformation(String artist, String album) {
		log.info(RETRIEVE_ALBUM);		
		LastFMResponse lastFMResponse = restTemplate.getForObject(
				"http://ws.audioscrobbler.com/2.0/?method=album.getinfo&api_key=5150e22bc9a3594bc69a2c114cc446ae&artist={art}&album={alb}&format=json",
			    LastFMResponse.class, artist, album);

		String response = (lastFMResponse.getAlbum() == null) ? NO_ALBUM : lastFMResponse.toString();
		log.info(response);	
	}

}
