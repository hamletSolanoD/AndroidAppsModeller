package Temario_Educativo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.nio.ByteOrder;
import java.nio.file.Path;
import java.nio.file.spi.FileTypeDetector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.w3c.dom.events.EventException;

import MySwingComponents.MyJPanel_ConFondo;
import MySwingComponents.MyJTextPane;
import Proyecto.Proyecto;
import ValoresDefault.Constantes;
import ValoresDefault.Constantes.Ilustracion;
import ValoresDefault.Constantes.Parrafo;

public class JFrame_FichaEducativa extends JFrame implements WindowListener, ActionListener{
	private JFrame_FichaInformativa_Editor JFrame_Editor;
	private JFrame_FichaInformativa_Indice JFrame_Indice;
	private JFrame_FichaInformativa_PreviewAndroid JFrame_Preview;
	
	private FichaInformativa_Basica Ficha = new FichaInformativa_Basica();
	
	public JFrame_FichaEducativa(FichaInformativa_Basica Ficha) {
/////////////////// Iniciar ventana
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(this);
		setBounds(0, 0,(Constantes.PantallaOrdenadorX/60)*Ficha.getTitulo().length(),Constantes.PantallaOrdenadorY/10);
		setLayout(new BorderLayout());
		setResizable(false);
		this.Ficha = Ficha;

/////////////////// Iniciar Valores
		
		
		JFrame_Editor = new JFrame_FichaInformativa_Editor();
		JFrame_Indice = new JFrame_FichaInformativa_Indice();
	    JFrame_Preview = new JFrame_FichaInformativa_PreviewAndroid();
	    
	    
	    JFrame_Indice.InicializarIndice(Ficha,this);
	    
	    
		JTextPane Titulo = new JTextPane();
		Titulo.setEditable(false);
		Titulo.setText(Ficha.getTitulo());
		Titulo.setFont(new Font("Dfdf",0,(Constantes.PantallaOrdenadorY/20)));
		Titulo.setForeground(Constantes.ColorTexto.brighter());
		Titulo.setBackground(Constantes.Fondo.brighter());
		getContentPane().add(Titulo,BorderLayout.CENTER);
		
		JFrame_Indice.AgregarImagen.addActionListener(this);
		JFrame_Indice.AgregarParrafo.addActionListener(this);
////////////////////Visible///////////////////
		setVisible(true);
	}
	
	
	private class JFrame_FichaInformativa_PreviewAndroid extends JFrame {
		private  JPanel Contenido;
		private int PosicionConstrains = 0;
		public JFrame_FichaInformativa_PreviewAndroid() {
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			setResizable(false);
			setBounds((Constantes.PantallaOrdenadorX/10)*7,Constantes.PantallaOrdenadorY/10,(Constantes.PantallaOrdenadorX/10)*3,(Constantes.PantallaOrdenadorY/10)*8);
			///Estblecer ventana
			
			///Portada
			JPanel PanelScrollable = new JPanel(new BorderLayout());
			PanelScrollable.add(Box.createHorizontalStrut(20),BorderLayout.EAST);

			
			JPanel Portada = new JPanel(new BorderLayout());
			MyJTextPane Titulo = new MyJTextPane(Ficha.getImagenPortada());
			Titulo.setPreferredSize(new Dimension(getWidth(),(getHeight()/8)*6));
			Titulo.setText(Ficha.getTitulo());
			Titulo.setEditable(false);
			
		
			Titulo.setFont(new Font("s",0,getWidth()/5));
			
			
			Titulo.setForeground(Color.BLACK);
			Portada.add(Titulo,BorderLayout.CENTER);
		  ////////////////////////// Contenido
		    Contenido = new JPanel(new GridBagLayout());
			PanelScrollable.add(Portada, BorderLayout.NORTH);
		    PanelScrollable.add(Contenido,BorderLayout.CENTER);
		  
		    
		    JScrollPane ScrollPanelPreview = new JScrollPane(PanelScrollable);
			ScrollPanelPreview.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			ScrollPanelPreview.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			getContentPane().add(ScrollPanelPreview);
			
			
	///////////////////////////////////////// 
			setVisible(true);
		}
		public final void AgregarParrafo(Parrafo parrafo) {			
			//CABEN 42 X EN EL WIDTH pero redondea a 50 para que mejor no se pierdan datos 
			////GridBagConstrain de Separador
			GridBagConstraints constrainSeparador = new GridBagConstraints();
			constrainSeparador.weightx = .5;
			constrainSeparador.weighty = .5;
			constrainSeparador.fill = GridBagConstraints.BOTH;
			constrainSeparador.gridwidth  = getWidth()-20; 
			constrainSeparador.gridheight = 1;
			constrainSeparador.gridy = PosicionConstrains;
			constrainSeparador.gridx = 0 ;
			PosicionConstrains += 1 + constrainSeparador.gridheight;
			///Crear un separador 
			Component Separador = Box.createVerticalStrut(20);
			////GridBagConstrain de JTextPane
			GridBagConstraints constrainJTextPane = new GridBagConstraints();
			constrainJTextPane.weightx = .5;
			constrainJTextPane.weighty = .5;
			constrainJTextPane.fill = GridBagConstraints.BOTH;
			constrainJTextPane.gridwidth = getWidth()-20;
			constrainJTextPane.gridheight = !(parrafo.getTexto().length() < 50)? (parrafo.getTexto().length()/(getWidth()/50)/*proporcion*/)*5 :  30;
			constrainJTextPane.gridy = PosicionConstrains;
			constrainJTextPane.gridx = 0 ;
			PosicionConstrains += 1 + constrainJTextPane.gridheight;
			///// Crear JTextPane
			JTextPane Parrafo = new JTextPane();
			Parrafo.setPreferredSize(new Dimension(constrainJTextPane.gridwidth,constrainJTextPane.gridheight));
			Parrafo.setFont(Constantes.textoNormal);
			Parrafo.setText(parrafo.getTexto());
		
			////Agregar Todo
			Contenido.add(Parrafo,constrainJTextPane);
			Contenido.add(Separador,constrainSeparador);
			Contenido.paintComponents(Contenido.getGraphics());
		}
		
