package ejemplosTexto_y_Binarios;

import java.io.*;

public class EjemploMyObjectOutputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f=new File("src/EjemploCabecera.dat");
		try {
			ObjectOutputStream os=null;
			if(f.exists())
				
					os=new MyObjectOutputStream(new FileOutputStream(f));
				
			else
				os=new ObjectOutputStream(new FileOutputStream(f));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
