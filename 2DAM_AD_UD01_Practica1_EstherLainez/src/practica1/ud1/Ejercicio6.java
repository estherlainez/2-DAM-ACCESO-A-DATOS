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
		File []nombres =f.listFiles();
		
		JList listado = new JList(nombres);
		/*
		ArrayList<String>misElementos= new ArrayList<String>();
		misElementos.add("a");
		misElementos.add("a");
		misElementos.add("a");
		listado.setListData(misElementos.toArray());
		
		String[]nombres_archivos=f.list();
		*/
		
		contentPane.add(listado, BorderLayout.CENTER);
	}

}
