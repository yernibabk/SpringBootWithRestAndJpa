package pluralsight.demo;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResourceController {

	@Autowired
	MessageSource messageSource;

	@GetMapping(path="/hello")
	public String getMessage() {
		return "Good Morning";
	}
	@GetMapping(path="/hello-world-internationalization")
	public String helloWorldInternalized(@RequestHeader(name="Accept-Language", required =false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}
	
	
	
}
