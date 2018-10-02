package restlabpackage.repos;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import restlabpackage.Genre;

public interface GenreJpaRepository extends JpaRepository<Genre, Integer> {

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<Genre> findById(Integer id);
}
