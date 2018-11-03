package fi.haagahelia.project.MusicList.domain;

import org.springframework.data.repository.CrudRepository;

import fi.haagahelia.project.MusicList.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);

}