		public void LimpiarFicha() {
			Contenido.removeAll();
		}
		public void AgregarIlustracion(Ilustracion ilustracion) {
			//CABEN 42 X EN EL WIDTH pero redondea a 50 para que mejor no se pierdan datos 
			
			////GridBagConstrain de Separador
			GridBagConstraints constrainSeparador = new GridBagConstraints();
			constrainSeparador.weightx = .5;
			constrainSeparador.weighty = .5;
			constrainSeparador.fill = GridBagConstraints.BOTH;
			constrainSeparador.gridwidth = getWidth()-20;;
			constrainSeparador.gridheight = 1;
			constrainSeparador.gridy = PosicionConstrains;
			constrainSeparador.gridx = 0 ;
			PosicionConstrains += 1 + constrainSeparador.gridheight;
			///Crear un separador 
			Component Separador = Box.createVerticalStrut(20);
			
			////GridBagConstrain de JTextPane
			GridBagConstraints constrainImagen = new GridBagConstraints();
			constrainImagen.weightx = .5;
			constrainImagen.weighty = .5;
			constrainImagen.fill = GridBagConstraints.BOTH;
			constrainImagen.gridwidth = getWidth()-20;
			constrainImagen.gridheight = constrainImagen.gridwidth;
			constrainImagen.gridy = PosicionConstrains;
			constrainImagen.gridx = 0 ;
			PosicionConstrains += 1 + constrainImagen.gridheight;
			///// Crear JTextPane
			JLabel Imagen = new JLabel( new ImageIcon(ilustracion.GetImage().getScaledInstance(getWidth()-20, getWidth()-20, Image.SCALE_SMOOTH)));
			
			////Agregar Todo
			Contenido.add(Imagen,constrainImagen);
			Contenido.add(Separador,constrainSeparador);
			Contenido.paintComponents(Contenido.getGraphics());
		}
		
	}
	
	
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		/// En caso que sea precionado un boton del indice en lo cual abrira la ventana del editor
		for(Parrafo Parrafo: Ficha.getTextos().values()) {
		if(Parrafo.GetID() == e.getActionCommand()) {
			JFrame_Editor.Abrir_Parrafo((JButton)e.getSource(),Parrafo);
		}
		}
		
