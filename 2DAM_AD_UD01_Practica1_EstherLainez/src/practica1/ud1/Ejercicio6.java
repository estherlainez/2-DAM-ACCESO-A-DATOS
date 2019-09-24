package practica1.ud1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;

public class Ejercicio6 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio6 frame = new Ejercicio6();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejercicio6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		File f= new File("src/2DAM");
		
		ArrayList<String>misElementos= new ArrayList<String>();
		
		String[]nombres_archivos=f.list();
		
		for(int i=0;i<nombres_archivos.length;i++) {
			
			misElementos.add(nombres_archivos[i]);
			
			File f1=new File(f.getPath(),nombres_archivos[i]);
			
			if(f1.isDirectory()) {
				String []archivos_carpeta=f1.list();
				
				for(int j=0;j<archivos_carpeta.length;j++) {
					
					misElementos.add(archivos_carpeta[j]);
					
				}
			}
		}
		JList listado = new JList();
		listado.setListData(misElementos.toArray());
		
		contentPane.add(listado, BorderLayout.CENTER);
	}
/*
	public static void  mostrarContenido(File f) {
		//System.out.println(f.getName());
		
		
		if(f.isDirectory()) {
			
			File[] fichero = f.listFiles();
			
			for(int i=0;i<fichero.length;i++) {
				System.out.println(fichero[i]);
				mostrarContenido(fichero[i]);
			
			}
		
	}
  }*/
}
