package practica2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		
		File f =new File("src/archivoNuemros.txt");
		
		int n=0;
		int suma=0;
		int contador=0;
		
		String cifra="";
		
		try {
			FileWriter fw=new FileWriter(f);
			BufferedWriter bw=new BufferedWriter(fw);
			
			
			do{
				System.out.println("Introduzca numero");
				n=teclado.nextInt();
				cifra=String.valueOf(n);
				suma=suma+n;
				fw.write(cifra);
				bw.newLine();
				contador++;
			}while(n!=0);
			
			bw.close();
			
		}catch(IOException e) {
			e.getStackTrace();
		}
		
		int i=0;
		try {
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			cifra=br.readLine();
			while(cifra!=null ) {
	
				System.out.println("Usted anoto "+cifra+" \n ");
				cifra=br.readLine();
				
				i++;
			}
			br.close();
			System.out.println("La suma = "+suma);
			
		}catch(IOException e){
			e.getStackTrace();
			
		}
	}

}
