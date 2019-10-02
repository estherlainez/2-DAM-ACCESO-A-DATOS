package ejemplos;

import java.io.*;

public class EjemploBinarios2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File f= new File("src/EjemploBinarios2.dat");
			FileOutputStream fos=new FileOutputStream(f);
			DataOutputStream dos=new DataOutputStream(fos);
			//Definimos dos arrays que escribiremos en el fichero
			String[]alumnos= {
			"Alberto","Ana","Josefina","Maribel","Adriana","Mariano"		
			};
			int[]calificaciones= {1,2,3,4,5,6};
			
			//Recorreremos los arrays y los vamos escribiendo
			for(int i=0;i<alumnos.length;i++) {
				try {
					dos.writeUTF(alumnos[i]);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dos.writeInt(calificaciones[i]);
			}
			//Cerramos el flujo
			dos.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
