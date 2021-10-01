package programs;

//Programa principal del Ejercicio 1

import storage.FileStorage;
import storage.IRepository;
import utilities.SystemFunctions;

public class E1 {
	public static void main(String[] args) {
		
		IRepository entityRepository = new FileStorage();
		SystemFunctions.printE1LoginScreen();
	
	}
}
