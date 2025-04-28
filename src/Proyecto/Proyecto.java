package Proyecto;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import  ValoresDefault.Constantes.Tipo_Proyecto;
import javax.swing.ImageIcon;

import Temario_Educativo.FichaInformacion;
import Temario_Educativo.Temario_Educativo_ElegirColor;
import Temario_Educativo.Temario_Educativo_MainScenesManager;
import Temario_Educativo.Temario_Educativo_Portada;



public class Proyecto{

	private static String Nombre_Proyecto = "Error";
	private static String Titulo_Portada = "Incompleto";
	private static String Descripcion_Proyecto = "Sin Proyecto";
	private static Tipo_Proyecto Tipo_Proyecto; 
	private static ArrayList<String> Creadores;
	private static Image Imagen_Portada;
	private static Color ColorPrimario;
	private static Color ColorSecundario;
	private static Color ColorTerciario;
	
	////////////////////////////////////////// Temario Educativo ///////////////////////////
	private static HashMap<String,FichaInformacion> fichasInformativas = new HashMap<String,FichaInformacion>();
	
	
	
	public static void SetVentanaColores() {
		switch(Tipo_Proyecto) {
		case Guia_Educativa:	break;
		case Tips_Diarios: break;
		case Temario_Educativo: 			
			Temario_Educativo_ElegirColor Ventanta_TemarioEducativo_ElegirColor = new Temario_Educativo_ElegirColor();
			break;
		
		
		}
		
		
	}
	
	public static void SetVentanaPortada() {
		switch(Tipo_Proyecto) {
		case Guia_Educativa: break;
		case Tips_Diarios: break;
		case Temario_Educativo: 
			Temario_Educativo_Portada Ventana_TemarioEducativo_Portada = new Temario_Educativo_Portada();
			break;
		}
	}
	public static void SetMainScenesManager() {
		switch(Tipo_Proyecto) {
		case Guia_Educativa: break;
		case Tips_Diarios: break;
		case Temario_Educativo: 
			Temario_Educativo_MainScenesManager Ventana_TemarioEducativo_MainScenesManager = new Temario_Educativo_MainScenesManager();
			break;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void setNombre_Proyecto(String nombre_Proyecto) {
		Nombre_Proyecto = nombre_Proyecto;
	}
	public static void setTitulo_Portada(String titulo_Portada) {
		Titulo_Portada = titulo_Portada;
	}
	public static void setDescripcion_Proyecto(String descripcion_Proyecto) {
		Descripcion_Proyecto = descripcion_Proyecto;
	}
	public static void setTipo_Proyecto(Tipo_Proyecto tipo_Proyecto) {
		Tipo_Proyecto = tipo_Proyecto;
	}
	public static void setCreadores(ArrayList<String> creadores) {
		Creadores = creadores;
	}
	public static void setImagenPortada(Image portada) {
		Imagen_Portada = portada;
	}
	public static void setColorPrimario(Color colorPrimario) {
		ColorPrimario = colorPrimario;
	}
	public static void setColorSecundario(Color colorSecundario) {
		ColorSecundario = colorSecundario;
	}
	public static void setColorTerciario(Color colorTerciario) {
		ColorTerciario = colorTerciario;
	}	
	public static String getNombre_Proyecto() {
		return Nombre_Proyecto;
	}
	public static String getTitulo_Portada() {
		return Titulo_Portada;
	}
	public static String getDescripcion_Proyecto() {
		return Descripcion_Proyecto;
	}
	public static Tipo_Proyecto getTipo_Proyecto() {
		return Tipo_Proyecto;
	}
	public static ArrayList<String> getCreadores() {
		return Creadores;
	}
	public static Image getImagenPortada() {
		return Imagen_Portada;
	}
	public static Color getColorPrimario() {
		return ColorPrimario;
	}
	public static Color getColorSecundario() {
		return ColorSecundario;
	}
	public static Color getColorTerciario() {
		return ColorTerciario;
	}

	public static HashMap<String,FichaInformacion> getFichasDeInformacion() {
		return fichasInformativas;
	}


}
