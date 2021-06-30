package Temario_Educativo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MySwingComponents.MyJPanel_ConFondo;
import ValoresDefault.Constantes;
import ValoresDefault.Constantes.TipoFicha;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout.Constraints;

import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Insets;

public class AgregarTipoDeFicha extends JFrame implements ActionListener {

	AgregarTipoDeFicha_Caracteristicas Caracteristicas;
	Temario_Educativo_MainScenesManager VentanaPrincipalTemario;
	
	private JPanel contentPane;
	private ButtonGroup OpcionesDeFichas = new ButtonGroup();
	JInternalFrame_IndiceEducativo Padre;
	
	public AgregarTipoDeFicha(JInternalFrame_IndiceEducativo Padre, Temario_Educativo_MainScenesManager VentanaPrincipalTemario) throws IOException {
		this.Padre = Padre;
		this.VentanaPrincipalTemario = VentanaPrincipalTemario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Constantes.PantallaOrdenadorX/4,Constantes.PantallaOrdenadorY/4,Constantes.PantallaOrdenadorX/2,(Constantes.PantallaOrdenadorY/10)*6);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel JPanelHecho = new JPanel();
		JPanelHecho.setBackground(Constantes.Fondo);
		getContentPane().add(JPanelHecho, BorderLayout.SOUTH);
		JPanelHecho.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Constantes.Fondo);
		JPanelHecho.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton JButton_Hecho = new JButton("Hecho");
		JButton_Hecho.setActionCommand("Hecho");
		JButton_Hecho.addActionListener(this);
		
		panel.add(JButton_Hecho);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_6);
		
		JButton JButton_Cancelar = new JButton("Cancelar");
		panel.add(JButton_Cancelar);
		JButton_Cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		JPanelHecho.add(horizontalStrut_1, BorderLayout.EAST);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		JPanelHecho.add(verticalStrut_2, BorderLayout.NORTH);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		JPanelHecho.add(verticalStrut_3, BorderLayout.SOUTH);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		JPanelHecho.add(horizontalStrut, BorderLayout.WEST);
		
		JPanel JPanelTitulo = new JPanel();
		JPanelTitulo.setBackground(Constantes.Fondo);
		getContentPane().add(JPanelTitulo, BorderLayout.NORTH);
		JPanelTitulo.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Tipo De Ficha");
		lblNewLabel.setBackground(Constantes.Fondo);
		lblNewLabel.setForeground(Constantes.ColorTexto);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(Constantes.Titulos);
		JPanelTitulo.add(lblNewLabel);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		JPanelTitulo.add(verticalStrut, BorderLayout.NORTH);
		
		JPanel JPanelContenido = new JPanel();
		JPanelContenido.setBackground(Constantes.Fondo);
		getContentPane().add(JPanelContenido, BorderLayout.CENTER);
		JPanelContenido.setLayout(new BorderLayout(0, 0));
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		JPanelContenido.add(verticalStrut_1, BorderLayout.NORTH);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		JPanelContenido.add(horizontalStrut_2, BorderLayout.WEST);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		JPanelContenido.add(horizontalStrut_3, BorderLayout.EAST);
		
		JPanel Contenido = new JPanel();
		Contenido.setBackground(Constantes.Fondo);
		JPanelContenido.add(Contenido);
		GridLayout grd = new GridLayout(1, 4, 0, 0);
		grd.setHgap(10);
		Contenido.setLayout(grd);
	
		JRadioButton JRadioButton_IndiceInformativo = new JRadioButton();
		JRadioButton_IndiceInformativo.setLayout(new BorderLayout());
		Contenido.add(JRadioButton_IndiceInformativo);//panel
		JRadioButton_IndiceInformativo.setBackground(Constantes.Fondo);
		JRadioButton_IndiceInformativo.setHorizontalAlignment(SwingConstants.CENTER);
		JRadioButton_IndiceInformativo.setVerticalAlignment(SwingConstants.BOTTOM);
		JRadioButton_IndiceInformativo.setActionCommand(Constantes.TipoFicha.Ficha_Indice.GetTipo_Ficha());
		OpcionesDeFichas.add(JRadioButton_IndiceInformativo);
		
		Component Espacio = Box.createVerticalStrut(20);
		JRadioButton_IndiceInformativo.add(Espacio,BorderLayout.SOUTH);
		
		
		
		JPanel Ficha_IndiceInformativo = new JPanel();
		Ficha_IndiceInformativo.setBackground(Constantes.Fondo);
		//Contenido.add(Ficha_IndiceInformativo);
		Ficha_IndiceInformativo.setLayout( new GridBagLayout());
		JRadioButton_IndiceInformativo.add(Ficha_IndiceInformativo,BorderLayout.CENTER);

		
		
		MyJPanel_ConFondo MyJPanel_ConFondo__FichaIndiceInformativo_Imagen = 
				new MyJPanel_ConFondo(ImageIO.read(getClass().getResource("/Ficha_IndiceInformativo.png"))
						.getScaledInstance(getWidth(),getHeight(),Image.SCALE_SMOOTH),getWidth(),getHeight());
		GridBagConstraints gbc_MyJPanel_ConFondo__FichaIndiceInformativo_Imagen = new GridBagConstraints();
		gbc_MyJPanel_ConFondo__FichaIndiceInformativo_Imagen.weighty = 1;
		gbc_MyJPanel_ConFondo__FichaIndiceInformativo_Imagen.weightx = 1;
		gbc_MyJPanel_ConFondo__FichaIndiceInformativo_Imagen.gridheight = 3;
		gbc_MyJPanel_ConFondo__FichaIndiceInformativo_Imagen.fill = GridBagConstraints.BOTH;
		gbc_MyJPanel_ConFondo__FichaIndiceInformativo_Imagen.insets = new Insets(0, 0, 5, 0);
		gbc_MyJPanel_ConFondo__FichaIndiceInformativo_Imagen.gridx = 0;
		gbc_MyJPanel_ConFondo__FichaIndiceInformativo_Imagen.gridy = 0;
		Ficha_IndiceInformativo.add(MyJPanel_ConFondo__FichaIndiceInformativo_Imagen, gbc_MyJPanel_ConFondo__FichaIndiceInformativo_Imagen);
		
		JLabel JLabel_FichaIndiceInformativo_Titulo = new JLabel("Indice Informativo");
		JLabel_FichaIndiceInformativo_Titulo.setForeground(Constantes.ColorTexto);
		JLabel_FichaIndiceInformativo_Titulo.setFont(Constantes.textoNormal);
		JLabel_FichaIndiceInformativo_Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_JLabel_FichaIndiceInformativo_Titulo = new GridBagConstraints();
		gbc_JLabel_FichaIndiceInformativo_Titulo.fill = GridBagConstraints.BOTH;
		gbc_JLabel_FichaIndiceInformativo_Titulo.insets = new Insets(0, 0, 5, 0);
		gbc_JLabel_FichaIndiceInformativo_Titulo.gridx = 0;
		gbc_JLabel_FichaIndiceInformativo_Titulo.gridy = 3;
		Ficha_IndiceInformativo.add(JLabel_FichaIndiceInformativo_Titulo, gbc_JLabel_FichaIndiceInformativo_Titulo);
		
		JTextPane JTextPane_FichaIndiceInformativo_Descripcion = new JTextPane();
		JTextPane_FichaIndiceInformativo_Descripcion.setBackground(Constantes.Fondo);
		JTextPane_FichaIndiceInformativo_Descripcion.setForeground(Constantes.ColorTexto);
		JTextPane_FichaIndiceInformativo_Descripcion.setText("Indice que puede dar acceso a otros indices o fichas informativas");
		JTextPane_FichaIndiceInformativo_Descripcion.setEnabled(false);
		JTextPane_FichaIndiceInformativo_Descripcion.setEditable(false);
		GridBagConstraints gbc_JTextPane_FichaIndiceInformativo_Descripcion = new GridBagConstraints();
		gbc_JTextPane_FichaIndiceInformativo_Descripcion.gridheight = 2;
		gbc_JTextPane_FichaIndiceInformativo_Descripcion.fill = GridBagConstraints.BOTH;
		gbc_JTextPane_FichaIndiceInformativo_Descripcion.insets = new Insets(0, 0, 5, 0);
		gbc_JTextPane_FichaIndiceInformativo_Descripcion.gridx = 0;
		gbc_JTextPane_FichaIndiceInformativo_Descripcion.gridy = 4;
		Ficha_IndiceInformativo.add(JTextPane_FichaIndiceInformativo_Descripcion, gbc_JTextPane_FichaIndiceInformativo_Descripcion);
		
		JRadioButton JRadioButton_FichaInformativa = new JRadioButton("");
		Contenido.add(JRadioButton_FichaInformativa);
		JRadioButton_FichaInformativa.setLayout(new BorderLayout());
		JRadioButton_FichaInformativa.setBackground(Constantes.Fondo);
		JRadioButton_FichaInformativa.setActionCommand(Constantes.TipoFicha.Ficha_Informativa.GetTipo_Ficha());
		JRadioButton_FichaInformativa.setHorizontalAlignment(SwingConstants.CENTER);
		JRadioButton_FichaInformativa.setVerticalAlignment(SwingConstants.BOTTOM);
		OpcionesDeFichas.add(JRadioButton_FichaInformativa);
		Component Espacio2 = Box.createVerticalStrut(20);
		JRadioButton_FichaInformativa.add(Espacio2,BorderLayout.SOUTH);
		
		
		
	
		JPanel Ficha_Informativa = new JPanel();
		Ficha_Informativa.setBackground(Constantes.Fondo);
		JRadioButton_FichaInformativa.add(Ficha_Informativa,BorderLayout.CENTER);
		GridBagLayout gbl_Ficha_Informativa = new GridBagLayout();
		Ficha_Informativa.setLayout(gbl_Ficha_Informativa);
		
		MyJPanel_ConFondo MyJPanel_ConFondo_Ficha_InformativaImagen = new MyJPanel_ConFondo(ImageIO.read(getClass().getResource("/Ficha_Informativa.png"))
						.getScaledInstance(getWidth(),getHeight(),Image.SCALE_SMOOTH),getWidth(),getHeight());
		GridBagConstraints gbc_JLabel_Ficha_InformativaImagen = new GridBagConstraints();
		gbc_JLabel_Ficha_InformativaImagen.weighty = 1;
		gbc_JLabel_Ficha_InformativaImagen.weightx = 1;
		gbc_JLabel_Ficha_InformativaImagen.gridheight = 3;
		gbc_JLabel_Ficha_InformativaImagen.fill = GridBagConstraints.BOTH;
		gbc_JLabel_Ficha_InformativaImagen.insets = new Insets(0, 0, 5, 0);
		gbc_JLabel_Ficha_InformativaImagen.gridx = 0;
		gbc_JLabel_Ficha_InformativaImagen.gridy = 0;
		Ficha_Informativa.add(MyJPanel_ConFondo_Ficha_InformativaImagen, gbc_JLabel_Ficha_InformativaImagen);
		
		JLabel JLabel_FichaInformativa_Titulo = new JLabel("Ficha Informativa");
		JLabel_FichaInformativa_Titulo.setBackground(Constantes.Fondo);
		JLabel_FichaInformativa_Titulo.setForeground(Constantes.ColorTexto);
		JLabel_FichaInformativa_Titulo.setFont(Constantes.textoNormal);
		JLabel_FichaInformativa_Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_JLabel_FichaInformativa_Titulo = new GridBagConstraints();
		gbc_JLabel_FichaInformativa_Titulo.fill = GridBagConstraints.BOTH;
		gbc_JLabel_FichaInformativa_Titulo.insets = new Insets(0, 0, 5, 0);
		gbc_JLabel_FichaInformativa_Titulo.gridx = 0;
		gbc_JLabel_FichaInformativa_Titulo.gridy = 3;
		Ficha_Informativa.add(JLabel_FichaInformativa_Titulo, gbc_JLabel_FichaInformativa_Titulo);
		
		JTextPane JTextPane_FichaInformativa_Descripcion = new JTextPane();
		JTextPane_FichaInformativa_Descripcion.setBackground(Constantes.Fondo);
		JTextPane_FichaInformativa_Descripcion.setText("Ficha informativa en la cual se puede agregar parrafos e imagenes para dar a conocer informacion");
		JTextPane_FichaInformativa_Descripcion.setEnabled(false);
		JTextPane_FichaInformativa_Descripcion.setEditable(false);
		GridBagConstraints gbc_JTextPane_FichaInformativa_Descripcion = new GridBagConstraints();
		gbc_JTextPane_FichaInformativa_Descripcion.gridheight = 2;
		gbc_JTextPane_FichaInformativa_Descripcion.fill = GridBagConstraints.BOTH;
		gbc_JTextPane_FichaInformativa_Descripcion.insets = new Insets(0, 0, 5, 0);
		gbc_JTextPane_FichaInformativa_Descripcion.gridy = 2;
		gbc_JTextPane_FichaInformativa_Descripcion.gridx = 0;
		gbc_JTextPane_FichaInformativa_Descripcion.gridy = 4;
		Ficha_Informativa.add(JTextPane_FichaInformativa_Descripcion, gbc_JTextPane_FichaInformativa_Descripcion);
		
		JRadioButton JRadioButton_FichaLinealHorizontal = new JRadioButton("");
		JRadioButton_FichaLinealHorizontal.setLayout(new BorderLayout());
		Contenido.add(JRadioButton_FichaLinealHorizontal);
		JRadioButton_FichaLinealHorizontal.setBackground(Constantes.Fondo);
		JRadioButton_FichaLinealHorizontal.setActionCommand(Constantes.TipoFicha.Ficha_LinealHorizontal.GetTipo_Ficha());
		JRadioButton_FichaLinealHorizontal.setHorizontalAlignment(SwingConstants.CENTER);
		JRadioButton_FichaLinealHorizontal.setVerticalAlignment(SwingConstants.BOTTOM);
		OpcionesDeFichas.add(JRadioButton_FichaLinealHorizontal);
		Component Espacio3 = Box.createVerticalStrut(20);
		JRadioButton_FichaLinealHorizontal.add(Espacio3,BorderLayout.SOUTH);
		
		
		JPanel Ficha_LinealHorizontal = new JPanel();
		Ficha_LinealHorizontal.setBackground(Constantes.Fondo);
		Ficha_LinealHorizontal.setLayout(new GridBagLayout());
		JRadioButton_FichaLinealHorizontal.add(Ficha_LinealHorizontal,BorderLayout.CENTER);
		
		MyJPanel_ConFondo MyJPanel_ConFondo_FichaLinealHorizontal_Imagen = new MyJPanel_ConFondo(ImageIO.read(getClass().getResource("/Ficha_Lineal_Horizonta.png")),getWidth(),getHeight());
		GridBagConstraints gbc_MyJPanel_ConFondo_FichaLinealHorizontal_Imagen = new GridBagConstraints();
		gbc_MyJPanel_ConFondo_FichaLinealHorizontal_Imagen.gridheight = 3;
		gbc_MyJPanel_ConFondo_FichaLinealHorizontal_Imagen.weightx = 1;
		gbc_MyJPanel_ConFondo_FichaLinealHorizontal_Imagen.weighty = 1;
		gbc_MyJPanel_ConFondo_FichaLinealHorizontal_Imagen.fill = GridBagConstraints.BOTH;
		gbc_MyJPanel_ConFondo_FichaLinealHorizontal_Imagen.insets = new Insets(0, 0, 5, 0);
		gbc_MyJPanel_ConFondo_FichaLinealHorizontal_Imagen.gridx = 0;
		gbc_MyJPanel_ConFondo_FichaLinealHorizontal_Imagen.gridy = 0;
		Ficha_LinealHorizontal.add(MyJPanel_ConFondo_FichaLinealHorizontal_Imagen, gbc_MyJPanel_ConFondo_FichaLinealHorizontal_Imagen);
		
		JLabel JLabel_FichaLinealHorizontal_Titulo = new JLabel("Ficha Lineal Horizontal");
		JLabel_FichaLinealHorizontal_Titulo.setForeground(Constantes.ColorTexto);
		JLabel_FichaLinealHorizontal_Titulo.setFont(Constantes.textoNormal);
		JLabel_FichaLinealHorizontal_Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_JLabel_FichaLinealHorizontal_Titulo = new GridBagConstraints();
		gbc_JLabel_FichaLinealHorizontal_Titulo.fill = GridBagConstraints.BOTH;
		gbc_JLabel_FichaLinealHorizontal_Titulo.insets = new Insets(0, 0, 5, 0);
		gbc_JLabel_FichaLinealHorizontal_Titulo.gridx = 0;
		gbc_JLabel_FichaLinealHorizontal_Titulo.gridy = 3;
		Ficha_LinealHorizontal.add(JLabel_FichaLinealHorizontal_Titulo, gbc_JLabel_FichaLinealHorizontal_Titulo);
		
		JTextPane JTextPane_FichaLinealHorizontal_Descripcion = new JTextPane();
		JTextPane_FichaLinealHorizontal_Descripcion.setBackground(Constantes.Fondo);
		JTextPane_FichaLinealHorizontal_Descripcion.setText("Ficha informativa en la cual se puede agregar peque\u00F1os parrafos o imagenes y titulos para dar a conocer informacion de forma mas didactica y resumida de una forma lineal horizontal ");
		JTextPane_FichaLinealHorizontal_Descripcion.setEnabled(false);
		JTextPane_FichaLinealHorizontal_Descripcion.setEditable(false);
		GridBagConstraints gbc_JTextPane_FichaLinealHorizontal_Descripcion = new GridBagConstraints();
		gbc_JTextPane_FichaLinealHorizontal_Descripcion.gridheight = 2;
		gbc_JTextPane_FichaLinealHorizontal_Descripcion.fill = GridBagConstraints.BOTH;
		gbc_JTextPane_FichaLinealHorizontal_Descripcion.insets = new Insets(0, 0, 5, 0);
		gbc_JTextPane_FichaLinealHorizontal_Descripcion.gridx = 0;
		gbc_JTextPane_FichaLinealHorizontal_Descripcion.gridy = 4;
		Ficha_LinealHorizontal.add(JTextPane_FichaLinealHorizontal_Descripcion, gbc_JTextPane_FichaLinealHorizontal_Descripcion);
		
		JRadioButton JRadioButton_FichaLinealVertical = new JRadioButton("");
		JRadioButton_FichaLinealVertical.setLayout(new BorderLayout());
		Contenido.add(JRadioButton_FichaLinealVertical);
		JRadioButton_FichaLinealVertical.setBackground(Constantes.Fondo);
		JRadioButton_FichaLinealVertical.setActionCommand(Constantes.TipoFicha.Ficha_LinealVertical.GetTipo_Ficha());
		JRadioButton_FichaLinealVertical.setHorizontalAlignment(SwingConstants.CENTER);
		JRadioButton_FichaLinealVertical.setVerticalAlignment(SwingConstants.BOTTOM);
		Component Espacio4 = Box.createVerticalStrut(20);
		JRadioButton_FichaLinealVertical.add(Espacio4,BorderLayout.SOUTH);
		
		OpcionesDeFichas.add(JRadioButton_FichaLinealVertical);
		
		JPanel Ficha_LinealVertical = new JPanel();
		Ficha_LinealVertical.setBackground(Constantes.Fondo);
		JRadioButton_FichaLinealVertical.add(Ficha_LinealVertical,BorderLayout.CENTER);
		GridBagLayout gbl_Ficha_LinealVertical = new GridBagLayout();
		Ficha_LinealVertical.setLayout(gbl_Ficha_LinealVertical);
		
		MyJPanel_ConFondo MyJPanel_ConFondo_FichaLinealVertical_Imagen = new MyJPanel_ConFondo(ImageIO.read(getClass().getResource("/Ficha_Lineal_Vertical.png")).
				getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH),getWidth(),getHeight());
		GridBagConstraints gbc_JLabel_FichaLinealVertical_Imagen = new GridBagConstraints();
		gbc_JLabel_FichaLinealVertical_Imagen.gridheight = 3;
		gbc_JLabel_FichaLinealVertical_Imagen.weightx = 1;
		gbc_JLabel_FichaLinealVertical_Imagen.weighty = 1;
		gbc_JLabel_FichaLinealVertical_Imagen.fill = GridBagConstraints.BOTH;
		gbc_JLabel_FichaLinealVertical_Imagen.insets = new Insets(0, 0, 5, 0);
		gbc_JLabel_FichaLinealVertical_Imagen.gridx = 0;
		gbc_JLabel_FichaLinealVertical_Imagen.gridy = 0;
		Ficha_LinealVertical.add(MyJPanel_ConFondo_FichaLinealVertical_Imagen, gbc_JLabel_FichaLinealVertical_Imagen);
		
		JLabel JLabel_FichaLinealVertical_Titulo = new JLabel("Ficha Lineal Vertical");
		JLabel_FichaLinealVertical_Titulo.setForeground(Constantes.ColorTexto);
		JLabel_FichaLinealVertical_Titulo.setFont(Constantes.textoNormal);
		JLabel_FichaLinealVertical_Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_JLabel_FichaLinealVertical_Titulo = new GridBagConstraints();
		gbc_JLabel_FichaLinealVertical_Titulo.fill = GridBagConstraints.BOTH;
		gbc_JLabel_FichaLinealVertical_Titulo.insets = new Insets(0, 0, 5, 0);
		gbc_JLabel_FichaLinealVertical_Titulo.gridx = 0;
		gbc_JLabel_FichaLinealVertical_Titulo.gridy = 3;
		Ficha_LinealVertical.add(JLabel_FichaLinealVertical_Titulo, gbc_JLabel_FichaLinealVertical_Titulo);
		
		JTextPane JTextPane_FichaLinealVertical_Descripcion = new JTextPane();
		JTextPane_FichaLinealVertical_Descripcion.setBackground(Constantes.Fondo);
		JTextPane_FichaLinealVertical_Descripcion.setText("Ficha informativa en la cual se puede agregar peque\u00F1os parrafos o imagenes y titulos para dar a conocer informacion de forma mas didactica y resumida de una forma lineal Vertical\r\n\r\n");
		JTextPane_FichaLinealVertical_Descripcion.setEditable(false);
		JTextPane_FichaLinealVertical_Descripcion.setEnabled(false);
		GridBagConstraints gbc_JTextPane_FichaLinealVertical_Descripcion = new GridBagConstraints();
		gbc_JTextPane_FichaLinealVertical_Descripcion.gridheight = 2;
		gbc_JTextPane_FichaLinealVertical_Descripcion.fill = GridBagConstraints.BOTH;
		gbc_JTextPane_FichaLinealVertical_Descripcion.insets = new Insets(0, 0, 5, 0);
		gbc_JTextPane_FichaLinealVertical_Descripcion.gridx = 0;
		gbc_JTextPane_FichaLinealVertical_Descripcion.gridy = 4;
		Ficha_LinealVertical.add(JTextPane_FichaLinealVertical_Descripcion, gbc_JTextPane_FichaLinealVertical_Descripcion);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	private void Hecho() {
		if(OpcionesDeFichas.getSelection() != null ){
		TipoFicha Tipo = null;
		switch(OpcionesDeFichas.getSelection().getActionCommand()) {
		case "Ficha Informativa": Tipo = TipoFicha.Ficha_Informativa; break;
		case "Ficha Lineal Horizontal": Tipo = TipoFicha.Ficha_LinealHorizontal; break;
		case "Ficha Lineal Vertical":Tipo = TipoFicha.Ficha_LinealVertical;  break;
		case "Ficha Indice":  Tipo = TipoFicha.Ficha_Indice; break;		
		}
	    Caracteristicas = new AgregarTipoDeFicha_Caracteristicas(Padre,Tipo, VentanaPrincipalTemario);
		dispose();
		}
		else {
			JOptionPane.showMessageDialog(this,"Formulario Incompleto");
		}
	}
	public AgregarTipoDeFicha_Caracteristicas get_AgregarTipoDeFicha_Caracteristicas() {
		return Caracteristicas;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
	if(arg0.getActionCommand().equals("Hecho")) {
	  Hecho();
		}
	}

}
