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
@RequestMapping("/api/music")
public class MusicRestController {
	
	@Autowired
	private MusicJpaRepository musicRepo;
	
	@Autowired
	private GenreJpaRepository genreRepo;
	
	@RequestMapping(path="/{genreId}",method=RequestMethod.POST)
	public void addUser(@PathVariable(value="genreId") Integer genreId,@RequestBody Music newMusic) {
	
		Genre g = genreRepo.findById(genreId).orElse(null);
		g.getMusics().add(newMusic);
		musicRepo.saveAndFlush(newMusic);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT)
	@Transactional
	public void updateMusic(@RequestBody Music v) {
		
		Music existing = musicRepo.findById(v.getId()).orElse(null);
		existing.copy(v);
		musicRepo.saveAndFlush(existing);
	}
	
	
	@RequestMapping(path="/{id}",method=RequestMethod.DELETE)
	public void deleteMusic(@PathVariable int id) {
		
		musicRepo.deleteById(id);
	}
	
	
	@RequestMapping(path="/{id}",method=RequestMethod.GET)
	public Music retrieveMusic(@PathVariable int id) {
		
		return musicRepo.findById(id).orElse(null);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Music> retrieveMuiscs() {
		
		return musicRepo.findAll();
		
	}

	
}
