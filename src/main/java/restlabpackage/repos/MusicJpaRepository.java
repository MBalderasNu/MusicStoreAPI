package restlabpackage.repos;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import restlabpackage.Music;


public interface MusicJpaRepository extends JpaRepository<Music, Integer> {

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<Music> findById(Integer id);
}
