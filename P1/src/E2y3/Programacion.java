package E2y3;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Date;

import E1.Espectaculo;
import E1.Espectaculo.categoria;


public class Programacion {
	
	//Atributos

	private ArrayList<Espectaculo> programacion = new ArrayList<Espectaculo>();

	//Metodos:
	
	//Constructor sin parámetros
	public Programacion() {}
	
	//Observadores
	public ArrayList<Espectaculo> verEspectaculos(){
		return this.programacion;
	} 
	
	public ArrayList<String> verTitulos(){
		ArrayList<String> titulos = new ArrayList<String>();
	    for (int i=0;i<programacion.size();i++) { 
	        titulos.add(programacion.get(i).getTitulo());
	      }
	    return titulos;
	}
	
	public ArrayList<Espectaculo> verProximosEspectaculos(LocalDate fecha){
		LocalDate now = LocalDate.now();
		if(fecha.isAfter(now)){
			ArrayList<Espectaculo> programacionFiltrada = new ArrayList<Espectaculo>();
		    for (int i=0;i<programacion.size();i++) { 
		        if(programacion.get(i).getFecha().isBefore(fecha)){
		        	programacionFiltrada.add(programacion.get(i));
		        }
		      }
		    return programacionFiltrada;
		}
		return null;
	}
	
	public ArrayList<Espectaculo> verEspectaculosDisponibles(categoria categoria){
		ArrayList<Espectaculo> programacionFiltrada = new ArrayList<Espectaculo>();
	    for (int i=0;i<programacion.size();i++) { 
	        if((programacion.get(i).getCategoria().equals(categoria)) && (( programacion.get(i).getAforo() - programacion.get(i).getEntradasVendidas()) > 0)){
	        	programacionFiltrada.add(programacion.get(i));
	        }
	      }
		return programacionFiltrada;
	}
	
	//Modificadores
	public void programarEspectaculo(Espectaculo espectaculo){
		this.programacion.add(espectaculo);
	}
	
	public Boolean eliminarEspectaculo(String titulo){
	    for (int i=0;i<programacion.size();i++) { 
	        if(programacion.get(i).getTitulo() == titulo){
	        	programacion.remove(i);
	        	return true;
	        }
	      }
	    return false;
	}
	
	//Metodo imprimirEventos
	public void imprimirEventos(){
	    for (int i=0;i<programacion.size();i++) { 
	        System.out.println("Datos del espectaculo" + i+1 + ": " + programacion.get(i).toString());
	      }
	}
}
