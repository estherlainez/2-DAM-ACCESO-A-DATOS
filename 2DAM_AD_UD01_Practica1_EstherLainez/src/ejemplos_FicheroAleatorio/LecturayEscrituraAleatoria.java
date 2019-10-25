package ejemplos_FicheroAleatorio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LecturayEscrituraAleatoria {

	public static void main(String[] args) {
		try {
			//Creamos el fichero
			RandomAccessFile raf=new RandomAccessFile("src/ejemplos/misEmpleados.dat","rw");
			//Declaramos las variables necesarias
			int id,dep;
			Double salario;
			char[]apellido=new char[10];
			
			//Vamos a leer los datos del segundo registro (ID-1)
			raf.seek(1*36);//Posicionamos el puntero al comienzo del registro 2
			id=raf.readInt();
			for(int i=0;i<10;i++) {
				apellido[i]=raf.readChar();
			}
			dep=raf.readInt();
			salario=raf.readDouble();
			System.out.printf("ID: %s, Apellido: %s, Dpto: %d Salario: %.2f %n",
					id,String.valueOf(apellido),dep,salario);
			raf.close();//Cerramos el fichero
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}	
					

	}

}
