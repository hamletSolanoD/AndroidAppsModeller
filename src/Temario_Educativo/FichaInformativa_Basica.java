package Temario_Educativo;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

import Proyecto.Proyecto;
import ValoresDefault.Constantes.*;

public class FichaInformativa_Basica extends FichaInformacion{


private HashMap<String,Parrafo> Textos = new HashMap<String,Parrafo>();
private HashMap<String,Ilustracion> Imagenes = new HashMap<String,Ilustracion>();
private ArrayList<String> IndiceDeInformacionEnOrden = new ArrayList<String>();


public FichaInformativa_Basica(String Titulo, FichaIndiceInformativo IndicePadre,String Resumen, Image ImagenPortada) {
	super(Titulo, IndicePadre, TipoFicha.Ficha_Informativa, Resumen, ImagenPortada);
}


public FichaInformativa_Basica() {
	// TODO Auto-generated constructor stub
}


@Override
public HashMap<String,Parrafo> getTextos() {
	// TODO Auto-generated method stub
	return Textos;
}

@Override
public  HashMap<String,Ilustracion> getImagenes() {
	// TODO Auto-generated method stub
	return Imagenes;
}
@Override
public HashMap<String,FichaInformacion> getFichasDeInformacion() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public ArrayList<String> getIndiceDeComponentes() {
	// TODO Auto-generated method stub
	return IndiceDeInformacionEnOrden;
}






}







