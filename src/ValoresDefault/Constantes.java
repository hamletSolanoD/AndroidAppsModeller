package ValoresDefault;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.UUID;
import javax.imageio.ImageIO;

public interface Constantes {
public static  int PantallaOrdenadorX = Toolkit.getDefaultToolkit().getScreenSize().width;
public static  int PantallaOrdenadorY = Toolkit.getDefaultToolkit().getScreenSize().height;

public static Font botones = new Font("Arial",Font.ITALIC,PantallaOrdenadorX/80);
public static Font textoNormal = new Font("Arial",Font.PLAIN,PantallaOrdenadorX/100);
public static Font Titulos = new Font("Arial",Font.BOLD,PantallaOrdenadorX/40);


public static enum Tipo_Proyecto {
	Temario_Educativo("Temario Educativo"), Guia_Educativa("Guia Educativa"),Tips_Diarios("Tips Diarios");
	String TipoProyecto;
    Tipo_Proyecto(String TipoProyecto) {
    	this.TipoProyecto = TipoProyecto;
    }
    public String GetTipo_Proyecto() {
    	return TipoProyecto;
    }
	}
public static enum TipoFicha{
	Ficha_Informativa("Ficha Informativa"),Ficha_LinealHorizontal("Ficha Lineal Horizontal"),Ficha_LinealVertical("Ficha Lineal Vertical"),
	Ficha_Indice("Ficha Indice");
	
	String g;
	private TipoFicha(String g) {
		this.g = g;
	}
	
	public String GetTipo_Ficha() {
		return g;
	}
	
}
public static Color Transparente = new Color(0,0,0,0);
public static Color Fondo = new Color(170,177,176);
public static Color ColorTexto = new Color(70,70,250);

public static class Parrafo{ 
	private StringBuffer Texto = new StringBuffer("Texto Vacio..."); 
	private String Identificador;
	public Parrafo() {
		Identificador = UUID.randomUUID().toString();
		
	}
	public Parrafo(String texto) {
		Identificador = UUID.randomUUID().toString();
		Texto = new StringBuffer(texto);
		
	}
	public String GetID() {
		return Identificador;
	}
	public void AgregarTexto(String nuevaLinea) {
		Texto.insert(Texto.length(),nuevaLinea);
	}
	public void SetTexto(String s) {
		Texto = new StringBuffer(s);
	}
	public void BorrarChar() {
		Texto.deleteCharAt(Texto.length());
	}
	public String getTexto() {
		return Texto.toString();
	}
	
}
public static class Ilustracion{
	private Image Imagen;
	private final String Identificador;
	public Ilustracion(Image Imagen) {
		Identificador = UUID.randomUUID().toString();
		this.Imagen = Imagen;
	}
	public Ilustracion() {
		Identificador = UUID.randomUUID().toString();			
    try {Imagen = ImageIO.read(getClass().getResource("/Incompleto.jpg")); 
     }
    catch (IOException ignorado) {}
	
	
	}
	public String GetID() {
		return Identificador;
	}
	public void SetImage(Image Imagen) {
		this.Imagen = Imagen;
	}
	public Image GetImage() {
		return Imagen;
	}
	
};

}
