package pluralsight.demo.version;

public class PersonV2 {
	
	private String firstName;
	private String lastName;
	
	
	public PersonV2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonV2(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

}
