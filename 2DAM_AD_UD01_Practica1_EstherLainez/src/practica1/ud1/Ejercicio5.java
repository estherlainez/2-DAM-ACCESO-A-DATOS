package practica1.ud1;

import java.io.File;

public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ruta="src/2DAM";
		File f=new File(ruta);
		
		mostrarContenido(f);
	}
		
		
		public static void  mostrarContenido(File f) {
		
			System.out.println(f.getName());
			
			
			if(f.isDirectory()) {
				
				File[] fichero = f.listFiles();
				
				for(int i=0;i<fichero.length;i++) {
					System.out.println(fichero[i]);
					mostrarContenido(fichero[i]);
				
				}
			
			
			
			
		}
	}

}
