package buffs;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * App: Main entry point of buffs applications
 * Are you a movie or music buff, then buffs is for you? 
 * buffs is an app that provides information on films and music
 * 
 * 
 * @author J. Cosgrove
 */
@SpringBootApplication
public class App {
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(App.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);		
	}
	
}
