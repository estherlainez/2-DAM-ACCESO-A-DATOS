package ejemplos;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LecturaAleatoria {

	public static void main(String[] args) {
		//Creamos el fichero
		try {
			RandomAccessFile raf=new RandomAccessFile(new File("src/ejemplos/misEmpleados.dat"),"r");
			//Declaramos las variables necesarias
			int pos=0;
			int id,dep;
			Double salario;
			char[]apellido=new char[10];
			//Recorremos el fichero
			for(pos=0;pos<raf.length();pos+=36) {
				raf.seek(pos);//Posicionamos el puntero al comienzo del registro
				id=raf.readInt();
				for(int i=0;i<10;i++) {
					apellido[i]=raf.readChar();
				}
				dep=raf.readInt();
				salario=raf.readDouble();
				System.out.printf("ID: %s, Apellido: %s,Dpto: %d Salario:%.2f %n",
						id,String.valueOf(apellido),dep, salario);
				
			}
			raf.close();//Cerramos el fichero
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
