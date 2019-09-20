package practica1.ud1;

import java.io.File;
import java.io.IOException;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
			 
			 f=new File(nuevo.getPath()+"/"+nombreFichero3);
			 
			 try {
				 f.createNewFile();
			 }catch(IOException e){
				 e.printStackTrace();
			 }
			 
			 f=new File(nuevo.getPath()+"/"+nombreFichero);
			 
			 try {
				 f.createNewFile();
			 }catch(IOException e){
				 e.printStackTrace();
			 }
			 
			 f=new File(nuevo.getPath()+"/"+nombreFichero2);
			 
			 try {
				 f.createNewFile();
			 }catch(IOException e){
				 e.printStackTrace();
			 }
			
			 
			 f=new File(nuevo2.getPath()+"/"+nombreFichero);
			 
			 try {
				 f.createNewFile();
			 }catch(IOException e){
				 e.printStackTrace();
			 }
			 
			 f=new File(f.getParent()+"/"+nombreFichero2);
			 try {
				 f.createNewFile();
			 }catch(IOException e){
				 e.printStackTrace();
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
