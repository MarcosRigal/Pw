package programs;

import storage.FileStorage;
import storage.IRepository;

public class E1 {
	public static void main(String[] args) {
		IRepository entityRepository = new FileStorage();
	}
}
