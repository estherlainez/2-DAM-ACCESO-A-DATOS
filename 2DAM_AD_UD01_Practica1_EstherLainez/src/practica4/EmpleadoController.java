package practica4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class EmpleadoController {
	
	public boolean insertarEmpleado( Empleado e) {
		try {
			RandomAccessFile f=new RandomAccessFile(new File("src/practica4/misEmpleados.dat"),"rw");
			int id=e.getId();
			StringBuffer sb=null;
			String dni=e.getDni();
			String nombre=e.getNombre();
			String apellido=e.getApellido();
			Double salario=e.getSalario();
			
			long pos=f.length();
			
			f.seek(pos);
			
			f.writeInt(id);
			
			sb=new StringBuffer(dni);
			sb.setLength(9);
			f.writeUTF(sb.toString());
			
			sb=new StringBuffer(nombre);
			sb.setLength(10);
			f.writeUTF(sb.toString());
			
			sb=new StringBuffer(apellido);
			sb.setLength(10);
			f.writeUTF(sb.toString());
			
			f.writeDouble(salario);
			
			f.close();
		}catch(FileNotFoundException d) {
			d.printStackTrace();
		}catch(IOException d) {
			d.printStackTrace();
		}	
			
			
			/*
			for(int i=0;i<e.getDni().length();i++) {
				f.writeInt(i+1);
				StringBuffer sd=new StringBuffer(e.getDni());
				sd.setLength(9);
				f.writeUTF(sd.toString());
			}
			for(int i=0;i<e.getNombre().length();i++) {
				f.writeInt(i+1);
				StringBuffer sd=new StringBuffer(e.getNombre());
				sd.setLength(10);
				f.writeUTF(sd.toString());
			}
			for(int i=0;i<e.getApellido().length();i++) {
				f.writeInt(i+1);
				StringBuffer sd=new StringBuffer(e.getApellido());
				sd.setLength(10);
				f.writeUTF(sd.toString());
			}

			f.writeDouble(e.getSalario());
		*/
		return true;
		
	}
	
	public ArrayList<Empleado> listarEmpleados(){
		ArrayList<Empleado>misEmpleados=new ArrayList();
		try {
			RandomAccessFile f=new RandomAccessFile(new File("src/practica4/misEmpleados.dat"),"r");
			int po=0,id;
			char dni[]=new char[9];
			char[]nombre=new char[10];
			char[]apellidos=new char[10];
			double salario;
			
			for(po=0;po<f.length();po+=70) {
				f.seek(po);
				id=f.readInt();
				for(int i=0;i<9;i++) {
					dni[i]=f.readChar();
				}
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return misEmpleados;
		
	}
	
	public void buscarEmpleado(int numero){
		try {
			RandomAccessFile f=new RandomAccessFile(new File("src/practica4/misEmpleados.dat"),"r");
			int po=0,id;
			char dni[]=new char[9];
			char[]nombre=new char[10];
			char[]apellidos=new char[10];
			double salario;
			
			po=(numero-1)*70;
			f.seek(po);
			id=f.readInt();
			for(int i=0;i<9;i++) {
				dni[i]=f.readChar();
			}
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
