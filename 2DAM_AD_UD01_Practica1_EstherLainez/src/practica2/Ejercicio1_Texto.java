package practica2;
import java.io.*;
import java.util.*;
public class Ejercicio1_Texto {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
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
		
		String ruta="src/";
		String nombreF="datosPersona.txt";
		File f=new File(ruta+nombreF);
		
		try {
			f.createNewFile();
			FileWriter fw=new FileWriter(f);
			BufferedWriter bw=new BufferedWriter(fw);
			
			String []datos= {dni,nombre,apellido,fecha,telefono};
			for(int i=0;i<datos.length;i++) {
				bw.write(datos[i]);
				bw.newLine();
				
			}
			
			bw.close();
			fw.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			String datos="";
			
			while((datos=br.readLine())!=null){
				System.out.println("sus datos "+datos);
			}
			
			br.close();
			fr.close();
			
			
		}catch(IOException e){
			e.getStackTrace();
			
		}

	}

}
