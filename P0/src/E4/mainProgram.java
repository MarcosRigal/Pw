package E4;


import java.time.LocalDate;

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
		
		E1.setFecha(LocalDate.of(2022, 02, 20));
		E2.setFecha(LocalDate.of(2023, 02, 20));
		E3.setFecha(LocalDate.of(2025, 02, 20));
		E4.setFecha(LocalDate.of(2024, 02, 2));
		
		
		
		programacion.programarEspectaculo(E1);
		programacion.programarEspectaculo(E2);
		programacion.programarEspectaculo(E3);
		programacion.programarEspectaculo(E4);
		
		System.out.println(programacion.verTitulos());
	    for (int i=0;i<programacion.verEspectaculos().size();i++) { 
	    	System.out.println(programacion.verEspectaculos().get(i).getFecha());	    	
	      }
		System.out.println(programacion.verProximosEspectaculos(LocalDate.of(2015, 02, 20)));
		System.out.println(programacion.verProximosEspectaculos(LocalDate.of(2024, 02, 20)));
	}
	
}
