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
				borrarEmpleadoPorDni();
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
		
		
		Empleado e=new Empleado(dni,id,nombre,apellidos,salario);
		if(em.insertarEmpleado(e)) {
			System.out.println("Empleado insertado");
		}else {
			System.out.println("El empleado ya existia");
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
		System.out.println("Introduzca dni");
		String dniBuscar=teclado.nextLine();
		em.buscarEmpleado(dniBuscar);
		
	}
	
	public static void borrarEmpleadoPorDni() {
		Scanner teclado=new Scanner(System.in);
		EmpleadoController em= new EmpleadoController();
		System.out.println("Introduzca dni");
		String dniBorrar=teclado.nextLine();
		
		
		if(em.buscarEmpleado(dniBorrar)==true) {
			System.out.println("El empleado se borro");
		}else {
			System.out.println("Algo ha fallado");
		}
		
	}
	
	public static void modificarEmpleadoPos() {
		Scanner teclado=new Scanner(System.in);
		EmpleadoController em= new EmpleadoController();
		System.out.println("Introduzca dni");
		String dniModificar=teclado.nextLine();
		
		System.out.println("Introduzca el nuevo salario");
		double salario=teclado.nextDouble();
		em.modificarEmpleado(dniModificar,salario);
		
	}

}
