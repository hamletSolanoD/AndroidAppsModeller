package Temario_Educativo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.image.ImagingOpException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.xml.soap.Text;

import org.w3c.dom.events.EventException;

import MySwingComponents.MyJButton_ConFondo;
import MySwingComponents.MyJPanel_ConFondo;
import Proyecto.Proyecto;
import ValoresDefault.Constantes;
import ValoresDefault.Constantes.Ilustracion;
import ValoresDefault.Constantes.Parrafo;
import ValoresDefault.Constantes.TipoFicha;
import java.awt.FlowLayout;
import java.awt.Font;

public class JInternalFrame_IndiceEducativo extends JInternalFrame implements ActionListener, MouseMotionListener, FocusListener{
////// visual
   public MyJPanel_ConFondo panel;
   private Image imagen;
   private final int GrosorLinea = 13;
   
   /// logico
   private MyJButton_ConFondo FichaEnfocada;
   private HashMap<String, MyJButton_ConFondo> JButtonsInformacion = new HashMap<String, MyJButton_ConFondo>();// Es el array general, el que ya combina las fichas y sus objetos de programacion
   private FichaIndiceInformativo IndiceInformativo = new FichaIndiceInformativo();
   public static int BoundsFichas = 100;
  
   
   public JInternalFrame_IndiceEducativo(int x, int y, int width, int height,String Title, Image Imagen, String Resumen, FichaIndiceInformativo IndicePadre) {
	 
	   ////Parte Visual
	     addMouseMotionListener(this);
		 setBounds(x,y,width,height);
		 setTitle(Title);
		 addComponentListener(new ComponentAdapter() {
			    @Override
			    public void componentResized(final ComponentEvent e) {
			     paintComponents(getGraphics());
			    }
			});
		 imagen= Imagen;
		 panel = new MyJPanel_ConFondo(imagen, width, height);
		  panel.setLayout(null);
		 setIconifiable(true);
		 setClosable(true);
	     setMaximizable(true);
		 setResizable(true);
		 /// Visual - Logica
		 ///Parte Logica
		 
		 IndiceInformativo = new FichaIndiceInformativo(Title,IndicePadre,Resumen, Imagen);// esta ficha
		 InicializarFichas();/// Inicializa todas la ventanas junto con la ventana principal 
		 
		///////////////   
		 getContentPane().add(panel);
		 setVisible(true);
	}
   public JInternalFrame_IndiceEducativo(int x, int y, int width, int height,FichaIndiceInformativo FichaIndiceInformativo) {
	   ////Parte Visual
	     addMouseMotionListener(this);
		 setBounds(x,y,width,height);
		 setTitle(FichaIndiceInformativo.getTitulo());
		 imagen= FichaIndiceInformativo.getImagenPortada();
		 panel = new MyJPanel_ConFondo(imagen, width, height);
		 panel.setLayout(null);
		 setIconifiable(true);
		 addComponentListener(new ComponentAdapter() {
			    @Override
			    public void componentResized(final ComponentEvent e) {
			    paintComponents(getGraphics());
			    }
			});
		 setClosable(true);
	     setMaximizable(true);
		 setResizable(true);
		 /// Visual - Logica
		 
		 ///Parte Logica
		IndiceInformativo = FichaIndiceInformativo;
		InicializarFichas();/// Inicializa todas la ventanas junto con la ventana principal 
		///////////////   
		 getContentPane().add(panel);
		 setVisible(true);
	}



