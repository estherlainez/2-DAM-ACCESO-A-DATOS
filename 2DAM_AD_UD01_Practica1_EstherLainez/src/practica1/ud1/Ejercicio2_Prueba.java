package practica1.ud1;

import java.io.File;
import java.io.IOException;

public class Ejercicio2_Prueba {

	public static void main(String[] args) {

		 String ruta="src/";
		 String nombre="2DAM";
		 File f = new File (ruta+nombre);
		
		 File nuevo=new File(f.getPath());
		 File nuevo2=new File(f.getPath());
		 
		 String nombreFichero="UD1.txt";
		 String nombreFichero2="UD2.txt";
		 String nombreFichero3="P1.txt";
		 String nombreFichero4="misNotas.txt";
		 
		 
		 if(f.exists()==false) {
			f.mkdir();
			/*
			* Para crear una carpeta hija, debemos partir de la ruta de la carpeta
			* padre y concatenarle el nombre de la nueva carpeta
			*/
			String carpetaHija="AD";
			String carpetaHija2="PSP";
			//Ruta src/carpetaNueva
			 
			nuevo=new File( f.getPath()+"/"+carpetaHija);
			nuevo2=new File( f.getPath()+"/"+carpetaHija2);
			 
			//Ruta src/carpetaNueva/carpetaHija
			nuevo.mkdir();
			nuevo2.mkdir();
			 	 
			File f1=new File(nuevo.getPath()+"/"+nombreFichero3);
			File f2=new File(nuevo.getPath()+"/"+nombreFichero);
			File f3=new File(nuevo.getPath()+"/"+nombreFichero2);
				 
			try {
				 f1.createNewFile();
				 f2.createNewFile();
				 f3.createNewFile();
						
			}catch(IOException e){
						System.out.println(e.getMessage());
			}
				
			 	 
			File f0=new File(nuevo2.getPath()+"/"+nombreFichero);
			File f9=new File(nuevo2.getPath()+"/"+nombreFichero2);
				 
			try {
				f0.createNewFile();
				f9.createNewFile();
						
				}catch(IOException e){
					System.out.println(e.getMessage());
				}
				
			f=new File("SRC\\2DAM\\misNotas.txt");
			try {
				f.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
			 
			
		 }
		 
	}

}
