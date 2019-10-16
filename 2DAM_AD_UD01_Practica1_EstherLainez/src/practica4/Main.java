package practica4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado= new Scanner(System.in);
		int opcion;
		do {
			System.out.println("Menu:");
			System.out.println("1.Consulta");
			System.out.println("2.Insercion");
			System.out.println("3.Modificacion");
			System.out.println("4.Borrado");
			System.out.println("5.Listado General");
			System.out.println("6.Salir");
			System.out.println("Elija la opcion");
			opcion=teclado.nextInt();
			
			switch(opcion) {
			case 1:
				consultarEmpleadoPos();
				break;
			case 2:
				nuevoEmpleado(teclado);
				break;
			case 3:
				modificarEmpleadoPos();
				break;
			case 4:
				//borrarEmpleadoPos();
				break;
			case 5:
				listaEmpleados();
				break;
			case 6:
				System.out.println("Adios");
				break;
				
			
			}
		}while(opcion!=6);

	}
	
	public static void nuevoEmpleado( Scanner teclado) {
		
		teclado.nextLine();
		System.out.println("Dni:");
		String dni=teclado.nextLine();
		System.out.println("ID:");
		int id=teclado.nextInt();
		teclado.nextLine();
		System.out.println("Nombre:");
		String nombre=teclado.nextLine();
		System.out.println("Apellidos:");
		String apellidos=teclado.nextLine();
		System.out.println("Salario:");
		Double salario=teclado.nextDouble();
		
		EmpleadoController em= new EmpleadoController();
		
		if(em.existeDni(dni)==true) {
			System.out.println("Este dni ya existe");
		}else {
			Empleado e=new Empleado(dni,id,nombre,apellidos,salario);
			em.insertarEmpleado(e);
		}
		
	}
	
	public static void listaEmpleados() {
		EmpleadoController em= new EmpleadoController();
		for(Empleado e:em.listarEmpleados()) {
			System.out.println(e.toString());
		}
	}
	
	public static void consultarEmpleadoPos() {
		Scanner teclado=new Scanner(System.in);
		EmpleadoController em= new EmpleadoController();
		System.out.println("Introduzca dni sin la letra");
		int dniBuscar=teclado.nextInt();
		int pos=dniBuscar%10;
		
		String busqueda="";
		busqueda.valueOf(dniBuscar);
		
		em.buscarEmpleado(pos);
		
		
		//if(em.existeDni(busqueda)==false) {
			//System.out.println("Este usuario no se encuentra en lista");
		//}
		
	}
	/*
	public static void borrarEmpleadoPos() {
		Scanner teclado=new Scanner(System.in);
		EmpleadoController em= new EmpleadoController();
		System.out.println("Introduzca dni sin la letra");
		int dniBuscar=teclado.nextInt();
		int pos=dniBuscar%10;
		em.borrarEmpleado(pos);
		
		if(em.borrarEmpleado(pos)==true) {
			System.out.println("El empleado se borro");
		}else {
			System.out.println("Algo ha fallado");
		}
		
	}*/
	
	public static void modificarEmpleadoPos() {
		Scanner teclado=new Scanner(System.in);
		EmpleadoController em= new EmpleadoController();
		System.out.println("Introduzca dni sin la letra");
		int dniBuscar=teclado.nextInt();
		int pos=dniBuscar%10;
		
		System.out.println("Introduzca el nuevo salario");
		double salario=teclado.nextDouble();
		em.modificarEmpleado(pos,salario);
		
	}

}
