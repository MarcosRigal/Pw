package E1;

import java.time.LocalDate;

enum categoria{
	concierto, obra, monologo;
}

public class Espectaculo {
	
	public enum categoria{
		concierto, obra, monologo;
	}
	//Atributos
	
	private String titulo;
	private categoria categoria;
	private String descripcion;
	private LocalDate fecha;
	private int aforo;
	private int entradasVendidas;

	//Métodos:
	
	//Constructor sin parámetros
	public Espectaculo() {}
	
	//Constructor con parametros
	public Espectaculo(String titulo, categoria categoria, String descripcion) { 
		this.titulo = titulo;
		this.categoria=categoria;
		this.descripcion=descripcion;
	}
	
	//Observadores

	public String getTitulo(){
		return titulo;
	}
	
	public categoria getCategoria(){
		return categoria;
	}

	public String getDescripcion(){
		return descripcion;
	}
	
	public LocalDate getFecha(){
		return fecha;
	}
	
	public int getAforo(){
		return aforo;
	}
	
	public int getEntradasVendidas(){
		return entradasVendidas;
	}
	
	//Modificadores
	
	public void setTitulo(String titulo){
		this.titulo=titulo;
	}
	
	public void setCategoria(categoria categoria){
		this.categoria=categoria;
	}

	public void setDescripcion(String descripcion){
		this.descripcion=descripcion;
	}
	
	public void setFecha(LocalDate localDate){
		this.fecha=localDate;
	}
	
	public void setAforo(int aforo){
		this.aforo=aforo;
	}
	
	public void setEntradasVendidas(int entradasVendidas){
		this.entradasVendidas=entradasVendidas;
	}
	
	//Método toString
	
	public String toString(){
		String info = "Titulo: " + this.titulo + " Categoría: " + this.categoria + " Descripción: " + this.descripcion + " Fecha: " + this.fecha + " Aforo: " + this.aforo + " Entradas vendidas: " + this.entradasVendidas;
		return info;
	}
}
