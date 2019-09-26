package practica2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Ejercicio3 {
	/*
	 * Crear un programa que nos permita almacenar un “correo electrónico” 
	 * de forma que solicitaremos al usuario:
		Destinatario 
		Asunto
		Cuerpo del correo.

	Almacenar esta información en un fichero de texto junto con la fecha y la hora 
	a la que se ha producido el “envio” y posteriormente mostrarlo por pantalla.

	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado=new Scanner(System.in);
		
		System.out.println("Introduzca el destinatario: ");
		String dest=teclado.nextLine();
		System.out.println("Introduzca el asunto: ");
		String asunto=teclado.nextLine();
		System.out.println("Introduzca cuerpo del correo: ");
		String cuerpoC=teclado.nextLine();
		System.out.println("Introduzca la fecha: ");
		String fecha=teclado.nextLine();
		System.out.println("Introduzca la hora: ");
		String hora=teclado.nextLine();
		
		
		String ruta="src/";
		String nombreF="email.txt";
		File f=new File(ruta+nombreF);
		
		try {
			f.createNewFile();
			FileWriter fw=new FileWriter(f);
			BufferedWriter bw=new BufferedWriter(fw);
			
			String []email= {dest,asunto,cuerpoC};
			for(int i=0;i<email.length;i++) {
				bw.write(email[i]);
				bw.newLine();
				
			}
			bw.write(fecha);
			bw.newLine();
			bw.write(hora);
			bw.newLine();
			
			bw.close();
			fw.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			String email="";
			
			
			while((email=br.readLine())!=null){
				System.out.println(email);
				
				
			}
			//System.out.println("Fecha "+fecha+"Hora "+hora);
			br.close();
			fr.close();
			
			
		}catch(IOException e){
			e.getStackTrace();
			
		}


	}

}
