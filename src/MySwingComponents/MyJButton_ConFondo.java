package MySwingComponents;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

import javax.swing.JButton;

import ValoresDefault.Constantes;

public class MyJButton_ConFondo extends JButton {
Image img;
Color bg = Constantes.ColorTexto;
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0,this.getWidth(),this.getHeight(),null);
		setBackground(bg.darker());
		setForeground(bg.brighter());
		super.paintComponent(g);
	}
	public void CambiarFondo(Image img) {
		this.img = img;
		super.repaint();
	}
	public void CambiarFondo(Color Color) {
		this.bg = Color;
		super.repaint();
	}

}

