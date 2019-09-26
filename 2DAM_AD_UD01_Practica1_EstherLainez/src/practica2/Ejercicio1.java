package practica2;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.*;
public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);

		
		System.out.println("Introduzca el DNI: ");
		String dni=teclado.nextLine();
		System.out.println("Introduzca el nombre: ");
		String nombre=teclado.nextLine();
		System.out.println("Introduzca apellidos: ");
		String apellido=teclado.nextLine();
		System.out.println("Introduzca la fecha de nacimiento: ");
		String fecha=teclado.nextLine();
		System.out.println("Introduzca el telefono: ");
		String telefono=teclado.nextLine();
		
		DatosPersona dp=new DatosPersona(dni,nombre,apellido,fecha,telefono);
		System.out.println(dp);
		

		String ruta="src/";	
		String nombreF= "datos.txt";
		File f= new File(ruta+nombre);
		
		try {
			f.createNewFile();
			FileOutputStream fileout = new FileOutputStream(f);
			ObjectOutputStream objectout = new ObjectOutputStream(fileout);
			
			objectout.writeObject(dp);
			
			objectout.close();
		}catch(IOException e) {
			e.printStackTrace();
		}

		int i=0;
		
		FileInputStream filein=null;
		ObjectInputStream objectin=null;
		try {
			filein=new FileInputStream(f);
			objectin= new ObjectInputStream(filein);
			
			while(true) {
				dp=(DatosPersona) objectin.readObject();
				
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		finally {
			try {
				objectin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		
		
		
	}

}
