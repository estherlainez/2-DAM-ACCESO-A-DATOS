package ejemplosTexto_y_Binarios;

import java.io.*;

public class Ejemplo2Binarios_Lectura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f=new File("src/EjemploBinarios2.dat");
		
		//Creamos un try para capturar el EOF
		try {
			DataInputStream dis=new DataInputStream(new FileInputStream(f));
			//Iniciamos un bucle infinito para recorrer todo el fichero
			do {
				System.out.println(dis.readUTF()+" ha obtenido un "
						+dis.readInt());
			}while(true);
			
		}catch(IOException e) {
			//cerramos el flujo
			//dis.close();
		}

	}

}
