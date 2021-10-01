package storage;

//Interfaz para abstraer el del sistema el almacenamiento de la información haciendol modular

public interface IRepository {

	public abstract boolean saveSystem(); //Interfaz para guardar el estado del sistema
	public abstract boolean loadSystem(); //Interfaz para cargar el sistema
}
