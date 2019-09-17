package practica1.ud1;
import java.io.File;

public class Main {
   public static void main(String[] args) {
	  System.out.println("Probando");
	
	  String ruta="src/";
	
	  String nombre= "file001.txt";
	
	  File f= new File(ruta+nombre);
	  
	  System.out.println(""+f.getName());
	  System.out.println(""+f.getAbsolutePath());
	  System.out.println(""+f.length());
	  
	  if(f.exists()) {
		  
		  System.out.println("El archivo existe");
		  System.out.println("Permisos(rwx)"+f.canRead()+""+
		  f.canWrite()+""+f.canExecute());
	  }else
		  System.out.println("No existe");
   }
}
