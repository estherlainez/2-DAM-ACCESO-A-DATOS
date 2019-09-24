package practica1.ud1;

import java.io.File;
import java.io.IOException;

public class Ejercicio4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String ruta="src/2DAM";
		
		File f=new File(ruta);
		//.list(-->NOMBRES DE LOS ARCHIVOS
		
		//.listFiles()-->Objetos File
		
		String nombres[]=f.list();
		
		for(int i=0;i<nombres.length;i++) {
			System.out.println(nombres[i]);
		}
		
		
       //otra manera
		if(f.exists()) {
			
			File[] fichero = f.listFiles();
			
			for(int i=0;i<fichero.length;i++) {
				System.out.println(fichero[i]);
			}
			
		}	
	
		
		
		
	}

}
