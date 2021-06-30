package Temario_Educativo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ValoresDefault.Constantes;
import ValoresDefault.Constantes.TipoFicha;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.spi.FileTypeDetector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class AgregarTipoDeFicha_Caracteristicas extends JFrame implements ActionListener{
	private JInternalFrame_IndiceEducativo Padre;
	private Temario_Educativo_MainScenesManager VentanaPrincipalTemario;
	
	private JTextField TextField_Titulo;
	private TipoFicha TipoDeFicha;
	private FichaInformacion Ficha;
	
	private JLabel JLabel_Padre;
	private JLabel JLabel_Tipo;
	private JLabel Imagen;
	
	private String Titulo;
	private String Descripcion;
	private Image Foto;
	
	public AgregarTipoDeFicha_Caracteristicas(JInternalFrame_IndiceEducativo Padre, TipoFicha TipoDeFicha,Temario_Educativo_MainScenesManager VentanaPrincipalTemario ) {
		this.VentanaPrincipalTemario = VentanaPrincipalTemario;
		this.Padre = Padre;
		this.TipoDeFicha = TipoDeFicha;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Constantes.PantallaOrdenadorX/5,Constantes.PantallaOrdenadorY/5,(Constantes.PantallaOrdenadorX/10)*6,(Constantes.PantallaOrdenadorY/10)*6);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel JPanel_Contenido = new JPanel();
		getContentPane().add(JPanel_Contenido);
		JPanel_Contenido.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel JPanelCaracteristicas = new JPanel();
		JPanelCaracteristicas.setBackground(Constantes.Fondo);
		JPanel_Contenido.add(JPanelCaracteristicas);
		JPanelCaracteristicas.setLayout(new GridLayout(12, 0, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Titulo:");
		lblNewLabel_1.setForeground(Constantes.ColorTexto);
		JPanelCaracteristicas.add(lblNewLabel_1);
		
		TextField_Titulo = new JTextField();
		TextField_Titulo.setBackground(Constantes.Fondo.brighter());
		TextField_Titulo.setForeground(Constantes.Fondo.darker());
		TextField_Titulo.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				Titulo = TextField_Titulo.getText();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				Titulo = TextField_Titulo.getText();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				Titulo = TextField_Titulo.getText();
			}
		});
		JPanelCaracteristicas.add(TextField_Titulo);
		TextField_Titulo.setColumns(10);
		
		Component verticalStrut_6 = Box.createVerticalStrut(20);
		JPanelCaracteristicas.add(verticalStrut_6);
		
		JLabel lblNewLabel_2 = new JLabel("Resumen:");
		lblNewLabel_2.setForeground(Constantes.ColorTexto);
		JPanelCaracteristicas.add(lblNewLabel_2);
		
		JTextPane TextPanel_Resumen = new JTextPane();
		TextPanel_Resumen.setBackground(Constantes.Fondo.brighter());
		TextPanel_Resumen.setForeground(Constantes.Fondo.darker());

		TextPanel_Resumen.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				Descripcion = TextPanel_Resumen.getText();
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				Descripcion = TextPanel_Resumen.getText();

			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				Descripcion = TextPanel_Resumen.getText();

			}
		});
		JPanelCaracteristicas.add(TextPanel_Resumen);
		
		Component verticalStrut_7 = Box.createVerticalStrut(20);
		JPanelCaracteristicas.add(verticalStrut_7);
	    
	    JLabel lblNewLabel_3 = new JLabel("Indice padre:");
	    lblNewLabel_3.setForeground(Constantes.ColorTexto);
	    JPanelCaracteristicas.add(lblNewLabel_3);
		
	    JLabel_Padre = new JLabel("New label");
	    JLabel_Padre.setBackground(Constantes.Fondo.brighter());
	    JLabel_Padre.setForeground(Constantes.Fondo.darker());

	    JLabel_Padre.setText(Padre.getIndiceInformativo().getTitulo());
		JPanelCaracteristicas.add(JLabel_Padre);
		
		Component verticalStrut_8 = Box.createVerticalStrut(20);
		JPanelCaracteristicas.add(verticalStrut_8);
	    
	    JLabel lblNewLabel_4 = new JLabel("Tipo de ficha:");
	    lblNewLabel_4.setForeground(Constantes.ColorTexto);
	    JPanelCaracteristicas.add(lblNewLabel_4);
		
	    JLabel_Tipo = new JLabel("New label");
	    JLabel_Tipo.setBackground(Constantes.Fondo.brighter());
	    JLabel_Tipo.setForeground(Constantes.Fondo.darker());
	    JLabel_Tipo.setText(TipoDeFicha.GetTipo_Ficha());
		JPanelCaracteristicas.add(JLabel_Tipo);
		
		Component verticalStrut_9 = Box.createVerticalStrut(20);
		JPanelCaracteristicas.add(verticalStrut_9);
		
		JPanel JPanelImagen = new JPanel();
		JPanelImagen.setBackground(Constantes.Fondo);
		JPanel_Contenido.add(JPanelImagen);
		JPanelImagen.setLayout(new BorderLayout(0, 0));
		
		JPanel JPanel_CargarFoto = new JPanel();
		JPanel_CargarFoto.setBackground(Constantes.Fondo);
		JPanelImagen.add(JPanel_CargarFoto, BorderLayout.SOUTH);
		JPanel_CargarFoto.setLayout(new BorderLayout(0, 0));
		
		JButton JButton_CargarFoto = new JButton("Cargar Foto");
		JButton_CargarFoto.setActionCommand("Cargar Foto");
		JButton_CargarFoto.addActionListener(this);
		JPanel_CargarFoto.add(JButton_CargarFoto, BorderLayout.CENTER);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		JPanel_CargarFoto.add(verticalStrut, BorderLayout.NORTH);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		JPanel_CargarFoto.add(horizontalStrut_2, BorderLayout.WEST);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		JPanel_CargarFoto.add(verticalStrut_2, BorderLayout.SOUTH);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		JPanel_CargarFoto.add(horizontalStrut_3, BorderLayout.EAST);
		
	    Imagen = new JLabel("");
		JPanelImagen.add(Imagen, BorderLayout.CENTER);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		JPanelImagen.add(horizontalStrut_1, BorderLayout.EAST);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		JPanelImagen.add(verticalStrut_1, BorderLayout.NORTH);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		JPanelImagen.add(horizontalStrut, BorderLayout.WEST);
		
		JPanel JPanel_Titulo = new JPanel();
		JPanel_Titulo.setBackground(Constantes.Fondo);
		getContentPane().add(JPanel_Titulo, BorderLayout.NORTH);
		JPanel_Titulo.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Tipo De Ficha");
		lblNewLabel.setForeground(Constantes.ColorTexto);
		lblNewLabel.setFont(Constantes.Titulos);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		JPanel_Titulo.add(lblNewLabel, BorderLayout.CENTER);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		JPanel_Titulo.add(verticalStrut_3, BorderLayout.NORTH);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		JPanel_Titulo.add(verticalStrut_4, BorderLayout.SOUTH);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		JPanel_Titulo.add(horizontalStrut_4, BorderLayout.WEST);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		JPanel_Titulo.add(horizontalStrut_5, BorderLayout.EAST);
		
		JPanel JPanel_Hecho = new JPanel();
		JPanel_Hecho.setBackground(Constantes.Fondo);
		getContentPane().add(JPanel_Hecho, BorderLayout.SOUTH);
		JPanel_Hecho.setLayout(new BorderLayout(0, 0));
		
		JButton JButton_Hecho = new JButton("Hecho");
		JButton_Hecho.addActionListener(this);
		JPanel_Hecho.add(JButton_Hecho, BorderLayout.CENTER);
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		JPanel_Hecho.add(verticalStrut_5, BorderLayout.SOUTH);
		
		Component horizontalStrut_2_1 = Box.createHorizontalStrut(20);
		JPanel_Hecho.add(horizontalStrut_2_1, BorderLayout.WEST);
		
		Component verticalStrut_2_1 = Box.createVerticalStrut(20);
		JPanel_Hecho.add(verticalStrut_2_1, BorderLayout.NORTH);
		
		Component horizontalStrut_3_1 = Box.createHorizontalStrut(20);
		JPanel_Hecho.add(horizontalStrut_3_1, BorderLayout.EAST);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	private void CargarFoto() {
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
			
		     Image ImagenReescalada = new ImageIcon(jFileChooser.getSelectedFile().getAbsolutePath()).getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_SMOOTH);
			 Foto = ImagenReescalada;
		     ImageIcon Icono = new ImageIcon(ImagenReescalada);
			 Imagen.setIcon(Icono);
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

	private void Hecho() {
		if(Foto != null && !Titulo.isEmpty() && !Descripcion.isEmpty()) {
			JOptionPane.showMessageDialog(this,"Ficha "+ Titulo+ " Creada");
			switch(TipoDeFicha) {
			case Ficha_Indice:
				Ficha = new FichaIndiceInformativo(Titulo, Padre.getIndiceInformativo(), Descripcion, Foto);  // se define la ficha a crear
				VentanaPrincipalTemario.AgregarFichaIndiceInformativo((FichaIndiceInformativo) Ficha); // se agrega su ventana a la ventana principal
				break;
			case Ficha_Informativa: 
				Ficha =  new FichaInformativa_Basica(Titulo, Padre.getIndiceInformativo(), Descripcion, Foto); 
				break;
			case Ficha_LinealHorizontal: break;
			case Ficha_LinealVertical: break;
			}
			Padre.AgregarFicha(Ficha);
			dispose();
		}
		else {
			JOptionPane.showMessageDialog(this,"Formulario Incompleto");
		}
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()) {
		case "Cargar Foto": CargarFoto();  break;
		case "Hecho": Hecho(); break;
		}
	}

	public JInternalFrame_IndiceEducativo getPadre() {
		return Padre;
	}

	public TipoFicha getTipoDeFicha() {
		return TipoDeFicha;
	}

	public JLabel getImagen() {
		return Imagen;
	}

	public String getTitulo() {
		return Titulo;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public Image getFoto() {
		return Foto;
	}

	public FichaInformacion getFicha() {
		return Ficha;
	}

}
