package E4;

import java.util.Date;

import E1.Espectaculo;
import E1.Espectaculo.categoria;
import E2y3.Programacion;

public class mainProgram {
	
	public static void main(String[] args){
		Programacion programacion = new Programacion();
		Espectaculo E1 = new Espectaculo();
		Espectaculo E2 = new Espectaculo();
		
		E1.setTitulo("Origen");
		E2.setTitulo("Matrix");
		
		E1.setAforo(50);
		E2.setAforo(50);
		
		E1.setEntradasVendidas(50);
		E2.setEntradasVendidas(25);
		
		Espectaculo E3 = new Espectaculo("Don Quijote", categoria.obra, "Historia clasica");
		Espectaculo E4 = new Espectaculo("Romeo y Julieta", categoria.obra, "Historia clasica en inglés");
		
		E3.setAforo(50);
		E4.setAforo(50);
		
		E3.setEntradasVendidas(50);
		E4.setEntradasVendidas(25);
		
		E1.setFecha(new Date(System.currentTimeMillis()*2));
		E2.setFecha(new Date(System.currentTimeMillis()*5));;
		E3.setFecha(new Date(System.currentTimeMillis()*4));
		E4.setFecha(new Date(System.currentTimeMillis()*3));
		
		programacion.programarEspectaculo(E1);
		programacion.programarEspectaculo(E2);
		programacion.programarEspectaculo(E3);
		programacion.programarEspectaculo(E4);
		
		System.out.println(programacion.verTitulos());
	    for (int i=0;i<programacion.verEspectaculos().size();i++) { 
	    	System.out.println(programacion.verEspectaculos().get(i).getFecha());	    	
	      }
		System.out.println(programacion.verProximosEspectaculos(new Date(System.currentTimeMillis()*6)));
		System.out.println(programacion.verProximosEspectaculos(new Date(System.currentTimeMillis()/2)));
	}
	
}