		for(Ilustracion Ilustracion: Ficha.getImagenes().values() ) {
			if(Ilustracion.GetID() == e.getActionCommand()) {
				JFrame_Editor.Abrir_Ilustracion((JButton)e.getSource(),Ilustracion);

			 }
			}/// En caso que sea precionado un boton del indice en lo cual abrira la ventana del editor
		
		switch(e.getActionCommand()) {
		case "Agregar_Parrafo":
			System.out.println("AgregandoParrafo");
			Parrafo Parrafo = JFrame_Indice.AgregarParrafo(this);// el this es para definir el action listener
			 Ficha.getTextos().put(Parrafo.GetID(), Parrafo);// lo agrega asu indice pertinente en la ficha	 
			 Ficha.getIndiceDeComponentes().add(Parrafo.GetID());//Los guarda en orden
			 JFrame_Preview.AgregarParrafo(Parrafo);
			break;
		case "Agregar_Imagen":		
			System.out.println("AgregandoIndice");
			Ilustracion  Ilustracion = JFrame_Indice.AgregarIlustracion(this); 
			Ficha.getImagenes().put(Ilustracion.GetID(),Ilustracion);
			 Ficha.getIndiceDeComponentes().add(Ilustracion.GetID());//Los guarda en orden
			break;
		}
	}
		

	

	private static class JFrame_FichaInformativa_Indice extends JFrame {
		private HashMap<String, JButton> JButtonIndice = new HashMap<String, JButton>();
		private   JScrollPane Contenido;
		private   JPanel IndiceComponentes;
		protected JButton AgregarParrafo;
		protected JButton AgregarImagen;
	
		public JFrame_FichaInformativa_Indice() {
		////Estblecer ventana

			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			setResizable(false);
			setBounds(0,Constantes.PantallaOrdenadorY/10,(Constantes.PantallaOrdenadorX/10)*2,(Constantes.PantallaOrdenadorY/10)*8);
			getContentPane().setBackground(Constantes.Fondo);
			setLayout(new BorderLayout());
////////////////////////////////////////////////////////////////////////////////////
			
			// north
		    JPanel North = new JPanel(new BorderLayout());
		    getContentPane().add(North,BorderLayout.NORTH);
		    North.setBackground(Constantes.Fondo);
		    North.add(Box.createHorizontalStrut(50),BorderLayout.EAST);
		    North.add(Box.createHorizontalStrut(50),BorderLayout.WEST);

		    
			JLabel JLabel_Titulo = new JLabel("Indice");
			JLabel_Titulo.setFont(Constantes.Titulos);
			JLabel_Titulo.setBackground(Constantes.Fondo);
			JLabel_Titulo.setForeground(Constantes.ColorTexto);
			JLabel_Titulo.setHorizontalAlignment(SwingConstants.CENTER);
			North.add(JLabel_Titulo,BorderLayout.CENTER);
			
			JPanel Herramientas  =  new JPanel(new GridLayout(1,3,0,0));
			Herramientas.setBackground(Constantes.Fondo);
			North.add(Herramientas, BorderLayout.SOUTH);
			
		    AgregarParrafo = new JButton("P+");
			AgregarParrafo.setForeground(Constantes.ColorTexto);
			AgregarParrafo.setActionCommand("Agregar_Parrafo");
			Herramientas.add(AgregarParrafo);
			
			Component HorizontalSeparation = Box.createHorizontalStrut(50);
			Herramientas.add(HorizontalSeparation);
			
		    AgregarImagen = new JButton("I+");
			AgregarImagen.setForeground(Constantes.ColorTexto);
			AgregarImagen.setActionCommand("Agregar_Imagen");
			Herramientas.add(AgregarImagen);
			
			
		//////////// Centro
		    IndiceComponentes = new JPanel(new GridLayout(0,1,0,0));
			IndiceComponentes.setBackground(Constantes.Fondo);
			
		    Contenido = new JScrollPane();
			Contenido.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			Contenido.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			Contenido.setViewportView(IndiceComponentes);
			getContentPane().add(Contenido,BorderLayout.CENTER);
			
			
			
	///////////////////////////////////////// 
			setVisible(true);
		}
		public void InicializarIndice(FichaInformativa_Basica Ficha,ActionListener ActionListener) {
			for (String ID : Ficha.getIndiceDeComponentes()) {
				if(Ficha.getImagenes().containsKey(ID)) {
					JButton JButtonImagen  =  new JButton(new ImageIcon(Ficha.getImagenes().get(ID).GetImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
					JButtonImagen.setFont(Constantes.botones);
					JButtonImagen.setForeground(Constantes.ColorTexto);
					JButtonImagen.setBackground(Constantes.Fondo);
					JButtonImagen.addActionListener(ActionListener);
					JButtonImagen.setActionCommand(ID);
					JButtonIndice.put(JButtonImagen.getActionCommand(), JButtonImagen);
					IndiceComponentes.add(JButtonImagen);
					paintComponents(getGraphics());
				}
			if(Ficha.getTextos().containsKey(ID)) {
				
				JButton JButtonParrafo  =  new JButton("...");
				JButtonParrafo.setFont(Constantes.botones);
				JButtonParrafo.setForeground(Constantes.ColorTexto);
				JButtonParrafo.setBackground(Constantes.Fondo);
				try {
					JButtonParrafo.setText(Ficha.getTextos().get(ID).getTexto().substring(0,((Ficha.getTextos().get(ID).getTexto().length() >= 20?  20:((Ficha.getTextos().get(ID).getTexto().length())))))+"...");

				}
				catch(IndexOutOfBoundsException i) {
					
					}
				
				JButtonParrafo.addActionListener(ActionListener);
				JButtonParrafo.setActionCommand(ID);
				
				JButtonIndice.put(JButtonParrafo.getActionCommand(), JButtonParrafo);
				IndiceComponentes.add(JButtonParrafo);
				paintComponents(getGraphics());	
			}
			}
		
		
			
			
			
		}

	protected Parrafo AgregarParrafo(ActionListener ActionListener) {/// Crea el nuevo Parrafo
		Parrafo NuevoParrafo = new Parrafo();
		JButton JButtonParrafo  =  new JButton(NuevoParrafo.getTexto());
		JButtonParrafo.setFont(Constantes.botones);
		JButtonParrafo.setForeground(Constantes.ColorTexto);
		JButtonParrafo.setBackground(Constantes.Fondo);
		JButtonParrafo.addActionListener(ActionListener);
		JButtonParrafo.setActionCommand(NuevoParrafo.GetID());
		
		JButtonIndice.put(JButtonParrafo.getActionCommand(), JButtonParrafo);
		IndiceComponentes.add(JButtonParrafo);

		
		paintComponents(getGraphics());
		
	   return NuevoParrafo ;
	}
	protected Ilustracion AgregarIlustracion(ActionListener ActionListener) {//Creal la nueva Imagen
		Ilustracion NuevaIlustracion =  new Ilustracion();
		JButton JButtonImagen  =  new JButton(new ImageIcon(NuevaIlustracion.GetImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		JButtonImagen.setBackground(Constantes.Fondo);
		JButtonImagen.addActionListener(ActionListener);
		JButtonImagen.setActionCommand(NuevaIlustracion.GetID());
		JButtonIndice.put(JButtonImagen.getActionCommand(), JButtonImagen);
		IndiceComponentes.add(JButtonImagen);
		paintComponents(getGraphics());
	return NuevaIlustracion;
		
	}
	
	
	}

	
	private class JFrame_FichaInformativa_Editor extends JFrame implements ActionListener, DocumentListener {
		private JPanel PanelTexto;
		private MyJPanel_ConFondo PanelImagen;
		private JTextPane Texto;
		private JButton CargarImagen;
		private JTextPane Inicio;
		
		private Ilustracion CourrentIlustracion;
		private Parrafo CourrentParrafo;
		
		private JButton CourrenButtonParrafo = new JButton();
		private JButton CourrenButtonIlustracion = new JButton();

		public JFrame_FichaInformativa_Editor() {
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			setResizable(false);
			setBounds((Constantes.PantallaOrdenadorX/20)*5,Constantes.PantallaOrdenadorY/10,(Constantes.PantallaOrdenadorX/10)*4,(Constantes.PantallaOrdenadorY/10)*8);
			getContentPane().setLayout(new BorderLayout());
			getContentPane().setBackground(Constantes.Fondo.darker());
		    Inicio = new JTextPane();
			Inicio.setText("Selecciona o crea un parrafo o una ilutracion");
			Inicio.setFont(Constantes.Titulos);
			Inicio.setBackground(Constantes.Fondo);
			Inicio.setForeground(Constantes.ColorTexto);
			getContentPane().add(Inicio,BorderLayout.CENTER);
			////Estblecer ventana
			
			
			////PanelDeTexto		
		    PanelTexto = new JPanel(new BorderLayout());
		    PanelTexto.setBackground(Constantes.Fondo);	
		    
			Texto = new JTextPane();
			Texto.setForeground(Constantes.ColorTexto.darker());
			Texto.setBackground(Constantes.Fondo.darker());
			Texto.setFont(Constantes.textoNormal);
			Texto.getDocument().addDocumentListener(this);
			PanelTexto.add(Texto, BorderLayout.CENTER);
			PanelTexto.setVisible(true);
			
			///Panel de Imagen
		    PanelImagen = new MyJPanel_ConFondo(new BorderLayout());
			CargarImagen = new JButton("Cargar Imagen");
			CargarImagen.addActionListener(this);
			CargarImagen.setActionCommand("CargarImagen");
			CargarImagen.setBackground(Constantes.Fondo);
			CargarImagen.setForeground(Constantes.ColorTexto.darker());
			PanelImagen.add(CargarImagen, BorderLayout.SOUTH);
			PanelImagen.setVisible(true);

			
			
	///////////////////////////////////////// 
			setVisible(true);
		}
		public void Abrir_Ilustracion(JButton BotonIndiceIlustracion,Ilustracion imagen) {
			CourrentIlustracion = imagen;
			CourrenButtonIlustracion = BotonIndiceIlustracion;
			PanelImagen.CambiarImagen(imagen.GetImage());
			getContentPane().remove(PanelTexto);
			getContentPane().remove(Inicio);
			getContentPane().add(PanelImagen,BorderLayout.CENTER);
			paintComponents(this.getGraphics());
			
		}
		public void Abrir_Parrafo(JButton BotonIndiceParrafo,Parrafo Parrafo) {
			CourrentParrafo = Parrafo;
			CourrenButtonParrafo = BotonIndiceParrafo;
			try {
			Texto.setText(Parrafo.getTexto());
			}
			catch(IndexOutOfBoundsException i) {
				Texto.setText(null);
				}

			
			getContentPane().remove(PanelImagen);
			getContentPane().remove(Inicio);
			getContentPane().add(PanelTexto,BorderLayout.CENTER);
			paintComponents(this.getGraphics());
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			switch(e.getActionCommand()) {
			case "CargarImagen":
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
					 Image Imagen = new ImageIcon(jFileChooser.getSelectedFile().getAbsolutePath()).getImage();
					 CourrentIlustracion.SetImage(Imagen);
					 PanelImagen.CambiarImagen(Imagen);
					 CourrenButtonIlustracion.setIcon(new ImageIcon(Imagen.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
					///Cargar previsualizacion
						JFrame_Preview.LimpiarFicha();
						for(String ID : Ficha.getIndiceDeComponentes()) {
							if(Ficha.getTextos().containsKey(ID)) {
							JFrame_Preview.AgregarParrafo(Ficha.getTextos().get(ID));
							}
							else if(Ficha.getImagenes().containsKey(ID)) {
								JFrame_Preview.AgregarIlustracion(Ficha.getImagenes().get(ID));

							}
							
						}
						///Cargar previsualizacion
					 
				}
					
					else {
						JOptionPane.showMessageDialog(this, "Tipo de archivo incorrecto");
					}
				   }
				    catch (Exception ignorado) {
						JOptionPane.showMessageDialog(this, "Error al cargar el archivo");
					}
		}else {
			JOptionPane.showMessageDialog(this, "Error al cargar el archivo");	}
			
 break;
			
			}
		}
		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			try {
				CourrentParrafo.SetTexto(Texto.getText());
				CourrenButtonParrafo.setText(CourrentParrafo.getTexto().substring(0,(CourrentParrafo.getTexto().length() >= 20?  20:(CourrentParrafo.getTexto().length())))+"...");
				JFrame_Preview.LimpiarFicha();
				///Cargar previsualizacion
				JFrame_Preview.LimpiarFicha();
				for(String ID : Ficha.getIndiceDeComponentes()) {
					if(Ficha.getTextos().containsKey(ID)) {
					JFrame_Preview.AgregarParrafo(Ficha.getTextos().get(ID));
					}
					else if(Ficha.getImagenes().containsKey(ID)) {
						JFrame_Preview.AgregarIlustracion(Ficha.getImagenes().get(ID));

					}
					
				}
				///Cargar previsualizacion
			}
		catch(IndexOutOfBoundsException i) {
	
			}
		}
		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			try{
				CourrentParrafo.SetTexto(Texto.getText());
				CourrenButtonParrafo.setText(CourrentParrafo.getTexto().substring(0,(CourrentParrafo.getTexto().length() >= 20?  20:(CourrentParrafo.getTexto().length())))+"...");
				///Cargar previsualizacion
				JFrame_Preview.LimpiarFicha();
				for(String ID : Ficha.getIndiceDeComponentes()) {
					if(Ficha.getTextos().containsKey(ID)) {
					JFrame_Preview.AgregarParrafo(Ficha.getTextos().get(ID));
					}
					else if(Ficha.getImagenes().containsKey(ID)) {
						JFrame_Preview.AgregarIlustracion(Ficha.getImagenes().get(ID));

					}
					
				}
				///Cargar previsualizacion
			}
		catch(IndexOutOfBoundsException i) {
	
			}

		}
		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			try {
			CourrentParrafo.SetTexto(Texto.getText());
			CourrenButtonParrafo.setText(CourrentParrafo.getTexto().substring(0,(CourrentParrafo.getTexto().length() >= 20?  20:(CourrentParrafo.getTexto().length())))+"...");
			///Cargar previsualizacion
			JFrame_Preview.LimpiarFicha();
			for(String ID : Ficha.getIndiceDeComponentes()) {
				if(Ficha.getTextos().containsKey(ID)) {
				JFrame_Preview.AgregarParrafo(Ficha.getTextos().get(ID));
				}
				else if(Ficha.getImagenes().containsKey(ID)) {
					JFrame_Preview.AgregarIlustracion(Ficha.getImagenes().get(ID));

				}
				
			}
			///Cargar previsualizacion
			}
		catch(IndexOutOfBoundsException i) {
			
			}

		}
	}
	

	
	
	
	
	@Override
	public void windowActivated(WindowEvent e) {	
		System.out.println("activado");
		JFrame_Indice.toFront();
		JFrame_Editor.toFront();
		JFrame_Preview.toFront();
	}
	@Override
	public void windowClosed(WindowEvent e) {

	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Cerrando");
		JFrame_Indice.dispose();
		JFrame_Editor.dispose();
		JFrame_Preview.dispose();
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Desiconificado");
		JFrame_Indice.setState(JFrame.NORMAL);
		JFrame_Editor.setState(JFrame.NORMAL);
		JFrame_Preview.setState(JFrame.NORMAL);

	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		JFrame_Indice.setState(ICONIFIED);
		JFrame_Editor.setState(ICONIFIED);
		JFrame_Preview.setState(ICONIFIED);
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
	}
	


}
