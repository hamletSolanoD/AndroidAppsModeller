package Main;

import java.awt.Color;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.swing.JButton;

import Temario_Educativo.*;
import Ventanas.*;

public class Main {

	private static void InicializarValoresDefault() {try {
		Proyecto.Proyecto.setImagenPortada(ImageIO.read(Main.class.getResource("/Incompleto.jpg")));
		Proyecto.Proyecto.setColorPrimario(new Color(1f,0.54f,0.64f));
		Proyecto.Proyecto.setColorSecundario(new Color(0.55f,1f,0.63f));
		Proyecto.Proyecto.setColorTerciario(new Color(0.45f,0.75f,1f));

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InicializarValoresDefault();
		//new LoginUser();
   //new ElegirProyectoNuevo();
    // new Temario_Educativo_ElegirColor();
 //   new  Temario_Educativo_Portada();
    new Temario_Educativo_MainScenesManager();
		
	
	}

}
