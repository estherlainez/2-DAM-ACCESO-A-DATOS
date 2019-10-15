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
				System.out.println("¿Que numero de empleado va a consultar?");
				String dniBuscar=teclado.nextLine();
				consultarEmpleado(dniBuscar);
				break;
			case 2:
				nuevoEmpleado(teclado);
				break;
			case 3:
				break;
			case 4:
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
		System.out.println("ID:");
		int id=teclado.nextInt();
		teclado.nextLine();
		System.out.println("Dni:");
		String dni=teclado.nextLine();
		System.out.println("Nombre:");
		String nombre=teclado.nextLine();
		System.out.println("Apellidos:");
		String apellidos=teclado.nextLine();
		System.out.println("Salario:");
		Double salario=teclado.nextDouble();
		
		Empleado e=new Empleado(dni,nombre,apellidos,salario);
		EmpleadoController em= new EmpleadoController();
		
		if(!em.insertarEmpleado(e))
			System.err.println("Error");

	}
	
	public static void listaEmpleados() {
		EmpleadoController em= new EmpleadoController();
		for(Empleado e:em.listarEmpleados()) {
			System.out.println(e.toString());
		}
		//em.listarEmpleados();
	}
	
	public static void consultarEmpleado(String dniBuscar) {
		EmpleadoController em= new EmpleadoController();
		em.buscarEmpleado(dniBuscar);
	}

}
