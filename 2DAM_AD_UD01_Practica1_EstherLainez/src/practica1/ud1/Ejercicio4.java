package practica1.ud1;

import java.io.File;
import java.io.IOException;

public class Ejercicio4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String ruta="src/2DAM";
		File f=new File(ruta);
		
		if(f.exists()) {
			
			String[] fichero = f.list();
			System.out.println("\n");
			for(int i=0;i<fichero.length;i++) {
				System.out.println(fichero[i]);
			}
			
		}
		
	}

}
