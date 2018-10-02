package restlabpackage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import restlabpackage.repos.UserJpaRepository;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
	
	
	@Autowired
	private UserJpaRepository userRepo;
	
	@RequestMapping(method=RequestMethod.POST)
	public void addUser( @RequestBody User newUser) {
		
		userRepo.saveAndFlush(newUser);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	@Transactional
	public void updateUser(@RequestBody User u) {
		
		User existing = userRepo.findById(u.getId()).orElse(null);
		existing.copy(u);
		userRepo.saveAndFlush(u);
		
	}
	
	
	@RequestMapping(path="/{id}",method=RequestMethod.DELETE)
	public void deleteUser(@PathVariable int id) {
		
		userRepo.deleteById(id);
	}
	
	
	@RequestMapping(path="/{id}",method=RequestMethod.GET)
	public User retrieveUser(@PathVariable int id) {
		
		return userRepo.findById(id).orElse(null);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<User> retrieveUsers() {
		
		return userRepo.findAll();
	}

	

}
