package fi.haagahelia.project.MusicList;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.project.MusicList.web.MusicListController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {
	
	@Autowired
	private MusicListController controller;
	
	//Tests to see if controller exists
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
