package pluralsight.demo;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication

public class PluralsightSpringcloudM1StartupApplication {

	public static void main(String[] args) {
		SpringApplication.run(PluralsightSpringcloudM1StartupApplication.class, args);
	}
	
/*	@RequestMapping(value="/greeting")
	public String SayHello(){
		
		return "Hi, from Spring Boot!";
	}*/
	
	@Bean
	public LocaleResolver localResolver() {
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.US);
		return sessionLocaleResolver;
	}
	
	@Bean 
	public ResourceBundleMessageSource bundleMessageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("messages");
		return source;		
	}
}
