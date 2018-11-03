package fi.haagahelia.project.MusicList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import fi.haagahelia.project.MusicList.domain.Song;
import fi.haagahelia.project.MusicList.domain.SongRepository;
import fi.haagahelia.project.MusicList.domain.Genre;
import fi.haagahelia.project.MusicList.domain.GenreRepository;
import fi.haagahelia.project.MusicList.domain.User;
import fi.haagahelia.project.MusicList.domain.UserRepository;


@SpringBootApplication
public class MusicListApplication {
	private static final Logger log = LoggerFactory.getLogger(MusicListApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MusicListApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(SongRepository srepository, GenreRepository grepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a few test songs");
			
			grepository.save(new Genre("Ballad"));
			grepository.save(new Genre("Post-Hardcore"));
			grepository.save(new Genre("Classical"));
			grepository.save(new Genre("Pop"));
			grepository.save(new Genre("Rock"));
			grepository.save(new Genre("J-Rock/Pop"));
			grepository.save(new Genre("Metal"));
			
			srepository.save(new Song("Constellations", "Enter Shikari", "A Flash Flood of Colour", "5:01", 2012, grepository.findByName("Ballad").get(0)));
			srepository.save(new Song("Shandy", "TK from Ling Tosite Sigure", "Signal", "4:36", 2016, grepository.findByName("Post-Hardcore").get(0)));
			srepository.save(new Song("Valtiaan Uudet Vaateet", "Stam1na", "Nocebo", "3:44", 2012, grepository.findByName("Metal").get(0)));
			
			
			User user1 = new User("admin", "$2a$10$IerqdbSAwndVhZVyn1tLuOLLDxegXFVlMaUdGZBrOEzsDB1yFZft.", "ADMIN");
			User user2 = new User("guest", "$2a$10$mzjMJJMOXhGxIUEtMJV3hu/r8kRTVr0ye47oTJL49Pi20IgY3XDs.", "GUEST");
			urepository.save(user1);
			urepository.save(user2);
			
			
			log.info("fetch all songs");
			for (Song Song : srepository.findAll()) {
				log.info(Song.toString());
			}
		};

	}
	
}
