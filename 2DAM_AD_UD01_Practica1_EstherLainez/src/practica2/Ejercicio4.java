package practica2;
import java.io.*;
import java.util.*;
public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado=new Scanner(System.in);

		int opcion=0,posicion=0;
		
		File f = new File("src/usuarios.txt");
		try {
			f.createNewFile();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		do {
			System.out.println("MENU");
			System.out.println("1.Introducir registro");
			System.out.println("2.Leer todos registros");
			System.out.println("3.Leer solo los N primeros");
			System.out.println("4.Mostrar un usuario segun su dni");
			System.out.println("5.Mostrar los telefonos que empiecen por 6");
			System.out.println("Elija la opcion que desee:");
			opcion=teclado.nextInt();
			
			switch(opcion) {
			case 1:
				teclado.nextLine();
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
				try {
					
					FileWriter fw=new FileWriter(f, true);
					BufferedWriter bw=new BufferedWriter(fw);
					
					bw.write(dni);
					bw.write("|");
					bw.write(nombre);
					bw.write("|");
					bw.write(apellido);
					bw.write("|");
					bw.write(fecha);
					bw.write("|");
					bw.write(telefono);
					bw.write("|");
					bw.newLine();
					bw.close();
					fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			
			
			break;
			
			case 2:
				
				String usuario="";
				
				try {
					//File f = new File("src/usuarios.txt");
					FileReader fr=new FileReader(f);
					BufferedReader br=new BufferedReader(fr);
					String  linea="";
					while((linea=br.readLine())!=null){
						System.out.println(linea);
					
					}
				}catch(IOException ex) {
					System.out.println("Error");

				}	
				break;
			
			case 3:
				
				try {
					FileReader fr=new FileReader(f);
					BufferedReader br=new BufferedReader(fr);
					System.out.println("Indica numero de registros");
					int numeroRegistros=teclado.nextInt();
					String linea="";
					int pos = 0;
					for(int i=0;i<numeroRegistros&&(linea=br.readLine())!=null;i++) {
						
						String []campos=linea.split("\\|");
						System.out.println(++pos);
						System.out.println("Dni "+campos[0]);
						System.out.println("Nombre "+campos[1]);
						System.out.println("Apellidos "+campos[2]);
						System.out.println("Fecha "+campos[3]);
						System.out.println("Telefono "+campos[4]);
						
					}
					
					//if(pos==numeroRegistros)break;
				}catch(IOException e) {
				
					e.getStackTrace();
				}
				
				break;
			
			case 4:
				System.out.println("Introduce dni");
				teclado.nextLine();
				String dniB= teclado.nextLine();
				try {
					FileReader fr=new FileReader(f);
					BufferedReader br=new BufferedReader(fr);
					
					String linea="";
					int pos = 0;
					while((linea=br.readLine())!=null){
					
						String []campos=linea.split("\\|");
						if(dniB.equals(campos[0])) {
						System.out.println(++pos);
						System.out.println("Dni "+campos[0]);
						System.out.println("Nombre "+campos[1]);
						System.out.println("Apellidos "+campos[2]);
						System.out.println("FechaN "+campos[3]);
						System.out.println("Telefono "+campos[4]);
						}
						
					}
					
					
				}catch(IOException e) {
					e.getStackTrace();
				}
				
				break;
			case 5:
				//solo mostrar los registros que el telefono empiece por 6
				try {
					FileReader fr=new FileReader(f);
					BufferedReader br=new BufferedReader(fr);
					
					String linea="";
					int pos = 0;
					while((linea=br.readLine())!=null){
					
						String []campos=linea.split("\\|");
						String palabra=campos[4];
						char[] caracteres = palabra.toCharArray();
						System.out.println(caracteres);
						if(caracteres[0]==6) {
						
							System.out.println(++pos);
							System.out.println("Dni "+campos[0]);
							System.out.println("Nombre "+campos[1]);
							System.out.println("Apellidos "+campos[2]);
							System.out.println("FechaN "+campos[3]);
							System.out.println("Telefono "+campos[4]);
						}
					
					}
				}catch(IOException e) {
					e.getStackTrace();
				}
				break;
					
			
			}
		}while(opcion!=4);
	
	}
	
}
