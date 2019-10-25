package ejemplosTexto_y_Binarios;

import java.io.*;

public class EjemploLectura_Alumno {

	public static void main(String[] args) {
		// Definimos el stream de entrada
		File f=new File("src/EjemploObjetos_Alumnos.dat");
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f));
			/*
			 * Leemos el fichero hasta que se produzca la EOException,
			 * momento en el que cerramos el flujo
			 */
			while(true) {
				Alumno al=(Alumno)ois.readObject();
				System.out.println(al.getNombre()+" "+al.getCalificacion());
			}
		}catch(ClassNotFoundException e) {
			
		}catch(EOFException e) {
			System.out.println("Fin del archivo");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
