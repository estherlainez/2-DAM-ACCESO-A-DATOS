package practica1.ud1;

import java.io.File;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 String ruta="src/2DAM/AD";
		 String nombre = "P1.txt";
		 String nombre2="practica1.txt";
		 File f=new File(ruta);
		 f=new File(f.getPath());
		 
		 File nuevo=new File(f.getPath()+"/"+nombre);
		 File renombrado= new File(ruta+"/"+nombre2);
		 nuevo.renameTo(renombrado);
		 
		 System.out.println(nuevo);
		 System.out.println(renombrado);
	}

}
