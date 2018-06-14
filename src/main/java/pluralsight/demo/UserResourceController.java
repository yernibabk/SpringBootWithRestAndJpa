package pluralsight.demo;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResourceController {

	@Autowired
	UserRepository repository;
	

	@GetMapping("/users")
	public List<User> getUsers() {
		return repository.getUsers();
	}
	
	@GetMapping("/users/{id}")
	public Resource<User> getUsers(@PathVariable("id") Integer id) {
		User user =  repository.getUser(id);
		if (user == null) {
			throw new UserNotFoundException("Id - NotFound");
		}
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder link = linkTo(methodOn(this.getClass()).getUsers());
		resource.add(link.withRel("all-users"));
		return resource;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		User usr = repository.deleteUser(id);
		if (usr == null) {
			throw new UserNotFoundException("Id"+id);
		}
	}
	
	@PostMapping("/users") 
	public ResponseEntity<?> saveUser(@Valid @RequestBody User user) {
		User saveUser = repository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
