package pluralsight.demo.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonResourceController {

	@GetMapping("/personV1-name") 
	public PersonV1 getName() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping("/personV2-name") 
	public PersonV2 getNameV2() {
		return new PersonV2("Bob" ," Charlie");
	}
	
	@GetMapping(value="/person/param", params = "version=1") 
	public PersonV1 paramV1() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(value="/person/param", params = "version=2" ) 
	public PersonV2 paramV2() {
		return new PersonV2("Bob" ," Charlie");
	}
	
	@GetMapping(value="/person/header", headers = "X-API-VERSION=1") 
	public PersonV1 headerV1() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(value="/person/header", headers = "X-API-VERSION=2") 
	public PersonV2 headerV2() {
		return new PersonV2("Bob" ," Charlie");
	}
	
	@GetMapping(value="/person/produces", produces = "application/vnd.company.api.v1+json") 
	public PersonV1 producesV1() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(value="/person/produces", produces = "application/vnd.company.api.v2+json") 
	public PersonV2 producesV2() {
		return new PersonV2("Bob" ," Charlie");
	}
}
