package practica4;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class EmpleadoController {
	//tamañoRegistro
	//randomaccesFile
	//rutaFichero
	public boolean insertarEmpleado( Empleado e) {
		int id=e.getId();
		StringBuffer sb=null;
		String dni=e.getDni();
		String nombre=e.getNombre();
		String apellido=e.getApellido();
		Double salario=e.getSalario();
		RandomAccessFile f=null;
		int posi=0;
		try {
			
			f=new RandomAccessFile(new File("src/practica4/misEmpleados.dat"),"rw");
			
			posi= Integer.valueOf((e.getDni().substring(0, e.getDni().length()-2)))%10;
			/*
			 * Antes de insertar debemos comprobar si ya existe un emp en esa posición
			 */
			//comprobar si existe
			f.seek(posi*70);
			char a= f.readChar();
			if(a!=' ') {
				//El elmpleado ya existe
				f.close();
				return false;
			}else {
				//El elmpleado no existe
				//Escribo los registros
				f.seek(posi*70);
				sb=new StringBuffer(dni);
				sb.setLength(9);
				f.writeChars(sb.toString());
				
				f.writeInt(id);
				
				sb=new StringBuffer(nombre);
				sb.setLength(10);
				f.writeChars(sb.toString());
				
				sb=new StringBuffer(apellido);
				sb.setLength(10);
				f.writeChars(sb.toString());
				
				f.writeDouble(salario);
				f.close();
				return true;
			}
					
		}catch(FileNotFoundException d) {
			d.printStackTrace();
		}catch(IOException d) {
			//d.printStackTrace();
			//Puede ser que estemos al final del fichero y podamos insertar ahi.
			try {
				f.seek(posi*70);
				sb=new StringBuffer(dni);
				sb.setLength(9);
				f.writeChars(sb.toString());
				
				f.writeInt(id);
				
				sb=new StringBuffer(nombre);
				sb.setLength(10);
				f.writeChars(sb.toString());
				
				sb=new StringBuffer(apellido);
				sb.setLength(10);
				f.writeChars(sb.toString());
				
				f.writeDouble(salario);
				f.close();
				return true;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}	
				
		return true;
		
	}
	
	
	public ArrayList<Empleado> listarEmpleados(){
		ArrayList<Empleado>misEmpleados=new ArrayList();
		try {
			RandomAccessFile f=new RandomAccessFile(new File("src/practica4/misEmpleados.dat"),"r");
			int po=0;
			int id;
			char dni[]=new char[9];
			char[]nombre=new char[10];
			char[]apellidos=new char[10];
			double salario;
			
		
			for(po=0;po<f.length();po+=70) {
				
				f.seek(po);
				
				for(int i=0;i<9;i++) {
					dni[i]=f.readChar();
				}
				
				id=f.readInt();
				
				for(int i=0;i<10;i++) {
					nombre[i]=f.readChar();
				}
				for(int i=0;i<10;i++) {
					apellidos[i]=f.readChar();
				}
				salario=f.readDouble();
				//AÑADIR AL ARRAY ADD(EMPLEADO)
				System.out.printf("ID: %s, Dni: %s,Nombre: %s,  Apellido: %s, Salario:%.2f %n",
						id,String.valueOf(dni),String.valueOf(nombre),String.valueOf(apellidos), salario);
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return misEmpleados;
		
	}
	
	
	
	public void buscarEmpleado(String dniBuscar){
		try {
			RandomAccessFile f=new RandomAccessFile(new File("src/practica4/misEmpleados.dat"),"r");
			int posi=0;
			int id;
			char dni[]=new char[9];
			char[]nombre=new char[10];
			char[]apellidos=new char[10];
			double salario;
			
			posi= Integer.valueOf((dniBuscar.substring(0, dniBuscar.length()-2)))%10;
			f.seek((posi)*70);
			//comprobar si la posicion esta ocupada
			/*
			char a= f.readChar();
			if(a!=' ') {
				//El elmpleado ya existe
				f.close();
				return false;
			}else {
			
			}*/
			for(int i=0;i<9;i++) {
				dni[i]=f.readChar();
			}
			id=f.readInt();
			for(int i=0;i<10;i++) {
				nombre[i]=f.readChar();
			}
			for(int i=0;i<10;i++) {
				apellidos[i]=f.readChar();
			}	
			salario=f.readDouble();
				
			System.out.printf("ID: %s, Dni: %s,Nombre: %s,  Apellido: %s, Salario:%.2f %n",
					id,String.valueOf(dni),String.valueOf(nombre),String.valueOf(apellidos), salario);
			//System.out.println("Numero empleado: "+id," Dni: "+String.valueOf(dni)+
			//" Nombre: "+String.valueOf(nombre)+" Apellido: "+String.valueOf(apellidos)+" Salario: "+salario);				
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	public boolean borrarEmpleado( String dniBorrar) {
		RandomAccessFile f=null;
		int posi=0;
		String dni = null;
		int id = 0;
		String nombre = null;
		String apellidos = null;
		double salario = 0;
		try {
			
			f=new RandomAccessFile(new File("src/practica4/misEmpleados.dat"),"rw");

			posi= Integer.valueOf((dniBorrar.substring(0, dniBorrar.length()-2)))%10;
			
			f.seek(posi*70);
			char a= f.readChar();
			if(a==' ') {
				
				return false;
			}else {
				StringBuffer sb=new StringBuffer();
				f.seek(posi*70);
				sb=new StringBuffer(dni);
				sb.setLength(9);
				f.writeChars(" ");
				
				
				f.close();
				return true;
			}
					
		}catch(FileNotFoundException d) {
			d.printStackTrace();
		}catch(IOException d) {
			//d.printStackTrace();
			
		}	
				
		return true;
		
	}*/
	
	public boolean modificarEmpleado( String dniModificar,double salarioNuevo) {
		//igual que insertar pero comprobando que la posicion este libre, al reves
		
		try {
			RandomAccessFile f=new RandomAccessFile(new File("src/practica4/misEmpleados.dat"),"rw");			
			int id,posi;
			char dni[]=new char[9];
			char[]nombre=new char[10];
			char[]apellidos=new char[10];
			double salarioViejo;
			
			posi= Integer.valueOf((dniModificar.substring(0, dniModificar.length()-2)))%10;
			f.seek(posi*70);
			
			
			for(int i=0;i<9;i++) {
				dni[i]=f.readChar();
			}
			id=f.readInt();
			for(int i=0;i<10;i++) {
				nombre[i]=f.readChar();
			}
			for(int i=0;i<10;i++) {
				apellidos[i]=f.readChar();
			}	
		
			salarioViejo=f.readDouble();		
			f.writeDouble(salarioNuevo);	
			
			System.out.println("Id: "+id+" Dni: "+new String(dni)+" Nombre: "+new String(nombre)+" Apellido: "+new String(apellidos)+" Salario anterior: "+salarioViejo+" Salario actual: "+salarioNuevo);
			f.close();
		}catch(FileNotFoundException d) {
			d.printStackTrace();
			return false;
		}catch(IOException d) {
			d.printStackTrace();
			return false;
		}
		return true;	
	
	}

}
