package ejemplosTexto_y_Binarios;

import java.io.Serializable;

public class Alumno implements Serializable{
	private static final long serialVersionUID=1L;
	private String nombre;
	private int calificacion;
	
	public Alumno(String nombre, int calificacion) {
		super();
		this.nombre=nombre;
		this.calificacion=calificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	

}
