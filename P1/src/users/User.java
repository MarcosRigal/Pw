package users;

//Clase de la que heredan el resto de usuarios

public abstract class User {
	
	public abstract int getUserId(); //Devuelve el identificador del usuario 
	public abstract String getName(); //Devuelve el nombre del usuario
	public abstract String getSurname(); //Devuelve los apellidos del usuario
	public abstract String getNick(); //Devuelve el nick del usuario
	public abstract String getEmail(); //Devuelve el email del usuario

	public abstract String getType(); //Devuelve el tipo de entidad
	
	public abstract void setUserId(int userId); //Modifica el identificador del usuario
	public abstract void setName(String name); //Modifica el nombre del usuario
	public abstract void setSurname(String surname); //Modifica los apellidos del usuario
	public abstract void setNick(String nick); //Modifica el nick del usuario
	public abstract void setEmail(String email); //Modifica el email del usuario

}
