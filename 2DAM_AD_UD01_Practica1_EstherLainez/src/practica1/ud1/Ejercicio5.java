package practica1.ud1;

import java.io.File;

public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		String ruta="src/2DAM";
		String lista;
		File f=new File(ruta);
		
		File[] fichero = f.listFiles();
		for (int i=0;i<fichero.length;i++){
			
			System.out.println(fichero[i].getName());
			if(f.isDirectory()) {
				File[] fichero1 = f.listFiles();
					for (int j=0;j<fichero1.length;j++){
						System.out.println(fichero1[i].getName());
					}
			}
			
					
		}
		
		
	}

}
