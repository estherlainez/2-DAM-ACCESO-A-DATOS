package practica1.ud1;

import java.io.File;

public class Ejercicio5_Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ruta="src/2DAM";
		File f=new File(ruta);
		
		File[] archivos = f.listFiles();
		
		 for (int i=0; i< archivos.length; i++) {
		    
		    if(archivos[i].isDirectory()) {
		    	File []archivos_carpeta=f.listFiles();
				
				for(int j=0;j<archivos_carpeta.length;j++) {
					
					System.out.println(archivos_carpeta[j].getName());
				}
			}else if(archivos[i].isFile()) {
		    	
		    	System.out.println(archivos[i].getName());
		    	
		    }
		                    
		 }
		

	}

}
