package pluralsight.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserRepository {

	//@Autowired
	static List<User> users = new ArrayList(); 
	
	private static Integer userid = 2;
	static {
		users.add(new User(1,"raja",new Date()));
		users.add(new User(2,"rani",new Date()));
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public User getUser(Integer id) {
		for(User user : users) {
			if(user.getId() == id) {
				return user;
			}
		} 
		
		return null;
	} 
	
	public User deleteUser(Integer id) {
		Iterator<User> itr = users.iterator();
		while(itr.hasNext()) {
			User usr = itr.next();
			if (usr.getId() == id) {
				itr.remove();
				return usr;
			}
			
		}
		return null;
	}

	public User save(User user) {
		// TODO Auto-generated method stub
		if( user.getId() == null) {
			user.setId(++userid);
			users.add(user);
			return user;
		}
		return null;
	}
}
