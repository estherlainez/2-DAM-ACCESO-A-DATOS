package ejemplos;

import java.io.*;

public class EjemploEscritura_Alumno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f=new File("src/EjemploObjetos_Alumnos.dat");
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(f));
			//Definimos un array con los objetos que vamos a insertar
			Alumno[]alumnos= {new Alumno("Pepe",10),new Alumno("Maria",6)};
					
			//Insertamos los objetos
			for(int i=0;i<alumnos.length;i++) {
				oos.writeObject(alumnos[i]);
			}
			//Cerramos el flujo
			oos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
