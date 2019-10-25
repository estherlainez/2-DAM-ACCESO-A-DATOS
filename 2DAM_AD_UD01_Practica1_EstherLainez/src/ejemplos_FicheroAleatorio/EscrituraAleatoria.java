package ejemplos_FicheroAleatorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EscrituraAleatoria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []apellidos= {"Martinez","Gil","Ondaruina"};
		int [] dpto= {10,20,30};
		double []salario= {300.2, 123.45 , 1256.1};
		try {
			//Creamos el fichero
			RandomAccessFile raf=new RandomAccessFile(new File("src/ejemplos/misEmpleados.dat"),"rw");
			
			for(int i=0;i<apellidos.length;i++) {
				//Insertamos la informacion
				raf.writeInt(i+1);
				StringBuffer sb=new StringBuffer(apellidos[i]);
				sb.setLength(10);
				raf.writeUTF(sb.toString());
				raf.writeInt(dpto[i]);
				raf.writeDouble(salario[i]);
			}
			//Cerramos el fichero
			raf.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
