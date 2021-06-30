package Temario_Educativo;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import Proyecto.Proyecto;
import ValoresDefault.Constantes.Ilustracion;
import ValoresDefault.Constantes.Parrafo;
import ValoresDefault.Constantes.TipoFicha;

public abstract class FichaInformacion {
	private String Titulo;
	private FichaIndiceInformativo IndicePadre;
	private  String ID = UUID.randomUUID().toString();
	private TipoFicha TipoDeFicha;
	private String Resumen;
	private Image ImagenPortada;
	public FichaInformacion(String Titulo,FichaIndiceInformativo IndicePadre, TipoFicha tipoFicha, String Resumen, Image ImagenPortada) {			
		this.Titulo = Titulo;
		this.IndicePadre = IndicePadre;
		this.TipoDeFicha = tipoFicha;
		this.Resumen = Resumen;
		this.ImagenPortada = ImagenPortada;
		
	}
	public FichaInformacion() {
		
		
	}
public String getTitulo() {
	return Titulo;
}



public FichaIndiceInformativo getIndicePadre() {
	
	return IndicePadre;
}


public String getID() {
	return ID;
}


public TipoFicha getTipoDeFicha() {
	return TipoDeFicha;
}

public String getResumen() {
	return Resumen;
}

public void setResumen(String resumen) {
	Resumen = resumen;
}

public Image getImagenPortada() {
	return ImagenPortada;
}

public boolean equals(FichaInformacion o) {
	
	boolean igualdad;
	if(this.ID == o.ID) 
	return true;
	else return false;
}

public abstract HashMap<String,Parrafo> getTextos();

public abstract ArrayList<String> getIndiceDeComponentes();

public abstract HashMap<String,Ilustracion>getImagenes();



public abstract HashMap<String,FichaInformacion> getFichasDeInformacion();
}

