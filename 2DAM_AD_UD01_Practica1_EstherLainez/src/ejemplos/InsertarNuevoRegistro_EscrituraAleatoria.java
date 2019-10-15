package ejemplos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class InsertarNuevoRegistro_EscrituraAleatoria {

	public static void main(String[] args) {
		/*Para insertar un nuevo registro aplicamos la funcion al identificador
		para cualquier posicion
		Inserto un empleado con identificador 20, debemos calcular donde
		estara situado*/
		try {
			RandomAccessFile raf=new RandomAccessFile(new File("src/ejemplos/misEmpleados.dat"),"rw");
			StringBuffer sb=null;
			String apellido="Latorre";
			Double salario=2000.0;
			int id=20;
			int dpto=10;
			
			long pos=(id-1)*36;//Calculamos la posicion
			raf.seek(pos);//Nos posicionamos
			raf.writeInt(id);//Escribimos el ID
			sb=new StringBuffer(apellido);
			sb.setLength(10);
			raf.writeChars(sb.toString());//Escribimos el apellido
			raf.writeInt(dpto);//Escribimos el departamento
			raf.writeDouble(salario);//Escribimos el salario
			raf.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}	// TODO Auto-generated method stub

	}

}
