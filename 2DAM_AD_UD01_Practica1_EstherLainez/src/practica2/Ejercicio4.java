package practica2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Ejercicio4 {
/*
 * Modifica el programa del ejercicio 1 para que,  mediante un menú, nos permita almacenar diferentes usuarios 
 * dentro del fichero y leerlos de las siguientes formas:
	Todos los usuarios
	Solo los N primeros
	Mostrar solo un usuario concreto en base a su DNI.

 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado=new Scanner(System.in);
		
		
		String ruta="src/";
		String nombreF="FicheroUsuarios.txt";
		File f=new File(ruta+nombreF);
		
		//String []usuario= añadirUsuario();
		
		try {
			f.createNewFile();
		}catch(IOException e) {
			e.getStackTrace();
		}
		
		try {
			FileWriter fw=new FileWriter(f);
			BufferedWriter bw=new BufferedWriter(fw);
			
			String []usuario= añadirUsuario();
			for(int i=0;i<usuario.length;i++) {
				bw.write(usuario[i]);
				bw.newLine();
				
			}
			
			bw.close();
			fw.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		try {
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			String datos="";
			
			while((datos=br.readLine())!=null){
				System.out.println("sus datos "+datos);
			}
			
			br.close();
			fr.close();
			
			
		}catch(IOException e){
			e.getStackTrace();
			
		}
		
		System.out.println("Introduzca una opcion:");
		int opcion=teclado.nextInt();
		
		do {
			System.out.println("Menu");
			System.out.println("1.Todos los Usuarios");
			System.out.println("Solo los N primeros");
			System.out.println("Mostrar un usuario por dni");
			
			switch(opcion) {
			
			case 1:
				
				break;
				
			case 2:
				
				break;
			case 3:
				break;
				default:
					System.out.println("Error");
			}
			
		}while(opcion!=4);
		
		
		
		
		/*
		
		*/
		
	}

	public static String[] añadirUsuario() {
		Scanner teclado=new Scanner(System.in);
		System.out.println("Introduzca el DNI: ");
		String dni=teclado.nextLine();
		System.out.println("Introduzca el nombre: ");
		String nombre=teclado.nextLine();
		System.out.println("Introduzca apellidos: ");
		String apellido=teclado.nextLine();
		System.out.println("Introduzca la fecha de nacimiento: ");
		String fecha=teclado.nextLine();
		System.out.println("Introduzca el telefono: ");
		String telefono=teclado.nextLine();
		
		String []datos= {dni,nombre,apellido,fecha,telefono};
		
		return datos;
		
	}
}
