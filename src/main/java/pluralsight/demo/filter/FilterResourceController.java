package pluralsight.demo.filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterResourceController {

	@GetMapping("/filter")
	public MappingJacksonValue getSomeBeans() {
		
		SomeBean someBean = new SomeBean("field1","field2","field3");
		
		SimpleBeanPropertyFilter filter =  SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		return mapping;
		//return Arrays.asList(new SomeBean("field1","field2","field3"), new SomeBean("field4","field5","field6"));
	}
	
	@GetMapping("/filter-test")
	public MappingJacksonValue getSomeBeans1() {
		
		List<SomeBean> beansList =  Arrays.asList(new SomeBean("field1","field2","field3"), new SomeBean("field4","field5","field6"));

		SimpleBeanPropertyFilter filter =  SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(beansList);
		mapping.setFilters(filters);
		return mapping;
	}
}
