package buffs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieServiceBean implements MovieService {

	public static final String RETRIEVE_MOVIE = "Looking for movie information";
	public static final String NO_MOVIE = "Could not retrieve information. Please check movie name";
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	private RestTemplate restTemplate;
	
	public MovieServiceBean(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	@Override
	public void getMovieInformation(String movieName) {
		log.info(RETRIEVE_MOVIE);		
		TmdbResponse tmdbResponse = restTemplate.getForObject(
				"https://api.themoviedb.org/3/search/movie?api_key=24c6d84e2435ad56ac58a92f91947bfa&query={movie}&",
				TmdbResponse.class, movieName);

		String response = 
				(tmdbResponse.getResults() == null || tmdbResponse.getResults().isEmpty() ) 
				? NO_MOVIE : tmdbResponse.toString();
		
		log.info(response);	
	}

}
