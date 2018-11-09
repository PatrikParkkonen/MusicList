package fi.haagahelia.project.MusicList;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import fi.haagahelia.project.MusicList.domain.Song;
import fi.haagahelia.project.MusicList.domain.Genre;
import fi.haagahelia.project.MusicList.domain.User;
import fi.haagahelia.project.MusicList.domain.SongRepository;
import fi.haagahelia.project.MusicList.domain.GenreRepository;
import fi.haagahelia.project.MusicList.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryTests {

    @Autowired
    private SongRepository srepository;
    
    @Autowired
    private GenreRepository grepository;
    
    @Autowired
    private UserRepository urepository;

   //Tests to make sure that the adding functions work properly
    
    @Test
    public void createNewSong() {
    	Song song = new Song("Valtiaan Uudet Vaateet", "Stam1na", "Nocebo", "4:34", 2012, new Genre("Metal"));
    	srepository.save(song);
    	assertThat(song.getId()).isNotNull();
    }
    
    @Test
    public void createNewGenre() {
    	Genre genre = new Genre("Testi");
    	grepository.save(genre);
    	assertThat(genre.getGenreid()).isNotNull();
    }
    
   @Test
   public void createNewUser() {
	   User user = new User("guest", "guest", "GUEST");
	   urepository.save(user);
	   assertThat(user.getUsername()).isNotNull();
   }

}