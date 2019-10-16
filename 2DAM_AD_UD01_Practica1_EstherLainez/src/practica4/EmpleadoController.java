package practica4;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class EmpleadoController {
	
	public boolean insertarEmpleado( Empleado e) {
		try {
			File fichero=new File("src/practica4/misEmpleados.dat");
			fichero.createNewFile();
			RandomAccessFile f=new RandomAccessFile(fichero,"rw");
			//RandomAccessFile f=new RandomAccessFile(new File("src/practica4/misEmpleados.dat"),"rw");
			
			int id=e.getId();
			StringBuffer sb=null;
			String dni=e.getDni();
			String nombre=e.getNombre();
			String apellido=e.getApellido();
			Double salario=e.getSalario();
			
			long pos=f.length();
			f.seek(pos);
			
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
		}catch(FileNotFoundException d) {
			d.printStackTrace();
		}catch(IOException d) {
			d.printStackTrace();
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
				
				System.out.printf("ID: %s, Dni: %s,Nombre: %s,  Apellido: %s, Salario:%.2f %n",
						id,String.valueOf(dni),String.valueOf(nombre),String.valueOf(apellidos), salario);
				//System.out.println("Numero empleado: "+id," Dni: "+String.valueOf(dni)+" Nombre: "+String.valueOf(nombre)+" Apellido: "+String.valueOf(apellidos)+" Salario: "+salario);				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return misEmpleados;
		
	}
	
	public boolean existeDni(String dniComprobar) {
		//int posicion=4;
		int posicion=0;
		char dni[]=new char[9];
		try {
			File f = new File("src/practica4/misEmpleados.dat");
			RandomAccessFile raf = new RandomAccessFile (f, "r");
			do {
				raf.seek(posicion);
				for(int i=0;i<9;i++) {
					dni[i]=raf.readChar();
				}			
									
				if(String.valueOf(dni).equals(dniComprobar)) {
					return true;
				}
				posicion+=70;
			}while(posicion<f.length());
			
		}catch (EOFException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}	
	
	
	public void buscarEmpleado(int p){
		try {
			RandomAccessFile f=new RandomAccessFile(new File("src/practica4/misEmpleados.dat"),"r");
			int po=0;
			int id;
			char dni[]=new char[9];
			char[]nombre=new char[10];
			char[]apellidos=new char[10];
			double salario;
			
			f.seek((p-1)*70);
			
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
	
	
	public boolean borrarEmpleado( int p) {
		try {
			RandomAccessFile f=new RandomAccessFile(new File("src/practica4/misEmpleados.dat"),"rw");
	
			f.seek((p-1)*70);
			
			f.writeInt(-1);	

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
	
	public boolean modificarEmpleado( int p,double salarioNuevo) {
		try {
			RandomAccessFile f=new RandomAccessFile(new File("src/practica4/misEmpleados.dat"),"rw");			
			int id;
			char dni[]=new char[9];
			char[]nombre=new char[10];
			char[]apellidos=new char[10];
			double salarioViejo;
			
			f.seek((p-1)*70);
			
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
