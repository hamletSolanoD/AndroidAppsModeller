package Temario_Educativo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import ValoresDefault.Constantes;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchEvent.Modifier;
import java.nio.file.spi.FileTypeDetector;
import java.util.Iterator;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;


import MySwingComponents.MyJTextPane;
import Proyecto.Proyecto;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.Color;
import javax.swing.JTextPane;

public class Temario_Educativo_Portada extends JFrame implements ActionListener, DocumentListener {
	private JTextField JTextField_TituloPortada;
	private JTextField JTextField_FotoDePortada;
	private MyJTextPane JTextPane_Portada;
	private Image ImagenReescalada;
	public Temario_Educativo_Portada() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Constantes.PantallaOrdenadorX/3,Constantes.PantallaOrdenadorY/10,Constantes.PantallaOrdenadorX/2, (Constantes.PantallaOrdenadorY/9)*6);
		setResizable(false);
		JPanel JPanel_Portada = new JPanel();
		JPanel_Portada.setBackground(Constantes.Fondo);
		getContentPane().add(JPanel_Portada, BorderLayout.NORTH);
		JPanel_Portada.setLayout(new BorderLayout(0, 0));
		
		JLabel JLabel_Titulo = new JLabel("Portada");
		JLabel_Titulo.setForeground(Constantes.ColorTexto);
		JLabel_Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_Titulo.setFont(Constantes.Titulos);
		JPanel_Portada.add(JLabel_Titulo, BorderLayout.CENTER);
		
		Component horizontalStrut = Box.createHorizontalStrut(70);
		JPanel_Portada.add(horizontalStrut, BorderLayout.WEST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(70);
		JPanel_Portada.add(horizontalStrut_1, BorderLayout.EAST);
		
		Component verticalGlue = Box.createVerticalGlue();
		JPanel_Portada.add(verticalGlue, BorderLayout.SOUTH);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		JPanel_Portada.add(verticalGlue_1, BorderLayout.NORTH);
		
		JPanel Panel_Contenido = new JPanel();
		getContentPane().add(Panel_Contenido, BorderLayout.CENTER);
		Panel_Contenido.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel Panel_Caracteristicas = new JPanel();
		Panel_Caracteristicas.setBackground(Constantes.Fondo);

		Panel_Caracteristicas.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		Panel_Contenido.add(Panel_Caracteristicas);
		Panel_Caracteristicas.setLayout(new BorderLayout(0, 0));
		
		JPanel SubPanel__Caracteristicas = new JPanel();
		SubPanel__Caracteristicas.setBackground(Constantes.Fondo);
		Panel_Caracteristicas.add(SubPanel__Caracteristicas, BorderLayout.CENTER);
		SubPanel__Caracteristicas.setLayout(new GridLayout(0, 1, 0, 0));
		
		Component verticalStrut_8 = Box.createVerticalStrut(20);
		SubPanel__Caracteristicas.add(verticalStrut_8);
		
		JLabel JLable_TituloApp = new JLabel("Titulo de portada");
		JLable_TituloApp.setForeground(Constantes.ColorTexto);
		JLable_TituloApp.setFont(Constantes.textoNormal);
		SubPanel__Caracteristicas.add(JLable_TituloApp);
		////////////////////////////////////////////////////////////// EVENTO /////////////////////////////////
		JTextField_TituloPortada = new JTextField();
		JTextField_TituloPortada.setBackground(Constantes.Fondo.darker());
		JTextField_TituloPortada.setForeground(Constantes.Fondo.brighter());
		JTextField_TituloPortada.setFont(Constantes.Titulos);
		SubPanel__Caracteristicas.add(JTextField_TituloPortada);
		JTextField_TituloPortada.getDocument().addDocumentListener(this);
//////////////////////////////////////////////////////////////EVENTO /////////////////////////////////
		
		Component verticalStrut_7 = Box.createVerticalStrut(20);
		SubPanel__Caracteristicas.add(verticalStrut_7);
		
		Component verticalStrut_9 = Box.createVerticalStrut(20);
		SubPanel__Caracteristicas.add(verticalStrut_9);
		
		Component verticalStrut_6 = Box.createVerticalStrut(20);
		SubPanel__Caracteristicas.add(verticalStrut_6);
		
		JLabel JLabel_FotoPortada = new JLabel("Foto de portada");
		JLabel_FotoPortada.setFont(Constantes.textoNormal);
		JLabel_FotoPortada.setForeground(Constantes.ColorTexto);
		SubPanel__Caracteristicas.add(JLabel_FotoPortada);
		
		JTextField_FotoDePortada = new JTextField();
		JTextField_FotoDePortada.setBackground(Constantes.Fondo.darker());
		JTextField_FotoDePortada.setForeground(Constantes.Fondo.brighter());
		JTextField_FotoDePortada.setEnabled(false);
		JTextField_FotoDePortada.setEditable(false);
		JTextField_FotoDePortada.setHorizontalAlignment(SwingConstants.CENTER);
		SubPanel__Caracteristicas.add(JTextField_FotoDePortada);
		JTextField_FotoDePortada.setFont(Constantes.textoNormal);
		JTextField_FotoDePortada.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Constantes.Fondo);
		SubPanel__Caracteristicas.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton Btn_CargarFoto = new JButton("Cargar Foto ...");
		panel.add(Btn_CargarFoto, BorderLayout.CENTER);
		Btn_CargarFoto.setActionCommand("JFile");
		Btn_CargarFoto.addActionListener(this);
		
		Component verticalStrut_4 = Box.createVerticalStrut(11);
		panel.add(verticalStrut_4, BorderLayout.SOUTH);
		
		Component verticalStrut_5 = Box.createVerticalStrut(9);
		panel.add(verticalStrut_5, BorderLayout.NORTH);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_6, BorderLayout.WEST);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_7, BorderLayout.EAST);
		
		
		
		
		
		Component verticalStrut_2 = Box.createVerticalStrut(63);
		Panel_Caracteristicas.add(verticalStrut_2, BorderLayout.NORTH);
		
		Component verticalStrut_3 = Box.createVerticalStrut(21);
		Panel_Caracteristicas.add(verticalStrut_3, BorderLayout.SOUTH);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(22);
		Panel_Caracteristicas.add(horizontalStrut_4, BorderLayout.WEST);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		Panel_Caracteristicas.add(horizontalStrut_5, BorderLayout.EAST);
		
		JPanel Panel_Previsualizacion = new JPanel();
		Panel_Previsualizacion.setBackground(Constantes.Fondo);
		Panel_Contenido.add(Panel_Previsualizacion);
		Panel_Previsualizacion.setLayout(new BorderLayout(0, 0));
	    
	    JPanel panel_3 = new JPanel();
	    panel_3.setBackground(Constantes.Fondo);
	    Panel_Previsualizacion.add(panel_3, BorderLayout.NORTH);
	    panel_3.setLayout(new BorderLayout(0, 0));
	    
	    JPanel panel_1 = new JPanel();
	    panel_3.add(panel_1);
	    panel_1.setLayout(new GridLayout(2, 1, 0, 0));
	    
	    JPanel panel_2_1 = new JPanel();
	    panel_1.add(panel_2_1);
	    panel_2_1.setForeground(Proyecto.getColorSecundario());
	    panel_2_1.setBackground(Proyecto.getColorSecundario());
	    panel_2_1.setLayout(new GridLayout(0, 1, 0, 0));
	    
	    Component verticalStrut_12 = Box.createVerticalStrut(20);
	    panel_2_1.add(verticalStrut_12);
	    
	    
	 
 
	    JPanel panel_2 = new JPanel();
	    panel_1.add(panel_2);
	    panel_2.setBackground(Proyecto.getColorPrimario());
	    panel_2.setForeground(Proyecto.getColorPrimario());
	    panel_2.setLayout(new GridLayout(0, 1, 0, 0));
	    
	    Component verticalStrut_13 = Box.createVerticalStrut(20);
	    panel_2.add(verticalStrut_13);
	    
	    Component verticalStrut_10 = Box.createVerticalStrut(25);
	    panel_3.add(verticalStrut_10, BorderLayout.NORTH);
	    
	    Component horizontalStrut_10 = Box.createHorizontalStrut(85);
	    panel_3.add(horizontalStrut_10, BorderLayout.WEST);
	    
	    Component horizontalStrut_11 = Box.createHorizontalStrut(85);
	    panel_3.add(horizontalStrut_11, BorderLayout.EAST);
		
	    JTextPane_Portada = new MyJTextPane(null);
	    JTextPane_Portada.setForeground(Proyecto.getColorSecundario());
	    JTextPane_Portada.setText("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
	    JTextPane_Portada.setFont(Constantes.Titulos);
	    JTextPane_Portada.setEditable(false);
		Panel_Previsualizacion.add(JTextPane_Portada);
		
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(85);
		Panel_Previsualizacion.add(horizontalStrut_8, BorderLayout.WEST);
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(85);
		Panel_Previsualizacion.add(horizontalStrut_9, BorderLayout.EAST);
		
		Component verticalStrut_11 = Box.createVerticalStrut(57);
		Panel_Previsualizacion.add(verticalStrut_11, BorderLayout.SOUTH);
		
		JPanel JPanel_Hecho = new JPanel();
		JPanel_Hecho.setBackground(Constantes.Fondo);
		getContentPane().add(JPanel_Hecho, BorderLayout.SOUTH);
		JPanel_Hecho.setLayout(new BorderLayout(0, 0));
		
		JButton Btn_Hecho = new JButton("Hecho");
		Btn_Hecho.addActionListener(this);
		Btn_Hecho.setActionCommand("Hecho");
		Btn_Hecho.setFont(Constantes.botones);
		JPanel_Hecho.add(Btn_Hecho, BorderLayout.CENTER);
		
		Component verticalStrut = Box.createVerticalStrut(23);
		JPanel_Hecho.add(verticalStrut, BorderLayout.SOUTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(19);
		JPanel_Hecho.add(verticalStrut_1, BorderLayout.NORTH);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(97);
		JPanel_Hecho.add(horizontalStrut_2, BorderLayout.WEST);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(97);
		JPanel_Hecho.add(horizontalStrut_3, BorderLayout.EAST);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}


	private void OnJFile() {
	JFileChooser jFileChooser = new JFileChooser();
	jFileChooser.setDialogType(JFileChooser.FILES_AND_DIRECTORIES);
	int opcion = jFileChooser.showDialog(this,"Cargar");
	FileTypeDetector fileTypeDetector = new FileTypeDetector() {
		
		public String probeContentType(Path path) throws IOException {
			 System.out.println("probe " + path + "...");
		        String name = path.toString();
		        return (name.endsWith(".jpg")||name.endsWith(".JPG")|| name.endsWith("PNG")||name.endsWith(".png"))  ?  "verdadero" : null;
		}
	};
	
	if(opcion == JFileChooser.APPROVE_OPTION && !jFileChooser.getSelectedFile().getName().equals("") && !jFileChooser.getSelectedFile().equals(null))
	{
		
		    try {
			if(!fileTypeDetector.probeContentType(jFileChooser.getSelectedFile().toPath()).equals(null)) {
			JTextField_FotoDePortada.setText(jFileChooser.getSelectedFile().getAbsolutePath());
			
			 ImagenReescalada = new ImageIcon(jFileChooser.getSelectedFile().getAbsolutePath()).getImage();
			 JTextPane_Portada.repaint(ImagenReescalada);
		}
			
			else {
				JOptionPane.showMessageDialog(this, "Tipo de archivo incorrecto");
			}
		   }
		    catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Error al cargar el archivo");
			}
}else {
	JOptionPane.showMessageDialog(this, "Error al cargar el archivo");	}
	


	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch(arg0.getActionCommand()) {
		case "JFile": OnJFile(); break;
		case "Hecho":  
			try {
			if(!ImagenReescalada.equals(null) && !JTextField_TituloPortada.getText().isEmpty()) {
			Proyecto.setImagenPortada(ImagenReescalada);
			Proyecto.setTitulo_Portada(JTextField_TituloPortada.getText());
			Proyecto.SetMainScenesManager(); 
			dispose();
			}
			else {
				JOptionPane.showMessageDialog(this, "Error al llenar el formulario.");			}
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Error al llenar el formulario");
				System.out.print("error "+e.getMessage());
			}
			break;
		}
		
		}


	@Override
	public void changedUpdate(DocumentEvent arg0) {
		JTextPane_Portada.setText(JTextField_TituloPortada.getText());
		SimpleAttributeSet center =  new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		JTextPane_Portada.getStyledDocument().setParagraphAttributes(0, JTextPane_Portada.getStyledDocument().getLength(),center, false);
	
	}

	

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		JTextPane_Portada.setText(JTextField_TituloPortada.getText());
		SimpleAttributeSet center =  new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		JTextPane_Portada.getStyledDocument().setParagraphAttributes(0, JTextPane_Portada.getStyledDocument().getLength(),center, false);
	
	}


	@Override
	public void removeUpdate(DocumentEvent arg0){
		// TODO Auto-generated method stub
		JTextPane_Portada.setText(JTextField_TituloPortada.getText());
		SimpleAttributeSet center =  new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		JTextPane_Portada.getStyledDocument().setParagraphAttributes(0, JTextPane_Portada.getStyledDocument().getLength(),center, false);
	
	}
}
