package practica1.ud1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;

public class Practica1Ejercicio6 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Practica1Ejercicio6 frame = new Practica1Ejercicio6();
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
	public Practica1Ejercicio6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JList listado = new JList();
		ArrayList<String>misElementos= new ArrayList<String>();
		misElementos.add("a");
		misElementos.add("a");
		misElementos.add("a");
		listado.setListData(misElementos.toArray());
		
		contentPane.add(listado, BorderLayout.CENTER);
	}

}
