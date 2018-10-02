package restlabpackage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import restlabpackage.repos.GenreJpaRepository;
import restlabpackage.repos.MusicJpaRepository;

@RestController
@RequestMapping("/api/genre")
public class GenreRestController {
	
	
	@Autowired
	private GenreJpaRepository genreRepo;

	@RequestMapping(method=RequestMethod.POST)
	public void addGenre( @RequestBody Genre newGenre) {
		
		genreRepo.saveAndFlush(newGenre);
		
	}

	
	@RequestMapping(method=RequestMethod.PUT)
	@Transactional
	public void updateGenre(@RequestBody Genre g) {
		
		Genre existingGenre = genreRepo.findById(g.getId()).orElse(null);
		existingGenre.copy(g);
		genreRepo.saveAndFlush(existingGenre);
		
	}
	
	
	@RequestMapping(path="/{id}",method=RequestMethod.DELETE)
	public void deleteGenre(@PathVariable Integer id) {
		
		genreRepo.deleteById(id);
	}
	
	
	@RequestMapping(path="/{id}",method=RequestMethod.GET)
	public Genre retrieveGenre(@PathVariable Integer id) {
		
		return genreRepo.findById(id).orElse(null);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Genre> retrieveGenres() {
		
		return genreRepo.findAll();
	}
}
