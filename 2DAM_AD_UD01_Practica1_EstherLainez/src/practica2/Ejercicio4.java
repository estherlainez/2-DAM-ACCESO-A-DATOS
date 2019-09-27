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
			FileWriter fw=new FileWriter(f);
			BufferedWriter bw=new BufferedWriter(fw);
			String dni="",nombre="",apellido="",fechaN="",telefono="";
			String []usuario1= {dni="111111111P",nombre="Lucas",apellido="Jimenez",fechaN="12-4-1987",telefono="976645321"};			
			String []usuario2= {dni="22222222F",nombre="Esther",apellido="Lainez",fechaN="14-4-1981",telefono="976645678"};		
			String []usuario3= {dni="333333333P",nombre="Marcos",apellido="Latorre",fechaN="12-5-1975",telefono="976543212"};		
			String []usuario4= {dni="444444444I",nombre="Lorena",apellido="Martinez",fechaN="2-4-1981",telefono="976643344"};		
			String []usuario5= {dni="555555555N",nombre="Pilar",apellido="Dielz",fechaN="3-11-1971",telefono="976554477"};

			
			for(int i=0;i<usuario1.length;i++) {
				bw.write(usuario1[i]);
				bw.write(" ");
			}
			bw.newLine();
			for(int i=0;i<usuario2.length;i++) {
				bw.write(usuario2[i]);
				bw.write(" ");	
			}
			bw.newLine();
			for(int i=0;i<usuario3.length;i++) {
				bw.write(usuario3[i]);
				bw.write(" ");	
			}
			bw.newLine();
			for(int i=0;i<usuario4.length;i++) {
				bw.write(usuario4[i]);
				bw.write(" ");
			}
			bw.newLine();
			for(int i=0;i<usuario5.length;i++) {
				bw.write(usuario5[i]);
				bw.write(" ");	
			}
			bw.newLine();
			bw.close();
			fw.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		do {
			System.out.println("MENU");
			System.out.println("1.Leer todos los usuarios");
			System.out.println("2.Leer solo los N primeros");
			System.out.println("3.Mostrar un usuario segun su dni");
			System.out.println("Elija la opcion que desee:");
			opcion=teclado.nextInt();
			
			switch(opcion) {
			case 1:{
				String usuario1="",usuario2="",usuario3="",usuario4="",usuario5="";
				leerusuario(usuario1);
				break;
			}
			case 2:{
				String dni="",nombre="",apellido="",fechaN="",telefono="";
				String []usuario1= {dni="111111111P",nombre="Lucas",apellido="Jimenez",fechaN="12-4-1987",telefono="976645321"};			
				String []usuario2= {dni="22222222F",nombre="Esther",apellido="Lainez",fechaN="14-4-1981",telefono="976645678"};		
				String []usuario3= {dni="33333333P",nombre="Marcos",apellido="Latorre",fechaN="12-5-1975",telefono="976543212"};		
				String []usuario4= {dni="44444444I",nombre="Lorena",apellido="Martinez",fechaN="2-4-1981",telefono="976643344"};		
				String []usuario5= {dni="55555555N",nombre="Pilar",apellido="Dielz",fechaN="3-11-1971",telefono="976554477"};
				System.out.println("Que usuario necesita leer?");
				teclado.nextLine();
				String uBuscar=teclado.nextLine();
				try {
					//File f = new File("src/usuarios.txt");
					FileReader fr=new FileReader(f);
					BufferedReader br=new BufferedReader(fr);

					String linea=uBuscar;
					//while((usuarios=br.readLine())!=null && dni.equals(dniBuscar))
					while((uBuscar=br.readLine())!=null){
						System.out.println("sus datos "+linea);
					}
				}catch(IOException ex) {
					System.out.println("Error");

				}	
				
				break;
			}
			case 3:{
				
				String dni="",nombre="",apellido="",fechaN="",telefono="";
				String []usuario1= {dni="111111111P",nombre="Lucas",apellido="Jimenez",fechaN="12-4-1987",telefono="976645321"};			
				String []usuario2= {dni="22222222F",nombre="Esther",apellido="Lainez",fechaN="14-4-1981",telefono="976645678"};		
				String []usuario3= {dni="33333333P",nombre="Marcos",apellido="Latorre",fechaN="12-5-1975",telefono="976543212"};		
				String []usuario4= {dni="44444444I",nombre="Lorena",apellido="Martinez",fechaN="2-4-1981",telefono="976643344"};		
				String []usuario5= {dni="55555555N",nombre="Pilar",apellido="Dielz",fechaN="3-11-1971",telefono="976554477"};
				String dniBuscar="";
				System.out.println("Introduzca dni: ");
				teclado.nextLine();
				dniBuscar=teclado.nextLine();
				try {
					//File f = new File("src/usuarios.txt");
					FileReader fr=new FileReader(f);
					BufferedReader br=new BufferedReader(fr);

					String usuarios="usuario1||usuario2||usuario3||usuario4||usuario5";
					//while((usuarios=br.readLine())!=null && dni.equals(dniBuscar))
					while((usuarios=br.readLine())!=null&&usuarios.startsWith(dniBuscar)){
						System.out.println("sus datos "+usuarios);
					}
				}catch(IOException ex) {
					System.out.println("Error");

				}	
				
				break;
				}	
			}
		
		}while(opcion!=3);
	
	}
	private static void leerusuario(String usuarios) {
		try {
			File f = new File("src/usuarios.txt");
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);

			while((usuarios=br.readLine())!=null){
				System.out.println(usuarios);
			
			}
		}catch(IOException ex) {
			System.out.println("Error");

		}	
		
		
	}
}
