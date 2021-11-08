// Esta clase DAO es "simulada" - no tiene acceso a la base de datos
package es.uco.pw.data.dao;

import es.uco.pw.business.user.User;

public class UserDAO {
	public User getUserByName(String name) {
		//Esta clase accedería a base de datos para la comprobación. 
		//Se simula que si es "JohnDoe", será verdadero; en otro caso, devuelve null.
		if (name.equalsIgnoreCase("johndoe")) {
			return new User("john.doe@email.com", "JohnDoe", (int)(Math.random() * 80));
		}
		return null;
	}

}
