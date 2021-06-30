package Temario_Educativo;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

import ValoresDefault.Constantes.Ilustracion;
import ValoresDefault.Constantes.Parrafo;
import ValoresDefault.Constantes.TipoFicha;
public class FichaIndiceInformativo extends FichaInformacion{
	
	private HashMap<String,FichaInformacion> FichasDeInformacion = new HashMap<String,FichaInformacion>();
	private ArrayList<String> IndiceDeInformacionEnOrden = new ArrayList<String>();

	
	public FichaIndiceInformativo(String Titulo,FichaIndiceInformativo IndicePadre, String Resumen, Image ImagenPortada) {
		super(Titulo, IndicePadre, TipoFicha.Ficha_Indice, Resumen, ImagenPortada);
		FichasDeInformacion.put(this.getID(), this);

	}
	public FichaIndiceInformativo() {		FichasDeInformacion.put(this.getID(), this);
}
	@Override
	public HashMap<String,Parrafo> getTextos() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public HashMap<String,Ilustracion> getImagenes() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public HashMap<String,FichaInformacion> getFichasDeInformacion() {
		// TODO Auto-generated method stub
		return FichasDeInformacion;
	}
	@Override
	public ArrayList<String> getIndiceDeComponentes() {
		// TODO Auto-generated method stub
		return IndiceDeInformacionEnOrden;
	}


	

	

	
}
