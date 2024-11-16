package tarea1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class calculadora extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtResultado;
    private double num1, num2, resultado;
    private String operador;

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
        setBounds(100, 100, 350, 500);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        txtResultado = new JTextField();
        txtResultado.setBounds(10, 10, 310, 50);
        txtResultado.setColumns(10);
        txtResultado.setMargin(new Insets(5, 5, 5, 5));
        contentPane.add(txtResultado);

        String[] botones = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        int x = 10, y = 70;
        for (int i = 0; i < botones.length; i++) {
            JButton btn = new JButton(botones[i]);
            btn.setBounds(x, y, 70, 50);
            btn.setBackground(new Color(211, 211, 211)); 
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn.setMargin(new Insets(5, 30, 30, 5));
            btn.setBorderPainted(false);
            btn.setFocusPainted(false);
            btn.setForeground(Color.BLACK);
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    botonPresionado(e);
                }
            });
            contentPane.add(btn);

            x += 80;
            if (x > 250) {
                x = 10;
                y += 60;
            }
        }

        JButton btnBorrar = new JButton("C");
        btnBorrar.setBounds(10, 330, 150, 50);
        btnBorrar.setBackground(new Color(211, 211, 211));
        btnBorrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBorrar.setMargin(new Insets(5, 30, 30, 5));
        btnBorrar.setBorderPainted(false);
        btnBorrar.setFocusPainted(false);
        btnBorrar.setForeground(Color.BLACK);
        btnBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtResultado.setText(""); 
            }
        });
        contentPane.add(btnBorrar);
    }

    private void botonPresionado(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equals("=")) {
            num2 = Double.parseDouble(txtResultado.getText());
            switch (operador) {
                case "+":
                    resultado = num1 + num2;
                    break;
                case "-":
                    resultado = num1 - num2;
                    break;
                case "*":
                    resultado = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        resultado = num1 / num2;
                    } else {
                        txtResultado.setText("Error");
                        return;
                    }
                    break;
            }
            txtResultado.setText(String.valueOf(resultado));
            operador = "";
        } else if (comando.equals("+") || comando.equals("-") || comando.equals("*") || comando.equals("/")) {
            num1 = Double.parseDouble(txtResultado.getText());
            operador = comando;
            txtResultado.setText(""); 
        } else {
            txtResultado.setText(txtResultado.getText() + comando);
        }
    }
}
