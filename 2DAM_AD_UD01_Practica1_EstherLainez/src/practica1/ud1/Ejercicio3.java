package practica1.ud1;

import java.io.File;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		 File f1=new File("src/2DAM/AD/P1.txt");
		 File f2= new File("src/2DAM/AD/practica1.txt");
		 
		 
		 if(f1.renameTo(f2)) {
		     System.out.println("El archivo ha cambiado de nombre");
		     
		 }else {
			 System.out.println("Error");
		 }
		
		 
		

	}

}