    public void AgregarFicha(TipoFicha TipoDeFicha, String Titulo, Image ImagenPortada , String Resumen, FichaIndiceInformativo IndicePadre) {
    	FichaInformacion Agregar = null;
    	/////////////////////////////////////////////////////////////////
    	MyJButton_ConFondo BotonAgregar = new MyJButton_ConFondo();
    	BotonAgregar.setText(Titulo);
    	BotonAgregar.setBounds((int)(Math.random()*200),(int)(Math.random()*200),BoundsFichas,BoundsFichas);
    	BotonAgregar.setIcon(new ImageIcon(ImagenPortada.getScaledInstance(BoundsFichas, BoundsFichas, Image.SCALE_SMOOTH)));
    	BotonAgregar.setFont(new Font("dsdds",Font.BOLD,BoundsFichas/BotonAgregar.getText().length()));
    	BotonAgregar.setHorizontalTextPosition(SwingConstants.CENTER );
    	BotonAgregar.setVerticalTextPosition(SwingConstants.CENTER );
    	switch(TipoDeFicha){
    	case Ficha_Indice: 
    		Agregar = new FichaIndiceInformativo(Titulo, IndicePadre, Resumen, ImagenPortada);
    		BotonAgregar.CambiarFondo(Proyecto.getColorPrimario());
    	break;
    	case Ficha_Informativa: 
    		Agregar = new FichaInformativa_Basica(Titulo, IndicePadre, Resumen, ImagenPortada);
    		BotonAgregar.CambiarFondo(Proyecto.getColorTerciario());
    	break;
    	case Ficha_LinealHorizontal: 
    		BotonAgregar.CambiarFondo(Proyecto.getColorSecundario());
    		break;
    	case Ficha_LinealVertical:
    		BotonAgregar.CambiarFondo(Proyecto.getColorSecundario());
    		break;
    	}
        System.out.print(Agregar.getID());
        
        
        IndiceInformativo.getFichasDeInformacion().put(Agregar.getID(), Agregar);
    	JButtonsInformacion.put(Agregar.getID(),  BotonAgregar);
    	Proyecto.getFichasDeInformacion().put(Agregar.getID(), Agregar);
        BotonAgregar.setActionCommand(""+Agregar.getID());
    	BotonAgregar.addActionListener(this);
    	BotonAgregar.addFocusListener(this);
    	panel.add(BotonAgregar);
    	paintComponents(getGraphics());
    	}
    
    
    public void AgregarFicha(FichaInformacion Ficha) {
    	FichaInformacion Agregar = Ficha;
    	/////////////////////////////////////////////////////////////////
    	MyJButton_ConFondo BotonAgregar = new MyJButton_ConFondo();
    	BotonAgregar.setText(Ficha.getTitulo());
    	BotonAgregar.setBounds((int)(Math.random()*200),(int)(Math.random()*200),BoundsFichas,BoundsFichas);
    	BotonAgregar.setIcon(new ImageIcon(Ficha.getImagenPortada().getScaledInstance(BoundsFichas, BoundsFichas, Image.SCALE_SMOOTH)));
    	BotonAgregar.setFont(new Font("dsdds",Font.BOLD,BoundsFichas/BotonAgregar.getText().length()));
    	BotonAgregar.setHorizontalTextPosition(SwingConstants.CENTER );
    	BotonAgregar.setVerticalTextPosition(SwingConstants.CENTER );
    	
    	switch(Ficha.getTipoDeFicha()){///Solo para agregar el color
    	case Ficha_Indice: 
    		BotonAgregar.CambiarFondo(Proyecto.getColorPrimario());
    	break;
    	case Ficha_Informativa: 
    		BotonAgregar.CambiarFondo(Proyecto.getColorTerciario());
    	break;
    	case Ficha_LinealHorizontal: 
    		BotonAgregar.CambiarFondo(Proyecto.getColorSecundario());
    		break;
    	case Ficha_LinealVertical:
    		BotonAgregar.CambiarFondo(Proyecto.getColorSecundario());
    		break;
    	}
        IndiceInformativo.getFichasDeInformacion().put(Agregar.getID(), Agregar);
    	JButtonsInformacion.put(Agregar.getID(),  BotonAgregar);
    	Proyecto.getFichasDeInformacion().put(Agregar.getID(), Agregar);
        BotonAgregar.setActionCommand(""+Agregar.getID());
    	BotonAgregar.addActionListener(this);
    	BotonAgregar.addFocusListener(this);
    	panel.add(BotonAgregar);
    	paintComponents(getGraphics());
    	}
    	


 private void InicializarFichas() {
	for(FichaInformacion i: IndiceInformativo.getFichasDeInformacion().values()) {
		AgregarFicha(i);
	}
	 
 }
 
