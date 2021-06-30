package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ValoresDefault.Constantes;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LoginUser extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUser frame = new LoginUser();
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
	public LoginUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel Titulo = new JPanel();
		contentPane.add(Titulo, BorderLayout.NORTH);
		Titulo.setLayout(new BorderLayout(0, 0));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		Titulo.add(verticalStrut, BorderLayout.NORTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		Titulo.add(verticalStrut_1, BorderLayout.SOUTH);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		Titulo.add(horizontalStrut, BorderLayout.WEST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		Titulo.add(horizontalStrut_1, BorderLayout.EAST);
		
		JLabel JLabel_Titulo = new JLabel("INICIA SESION:");
		JLabel_Titulo.setFont(Constantes.Titulos);
		JLabel_Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.add(JLabel_Titulo, BorderLayout.CENTER);
		
		JPanel Datos = new JPanel();
		contentPane.add(Datos, BorderLayout.CENTER);
		
		JPanel Botones = new JPanel();
		contentPane.add(Botones, BorderLayout.SOUTH);
	}

}
