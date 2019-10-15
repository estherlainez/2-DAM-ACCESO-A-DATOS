package practica4;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;

public class Empleado implements Serializable{
	private int id;//int=4 bytes	
	private String dni;//9 caracteres=18 bytes
	private String nombre;//10 caracteres=20 bytes
	private String apellido;//10 caracteres=20 bytes
	private double salario;//8 bytes
	//total empleado de 70 bytes
	public Empleado(String d, String n, String a, double s) {
		this.dni=d;
		this.nombre=n;
		this.apellido=a;
		this.salario=s;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
	public boolean existeDni(String dniComprobar) {
		int posicion=0;
		char dni[]=new char[9];
		try {
			File f = new File("src/practica4/misEmpleados.dat");
			RandomAccessFile raf = new RandomAccessFile (f, "r");
			//bucle para recorrer me falta
			raf.seek(posicion);
			for(int i=0;i<9;i++) {
				dni[i]=raf.readChar();
			}			
								
			if(dni.equals(dniComprobar)) {
				return true;
			}
			
		}catch (EOFException e) {			
			System.out.printf("");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}	
	@Override
	public String toString() {
		return "Empleado [Dni=" + dni + ", Nombre=" + nombre + ", Apellido=" + apellido + ", Salario=" + salario + "]";
	}
	
	

}