 public void EliminarFicha() {
	 if(FichaEnfocada != JButtonsInformacion.get(IndiceInformativo.getID())) {
	 IndiceInformativo.getFichasDeInformacion().remove(FichaEnfocada.getActionCommand());
	 JButtonsInformacion.remove(FichaEnfocada.getActionCommand());
	 Proyecto.getFichasDeInformacion().remove(FichaEnfocada.getActionCommand());
	 panel.remove(FichaEnfocada);
	 FichaEnfocada = null;
	 }
	 
 }
@Override
public void actionPerformed(ActionEvent e) {
	FichaInformacion Ficha;
	if(Temario_Educativo_MainScenesManager.getMover_Seleccionar().getSelection().getActionCommand().equals("seleccionar")) {
	for(FichaInformacion i : IndiceInformativo.getFichasDeInformacion().values()) {
		if((""+i.getID()).equals(e.getActionCommand())) {
			Ficha = i;
			Temario_Educativo_MainScenesManager.getIcon_ImagenPortada().setIcon((new ImageIcon(Ficha.getImagenPortada().getScaledInstance(Temario_Educativo_MainScenesManager.getIcon_ImagenPortada().getWidth(), Temario_Educativo_MainScenesManager.getIcon_ImagenPortada().getHeight(), Image.SCALE_SMOOTH))));
			Temario_Educativo_MainScenesManager.getTxtField_ID().setText(""+Ficha.getID());
			if(!(Ficha.getIndicePadre() == null)) {Temario_Educativo_MainScenesManager.getTxtField_Padre().setText(Ficha.getIndicePadre().getTitulo());}
			else {Temario_Educativo_MainScenesManager.getTxtField_Padre().setText("No tiene padre (indice principal)");}
			Temario_Educativo_MainScenesManager.getTxtField_Tipo().setText(Ficha.getTipoDeFicha().GetTipo_Ficha());
			Temario_Educativo_MainScenesManager.getTxtField_Titulo().setText(Ficha.getTitulo());
			Temario_Educativo_MainScenesManager.getTxtPane_Resumen().setText(Ficha.getResumen());
		}
	}
	}


	
	
}

public HashMap<String, FichaInformacion> getFichasInformacion() {
	return IndiceInformativo.getFichasDeInformacion();
}

public HashMap<String, MyJButton_ConFondo> getJButtonsInformacion() {
	return JButtonsInformacion;
}


public FichaIndiceInformativo getIndiceInformativo() {
	return IndiceInformativo;
}
@Override
public void focusGained(FocusEvent arg0) {
	// TODO Auto-generated method stub
	if(arg0.getSource().getClass().equals(MyJButton_ConFondo.class)){
		FichaEnfocada = (MyJButton_ConFondo)arg0.getComponent();
}
}
@Override
public void focusLost(FocusEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseDragged(MouseEvent e) {
	// TODO Auto-generated method stub
	//MOVER FICHA
	if(Temario_Educativo_MainScenesManager.getMover_Seleccionar().getSelection().getActionCommand().equals("mover")) {
	FichaEnfocada.setLocation(e.getX()-FichaEnfocada.getWidth()/2, e.getY()-FichaEnfocada.getHeight()/2);				
	//panel.paintComponents(panel.getGraphics());
	paintComponents(getGraphics());
	}
}
@Override
public void mouseMoved(MouseEvent arg0) {
	// TODO Auto-generated method stub
}
public void paintComponents(Graphics g) {
	super.paintComponents(g);
	for(Component D : panel.getComponents()) {
		if(D.getClass().equals(MyJButton_ConFondo.class)) {
			CalcularTrazo(JButtonsInformacion.get(this.IndiceInformativo.getID()), D);
		}
	}	
}

private void CalcularTrazo(Component Origen, Component Destino) {
    float Q = Origen.getX()+Origen.getWidth()/2, K = Origen.getY()+Origen.getHeight(),
    		X = Destino.getX()+Destino.getWidth()/2, Y = Destino.getY()+Destino.getHeight();
	float pendiente =  (Y-K)/(X-Q);
	for(float i = X <= Q? X:Q ; i<= (X<=Q? Q:X);i+=GrosorLinea ) {
		//i es X, Y sale con la formula
		float pY = (int) ((pendiente*i)-(pendiente*Q)+K);
		System.out.println("X: "+i+" Y: "+pY);

		if(null != getGraphics()) {
		Graphics g = getGraphics();
		g.setColor(Proyecto.getColorTerciario());
		g.fillOval((int)i,(int) pY, GrosorLinea, GrosorLinea);
	   }
	}
	
	
	

 }


}

    
    
    

