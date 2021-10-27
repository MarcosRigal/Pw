package es.uco.pw.p2.business;

/**
 * A DTO for the user concept
 * @author Aurora Ramirez
 * @author Jose Raul Romero
 * */

public class UserDTO {

	protected String last;
	
	protected String first;
	
	protected int age;
	
	public UserDTO() {
		
	}
	
	public UserDTO(String last, String first, int age) {
		this.last = last;
		this.first = first;
		this.age = age;
	}

	public String getLast() {
		return this.last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getFirst() {
		return this.first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		String userInfo = " Name: " + this.first + " " + this.last + " Age: " + this.age;
		return userInfo;
	}
}
