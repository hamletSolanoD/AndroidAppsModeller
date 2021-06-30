package MySwingComponents;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class MyJTextPane extends JTextPane{

	Image img;
	int Horizontal, Veretical; 
	
	public MyJTextPane(Image img) {
		this.img = img;
		this.setOpaque(false);
	}
	public MyJTextPane(Image img,int Horizontal, int Veretical) {
		this.Horizontal = Horizontal;
		this.Veretical = Veretical;
		this.img = img;
		this.setOpaque(false);
	}
	public void paintComponent(Graphics g) {
		
		if(Horizontal > 0 && Veretical > 0 ) {
			g.drawImage(img.getScaledInstance(Horizontal, Veretical, Image.SCALE_SMOOTH),0,0,Horizontal,Veretical,null);
			setPreferredSize(new Dimension(Horizontal,Veretical));
			setSize(Horizontal,Veretical);
		}
		else {			g.drawImage(img,0,0,this.getWidth(),this.getHeight(),null);}
		super.paintComponent(g);
	}

	public void repaint(Image img) {
		this.img = img;
		super.repaint();
	}
	
	
	
	
	
}
