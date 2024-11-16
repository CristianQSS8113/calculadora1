package tarea1;

import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.BorderLayout;

public class calculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JTextField txtResultado;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculadora frame = new calculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public calculadora() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(calculadora.class.getResource("/img/icono.png")));
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 353, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		txtResultado = new JTextField();
		txtResultado.setBounds( 10, 10, 323, 50);
		txtResultado.setColumns(8);
		getContentPane().add(txtResultado, BorderLayout.NORTH);		
		
	}

}
