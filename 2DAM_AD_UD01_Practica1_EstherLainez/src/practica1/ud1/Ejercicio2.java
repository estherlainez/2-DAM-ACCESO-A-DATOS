package practica1.ud1;

import java.io.File;
import java.io.IOException;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String ruta="src/";
		 String nombre="2DAM";
		 File fileQueVamosACrear = new File (ruta+nombre);
		 File nuevo=new File(fileQueVamosACrear.getPath());
		 File nuevo2=new File(fileQueVamosACrear.getPath());
		
		
		 
		 String nombreFichero="UD1";
		 String nombreFichero2="UD2";
		 System.out.println(fileQueVamosACrear.getPath()+"/"+nombreFichero);
		
		 
		 
		 if(fileQueVamosACrear.exists()==false) {
			 fileQueVamosACrear.mkdir();
			 /*
			  * Para crear una carpeta hija, debemos partir de la ruta de la carpeta
			  * padre y concatenarle el nombre de la nueva carpeta
			  */
			 String carpetaHija="AD";
			 String carpetaHija2="PSP";
			 //Ruta src/carpetaNueva
			 
			 nuevo=new File( fileQueVamosACrear.getPath()+"/"+carpetaHija);
			 nuevo2=new File( fileQueVamosACrear.getPath()+"/"+carpetaHija2);
			 
			 //Ruta src/carpetaNueva/carpetaHija
			 nuevo.mkdir();
			 nuevo2.mkdir();
			 
			 
			 System.out.println("Ruta de filequevamosacrear "+ fileQueVamosACrear.getPath());
			 System.out.println("Ruta de nuevo" + nuevo.getPath());
			 
			 
			 fileQueVamosACrear=new File(nuevo.getPath()+"/"+nombreFichero);
			 
			 try {
				 fileQueVamosACrear.createNewFile();
			 }catch(IOException e){
				 e.printStackTrace();
			 }
			 
			 
			 
			 fileQueVamosACrear=new File(fileQueVamosACrear.getParent()+"/"+nombreFichero2);
			 try {
				 fileQueVamosACrear.createNewFile();
			 }catch(IOException e){
				 e.printStackTrace();
			 }
			 
			 
			 
			 
			 
			 nuevo2.mkdir();
			 System.out.println("Dentro");
		 }
		 
		 
		
	}

}
