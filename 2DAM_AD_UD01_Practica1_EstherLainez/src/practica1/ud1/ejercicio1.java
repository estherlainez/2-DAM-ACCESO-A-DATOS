package practica1.ud1;

import java.io.File;

public class ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		  String ruta="src/";
		
		  String nombre= "file001.txt";
		
		  File f= new File(ruta+nombre);
		  
		  System.out.println("Nombre "+f.getName());
		  System.out.println("Ruta "+f.getAbsolutePath());
		  System.out.println("Directorio Padre "+f.getParent());
		  
		  if(f.exists()) {
			  
			  System.out.println("El archivo existe");
			  System.out.println("Permisos(rwx)"+f.canRead()+""+
			  f.canWrite()+""+f.canExecute());
			  System.out.println("Longitud"+f.length()+"bytes");
		  }else
			  System.out.println("No existe");
	   
	}

}
