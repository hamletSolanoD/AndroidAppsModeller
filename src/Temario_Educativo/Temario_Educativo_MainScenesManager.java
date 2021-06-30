package Temario_Educativo;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import Proyecto.Proyecto;
import ValoresDefault.Constantes;

import javax.swing.JSplitPane;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import javax.swing.JScrollPane;


import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class Temario_Educativo_MainScenesManager extends  JFrame implements InternalFrameListener, ActionListener{

	private static final long serialVersionUID = 1L;
	private static JTextField TxtField_Padre;
	private static JTextField TxtField_Titulo;
	private static JTextField TxtField_ID;
	private static JTextField TxtField_Tipo;
	private static JButton Btn_Abrir;
	private static JInternalFrame_IndiceEducativo VentanaIndiceEducativoEnfocada;
	private static JTextPane TxtPane_Resumen;
	private static JLabel Icon_ImagenPortada;
    private static ButtonGroup Mover_Seleccionar = new ButtonGroup();
	private static JDesktopPane desktopPane;
	
	private static HashMap<String, JInternalFrame_IndiceEducativo> VentanasIndice = new HashMap<String, JInternalFrame_IndiceEducativo>();
	private static HashMap<String, JFrame_FichaEducativa> VentanasIndiceEducativo = new HashMap<String, JFrame_FichaEducativa>();

	
	private String VentanaIndicePrincipal;
		
	public Temario_Educativo_MainScenesManager() {
		
	    setBounds(0,0,Constantes.PantallaOrdenadorX,Constantes.PantallaOrdenadorY);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(new GridLayout(1, 2, 0, 0));
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Constantes.Fondo);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBackground(Constantes.Fondo);
		splitPane.setResizeWeight(0.2);
		panel.add(splitPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setForeground(Constantes.ColorTexto.darker());
		tabbedPane.setBackground(Constantes.Fondo);
		splitPane.setLeftComponent(tabbedPane);
		
		JToolBar Herramientas = new JToolBar();
		Herramientas.setBackground(Constantes.Fondo);
		Herramientas.setFloatable(false);
		tabbedPane.addTab("Herramientas", null, Herramientas, "Agregar, Eliminar, Seleccionar y Mover\r\n");
		
		JPanel HerramientasPanel = new JPanel();
		HerramientasPanel.setBackground(Constantes.Fondo);
		Herramientas.add(HerramientasPanel);
		HerramientasPanel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel JPanel_Agregar_Eliminr = new JPanel();
		JPanel_Agregar_Eliminr.setBackground(Constantes.Fondo);
		HerramientasPanel.add(JPanel_Agregar_Eliminr);
		JPanel_Agregar_Eliminr.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Constantes.Fondo);
		JPanel_Agregar_Eliminr.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(6, 1, 0, 0));
		
		JButton Btn_AgregarFicha = new JButton("Agregar");
		Btn_AgregarFicha.setActionCommand("Agregar");
		Btn_AgregarFicha.addActionListener(this);
		panel_5.add(Btn_AgregarFicha);
		
		JSeparator separator = new JSeparator();
		panel_5.add(separator);
		
		JButton Btn_EliminarFicha = new JButton("Eliminar");
		Btn_EliminarFicha.setActionCommand("Eliminar");
		Btn_EliminarFicha.addActionListener(this);
		panel_5.add(Btn_EliminarFicha);
		
		JSeparator separator_1 = new JSeparator();
		panel_5.add(separator_1);
		
		
		JRadioButton JRadioButton_Seleccionar = new JRadioButton("Seleccionar");
		JRadioButton_Seleccionar.setActionCommand("seleccionar");
		Mover_Seleccionar.add(JRadioButton_Seleccionar);
		Mover_Seleccionar.setSelected(JRadioButton_Seleccionar.getModel(), true);
		panel_5.add(JRadioButton_Seleccionar);
		
		JRadioButton JRadioButton_Mover = new JRadioButton("Mover");
		JRadioButton_Mover.setActionCommand("mover");
		Mover_Seleccionar.add(JRadioButton_Mover);
		panel_5.add(JRadioButton_Mover);
		
		Component verticalStrut = Box.createVerticalStrut(10);
		JPanel_Agregar_Eliminr.add(verticalStrut, BorderLayout.NORTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		JPanel_Agregar_Eliminr.add(verticalStrut_1, BorderLayout.SOUTH);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		JPanel_Agregar_Eliminr.add(horizontalStrut_1, BorderLayout.WEST);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		JPanel_Agregar_Eliminr.add(horizontalStrut, BorderLayout.EAST);
		
		JToolBar Propiedades = new JToolBar();
		Propiedades.setBackground(Constantes.Fondo);
		Propiedades.setFloatable(false);
		tabbedPane.addTab("Propiedades", null, Propiedades, "Propiedades de la ficha: Titulo, ID, Padre, Tipo de ficha, Resumen, Imagen\r\n");
		
		///pintarlos tabb pane
		tabbedPane.setBackgroundAt(0, Constantes.Fondo);
		tabbedPane.setBackgroundAt(1, Constantes.Fondo);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Constantes.Fondo);
		Propiedades.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_4, BorderLayout.SOUTH);
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_5, BorderLayout.NORTH);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_3, BorderLayout.WEST);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_4, BorderLayout.EAST);
		
		JPanel JPanel_Propiedades = new JPanel();
		JPanel_Propiedades.setBackground(Constantes.Fondo);
		JPanel_Propiedades.setLayout(new GridLayout(0, 1, 0, 0));
	    
	    JPanel panel_6 = new JPanel();
	    panel_6.setBackground(Constantes.Fondo);
	    JPanel_Propiedades.add(panel_6);
	    panel_6.setLayout(new GridLayout(11, 0, 0, 0));
	    
	    JLabel lblNewLabel_1 = new JLabel("Titulo:");
	    lblNewLabel_1.setFont(Constantes.textoNormal);
	    lblNewLabel_1.setForeground(Constantes.ColorTexto);
	    panel_6.add(lblNewLabel_1);
	    
	    		TxtField_Titulo = new JTextField();	 
	    		TxtField_Titulo.setBackground(Constantes.Fondo.brighter());
	    		TxtField_Titulo.setFont(Constantes.textoNormal);
	    		TxtField_Titulo.setForeground(Constantes.ColorTexto.darker());    		
	    		panel_6.add(TxtField_Titulo);
	    		TxtField_Titulo.setEditable(false);
	    		TxtField_Titulo.setColumns(10);
	    		
	    		JLabel lblNewLabel_2 = new JLabel("Padre:");
	    		lblNewLabel_2.setForeground(Constantes.ColorTexto);
	    		lblNewLabel_2.setFont(Constantes.textoNormal);
	    		panel_6.add(lblNewLabel_2);
	    		
	    		TxtField_Padre = new JTextField();
	    		TxtField_Padre.setFont(Constantes.textoNormal);
	    		TxtField_Padre.setForeground(Constantes.ColorTexto.darker());   
	    		TxtField_Padre.setBackground(Constantes.Fondo.brighter());
	    		panel_6.add(TxtField_Padre);
	    		TxtField_Padre.setEditable(false);
	    		TxtField_Padre.setColumns(10);
	    		
	    		JLabel lblNewLabel = new JLabel("ID:");
	    		lblNewLabel.setFont(Constantes.textoNormal);
	    		lblNewLabel.setForeground(Constantes.ColorTexto);
	    		panel_6.add(lblNewLabel);
	    		
	    		TxtField_ID = new JTextField();
	    		TxtField_ID.setFont(Constantes.textoNormal);
	    		TxtField_ID.setForeground(Constantes.ColorTexto.darker());   
	    		TxtField_ID.setBackground(Constantes.Fondo.brighter());
	    		panel_6.add(TxtField_ID);
	    		TxtField_ID.setEditable(false);
	    		TxtField_ID.setColumns(10);
	    		
	    		JLabel lblNewLabel_3 = new JLabel("Tipo:");
	    		lblNewLabel_3.setFont(Constantes.textoNormal);
	    		lblNewLabel_3.setForeground(Constantes.ColorTexto);
	    		panel_6.add(lblNewLabel_3);
	    		
	    		TxtField_Tipo = new JTextField();
	    		TxtField_Tipo.setFont(Constantes.textoNormal);
	    		TxtField_Tipo.setForeground(Constantes.ColorTexto.darker());
	    		TxtField_Tipo.setBackground(Constantes.Fondo.brighter());
	    		panel_6.add(TxtField_Tipo);
	    		TxtField_Tipo.setEditable(false);
	    		TxtField_Tipo.setColumns(10);
	    		
	    		JLabel lblNewLabel_4 = new JLabel("Resumen:");
	    		lblNewLabel_4.setFont(Constantes.textoNormal);
	    		lblNewLabel_4.setForeground(Constantes.ColorTexto);
	    		panel_6.add(lblNewLabel_4);
	    		
	    TxtPane_Resumen = new JTextPane();
	    TxtPane_Resumen.setFont(Constantes.textoNormal);
	    TxtPane_Resumen.setForeground(Constantes.ColorTexto.darker());
	    TxtPane_Resumen.setBackground(Constantes.Fondo.brighter());
	    panel_6.add(TxtPane_Resumen);
	    
	    JLabel lblNewLabel_5 = new JLabel("Imagen:");
	    lblNewLabel_5.setFont(Constantes.textoNormal);
	    lblNewLabel_5.setForeground(Constantes.ColorTexto);
	    panel_6.add(lblNewLabel_5);
	    
	    JPanel panel_3 = new JPanel();
	    panel_3.setBackground(Constantes.Fondo);
	    JPanel_Propiedades.add(panel_3);
	    panel_3.setLayout(new BorderLayout(0, 0));
	    
	    
	    Component horizontalStrut_5 = Box.createHorizontalStrut(20);
	    panel_3.add(horizontalStrut_5, BorderLayout.WEST);
	    
	    Component horizontalStrut_6 = Box.createHorizontalStrut(20);
	    panel_3.add(horizontalStrut_6, BorderLayout.EAST);
	    
	    Component verticalStrut_6 = Box.createVerticalStrut(20);
	    panel_3.add(verticalStrut_6, BorderLayout.NORTH);
	    
	    //JPanel ImagenIconPanel =  new JPanel(new BorderLayout());
	    
	    Icon_ImagenPortada = new JLabel("");
	    panel_3.add(Icon_ImagenPortada, BorderLayout.CENTER);
	    Icon_ImagenPortada.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    Btn_Abrir = new JButton("Abrir");
	    Btn_Abrir.setActionCommand("Abrir");
	    Btn_Abrir.addActionListener(this);
	    panel_3.add(Btn_Abrir, BorderLayout.SOUTH);
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBackground(Constantes.Fondo);
	    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scrollPane.setViewportView(JPanel_Propiedades);
	    panel_2.add(scrollPane,BorderLayout.CENTER);
	    
	    
	    desktopPane = new JDesktopPane();
	    desktopPane.setBackground(Constantes.Fondo.brighter().brighter());
		splitPane.setRightComponent(desktopPane);
		desktopPane.setLayout(null);
		///Ficha de Indice Principal por defecto
		VentanaIndicePrincipal = AgregarFichaIndiceInformativo(Proyecto.getTitulo_Portada(), Proyecto.getImagenPortada(),"Indice Padre de la aplicacione", null);
		
		VentanasIndice.get(VentanaIndicePrincipal).setClosable(false);
		
		
		///////////////////////// Agregar indices
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
               
	}
	public void Agregar() throws IOException {
		if(VentanaIndiceEducativoEnfocada != null) {
			AgregarTipoDeFicha VentanaTipoDeFicha = new AgregarTipoDeFicha(VentanaIndiceEducativoEnfocada,this);//Se crea la ventana y se ejecuta el procedimiento
			}
		
		
		else {
			JOptionPane.showMessageDialog(this,"No hay Ventana Seleccionada");

		}

	}
	public void Eliminar() {
		if(VentanaIndiceEducativoEnfocada != null) {
			
			}

		else {
			JOptionPane.showMessageDialog(this,"No hay Ventana Seleccionada");
		}
	}
		
	
	public String AgregarFichaIndiceInformativo(String Titulo,Image Imagen, String Resumen,FichaIndiceInformativo Padre) {
		JInternalFrame_IndiceEducativo Indice = new JInternalFrame_IndiceEducativo((int)(Math.random()*200),(int)(Math.random()*200),getWidth()/4,getHeight()/4,Titulo,Imagen,Resumen,Padre);
		Indice.addInternalFrameListener(this);
		VentanasIndice.put(Indice.getIndiceInformativo().getID(),Indice);
		Proyecto.getFichasDeInformacion().put(Indice.getIndiceInformativo().getID(),Indice.getIndiceInformativo());
		desktopPane.add(VentanasIndice.get(Indice.getIndiceInformativo().getID()));
		return Indice.getIndiceInformativo().getID();
	}
	public  String AgregarFichaIndiceInformativo(FichaIndiceInformativo FichaAgregar) {
		JInternalFrame_IndiceEducativo Indice = new JInternalFrame_IndiceEducativo((int)(Math.random()*200),(int)(Math.random()*200),getWidth()/4,getHeight()/4,FichaAgregar);
		Indice.addInternalFrameListener(this);
		VentanasIndice.put(Indice.getIndiceInformativo().getID(),Indice);
		Proyecto.getFichasDeInformacion().put(Indice.getIndiceInformativo().getID(),Indice.getIndiceInformativo());
		desktopPane.add(VentanasIndice.get(Indice.getIndiceInformativo().getID()));
		return Indice.getIndiceInformativo().getID();
	}
	
	
	public void Abrir() {
		if(!TxtField_ID.getText().isEmpty()){
		FichaInformacion Ficha = Proyecto.getFichasDeInformacion().get(TxtField_ID.getText());	
			switch(Ficha.getTipoDeFicha()) {
		case Ficha_Indice:  
			boolean AbrirVentana = true;// asi evito que se reabran ventanas ya abiertas
				for(JInternalFrame JFrame: desktopPane.getAllFrames()) {
					JInternalFrame_IndiceEducativo CastingJFrame =  (JInternalFrame_IndiceEducativo)JFrame;
					if(CastingJFrame.getIndiceInformativo() == Ficha) { ///== porque estoy comparando el fichero no el objeto, asi evito  si hay repeticiones de objetos 
						AbrirVentana = false;}
					}
				if(AbrirVentana) {AgregarFichaIndiceInformativo((FichaIndiceInformativo)Ficha);}
				else{
					JOptionPane.showMessageDialog(this,"Esta ventana ya esta abierta");
				}
                  break;
		case Ficha_Informativa:
			JFrame_FichaEducativa jFrame_FichaEducativa = new JFrame_FichaEducativa((FichaInformativa_Basica)Ficha);
			break;
		case Ficha_LinealHorizontal: break;
		case Ficha_LinealVertical:  break;
			}
		}
		
		
		
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		switch(e.getActionCommand()) {
		case "Agregar": try {
				Agregar();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} break;
		case "Eliminar": Eliminar(); break;
		case "Abrir": Abrir(); break;
		
		
		}
	}
	
	
	@Override
	public void internalFrameActivated(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
	JInternalFrame_IndiceEducativo VentanaEnfocada =  (JInternalFrame_IndiceEducativo) arg0.getInternalFrame();
   VentanaIndiceEducativoEnfocada = VentanaEnfocada;
  
	}
	@Override
	public void internalFrameDeactivated(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		JInternalFrame_IndiceEducativo VentanaEnfocada =  (JInternalFrame_IndiceEducativo) arg0.getInternalFrame();
		FichaInformacion VentanaEnfocadaFicha = VentanaEnfocada.getIndiceInformativo();

	}
	
	
	@Override
	public void internalFrameClosed(InternalFrameEvent arg0) {
		desktopPane.remove((JInternalFrame_IndiceEducativo) arg0.getInternalFrame());
	}
	@Override
	public void internalFrameClosing(InternalFrameEvent arg0) {
		
	}
	
	@Override
	public void internalFrameDeiconified(InternalFrameEvent arg0) {
	}
	@Override
	public void internalFrameIconified(InternalFrameEvent arg0) {
	}
	@Override
	public void internalFrameOpened(InternalFrameEvent arg0) {
	}
	
	public static JTextField getTxtField_Padre() {
		return TxtField_Padre;
	}

	public static JTextField getTxtField_Titulo() {
		return TxtField_Titulo;
	}

	public static JTextField getTxtField_ID() {
		return TxtField_ID;
	}

	public static JTextField getTxtField_Tipo() {
		return TxtField_Tipo;
	}
	public static JTextPane getTxtPane_Resumen() {
		return TxtPane_Resumen;
	}

	public static JLabel getIcon_ImagenPortada() {
		return Icon_ImagenPortada;
	}
	public static JInternalFrame_IndiceEducativo getVentanaIndiceEducativoEnfocada() {
		return VentanaIndiceEducativoEnfocada;
	}
	public static ButtonGroup getMover_Seleccionar() {
		return Mover_Seleccionar;
	}
}
