package practica1.ud1;

import java.io.File;

public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		String ruta="src/2DAM";
		File f=new File(ruta);
		
		String[]nombres_archivos=f.list();
		
		for(int i=0;i<nombres_archivos.length;i++) {
			System.out.println(nombres_archivos[i]);
			File f1=new File(f.getPath(),nombres_archivos[i]);
			
			if(f1.isDirectory()) {
				String []archivos_carpeta=f1.list();
				
				for(int j=0;j<archivos_carpeta.length;j++) {
					
					System.out.println(" "+archivos_carpeta[j]);
				}
			}
		}
		
	}

}
