package programs;

//Programa principal del Ejercicio 2

import storage.FileStorage;
import storage.IRepository;

public class E2 {
	public static void main(String[] args) {
		IRepository entityRepository = new FileStorage();
	}
}
