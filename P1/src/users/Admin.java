package users;

//Este usuario puede acceder a todas las funciones del usuario base y además puede gestionar los espectáculos.

public class Admin extends User{
	
	private int userId; //Identificador del usuario debe ser único
	private String name; //Nombre del usuario
	private String surname; //Apellidos del usuario
	private String nick; //Nick del usuario
	private String email; //Email del usuario
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getUserId() {
		return userId;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String getSurname() {
		return surname;
	}
	
	@Override
	public String getNick() {
		return nick;
	}
	
	@Override
	public String getEmail() {
		return email;
	}
	
	@Override
	public String getType() {
		return "Admin";
	}

	@Override
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;	
	}
	
	@Override
	public void setSurname(String surname) {
		this.surname = name;	
	}
	
	@Override
	public void setNick(String nick) {
		this.nick = nick;	
	}
	
	@Override
	public void setEmail(String email) {
		this.email = email;	
	}
}
