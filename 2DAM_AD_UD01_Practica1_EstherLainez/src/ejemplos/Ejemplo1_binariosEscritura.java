package ejemplos;

import java.io.*;

public class Ejemplo1_binariosEscritura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f=new File("src/ejemplo1_Binarios");
		try {
			//Creamos un stream de salida
			FileOutputStream fos=new FileOutputStream(f);
			//Escribimos en el fichero los 100 primeros numeros
			for(int i=1;i<=100;i++) {
				fos.write(i);	
			}
			//cerramos el stream de salida
			fos.close();
			//Creamos un flujo de entrada
			FileInputStream fis=new FileInputStream(f);
			//Visualizamos los datos del fichero
			int b=0;
			while((b=fis.read())!=-1) {
				System.out.print(b+" ");
				
			}
			//cerramos el Stream de entrada
			fis.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
