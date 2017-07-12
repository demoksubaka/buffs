package buffs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class MainController implements CommandLineRunner {
	
	public static final String MUSIC_SERVICE = "lastfm";
	public static final String MOVIE_SERVICE = "tmdb";
	public static final String UNKNOWN = "queryunknownquery";
	public static final String USAGE = "\n\n Usage\n    for movies: java -Dapi=tmbd -DmovieName=<name of the movie> query.jar"
			+ "\n    for music:  java -Dapi=lastfm -Dartist=<name of the artist> -Dalbum=<name of the album> query.jar"
			+ "\n\n    Example: java -Dapi=tmbd -DmovieName=\"apes\" query.jar"
			+ "\n    Above example will return a list of all movies with apes in their name\n\n";
	

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Value("#{systemProperties['api'] ?: 'queryUnknownAPI'}")
	private String api;

	@Value("#{systemProperties['artist'] ?: 'queryUnknownArtist'}")
	private String artist;

	@Value("#{systemProperties['album'] ?: 'queryUnknownAlbum'}")
	private String album;

	@Value("#{systemProperties['movieName'] ?: 'queryUnknownMovie'}")
	private String movieName;
	
	@Autowired
	private MusicService musicService;

	@Autowired
	private MovieService movieService;

	@Override
	public void run(String... args) throws Exception {
		if (isValidSystemProperties()) {
			if (MUSIC_SERVICE.equals(api)) {
				musicService.getAlbumInformation(artist, album);
			} else if(MOVIE_SERVICE.equals(api)) {
				movieService.getMovieInformation(movieName);
			} 
		} else {
			log.info(USAGE);
		}			
	}

	private boolean isValidSystemProperties() {
		if ("queryUnknownAPI".equals(api))
			return false;
		if (MUSIC_SERVICE.equals(api) && isUnknownArtistOrAlbum())
			return false;
		if (MOVIE_SERVICE.equals(api) && isUnknownMovieName())
			return false;
		
		return true;
	}

	private boolean isUnknownMovieName() {
		return "queryUnknownMovie".equals(movieName);		
	}

	private boolean isUnknownArtistOrAlbum() {
		return ("queryUnknownArtist".equals(artist) || "queryUnknownAlbum".equals(album));
	}

}
