package restlabpackage;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import restlabpackage.repos.PictureMongoRepository;

@RestController
@RequestMapping("/api/picture")
public class PictureRestController {
	
	@Autowired
	private PictureMongoRepository picturerepo;
	
	@RequestMapping(method=RequestMethod.POST)
	public void addPicture( @RequestBody Picture newPic) {
		
		picturerepo.save(newPic);
		
	}

	
	@RequestMapping(method=RequestMethod.PUT)
	@Transactional
	public void updatePicture(@RequestBody Picture p) {
		
		Picture existingPicture = picturerepo.findById(p.getId()).orElse(null);
		existingPicture.copy(p);
		picturerepo.save(existingPicture);
		
	}
	
	
	@RequestMapping(path="/{id}",method=RequestMethod.DELETE)
	public void deletePicture(@PathVariable String id) {
		
		picturerepo.deleteById(id);;
	}
	
	
	@RequestMapping(path="/{id}",method=RequestMethod.GET)
	public Picture retrievePicture(@PathVariable String id) {
		
		return picturerepo.findById(id).orElse(null);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Picture> retrievePictures() {
		
		return picturerepo.findAll();
	}

}
