package programs;

import storage.FileStorage;
import storage.IRepository;

/**
 * Programa principal del ejercicio 2
 * de la práctica 1
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class E2 {
	public static void main(String[] args) {
		IRepository entityRepository = new FileStorage();
	}
}
