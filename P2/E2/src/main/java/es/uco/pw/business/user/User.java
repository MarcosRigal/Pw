package es.uco.pw.business.user;

public class User {
	String email = "";
	String name = "";
	int edad = -1;
	
	public User (String email, String name, int edad) {
		this.email = email;
		this.name = name;
		this.edad = edad;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String toString() {
		return "Email: " + this.getEmail() + "; name: " + this.getName() + "; edad: " + Integer.toString(this.getEdad());
	}
	
}
