/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Temario_Educativo;

import ValoresDefault.Constantes;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Proyecto.Proyecto;


public class Temario_Educativo_ElegirColor extends javax.swing.JFrame implements ChangeListener, ActionListener {

	private static final long serialVersionUID = 1L;
	JColorChooser JColorChooser_ColorPrimario;
	 JColorChooser JColorChooser_ColorSecundario;
	 JColorChooser JColorChooser_ColorTerciario;
	 
	 Panel Vista2_ColorPrimario;
	 Panel Vista2_ColorSecundario;
	 Panel Vista2_ColorTerciario;
	 
	 Panel Vista1_ColorPrimario;
	 Panel Vista1_ColorSecundario;
     Panel Vista1_ColorTerciario;
    public Temario_Educativo_ElegirColor() {
    	setResizable(false);
    	
    	getContentPane().setBackground(Constantes.Fondo);
        setBounds(Constantes.PantallaOrdenadorX/4,(Constantes.PantallaOrdenadorY/20),(Constantes.PantallaOrdenadorX/10)*7,(Constantes.PantallaOrdenadorY/8)*7);
        getContentPane().setLayout(new BorderLayout(0, 0));
        
        JPanel JPanel_BtnHecho = new JPanel();
        getContentPane().add(JPanel_BtnHecho, BorderLayout.SOUTH);
        JPanel_BtnHecho.setBorder(new LineBorder(new Color(0, 0, 0)));
        JPanel_BtnHecho.setBackground(Constantes.Transparente);
        JPanel_BtnHecho.setLayout(new BorderLayout(0, 0));
        
        JButton Btn_Hecho = new JButton("Hecho");
        Btn_Hecho.addActionListener(this);
        Btn_Hecho.setFont(Constantes.botones);
        JPanel_BtnHecho.add(Btn_Hecho);
        
        Component horizontalStrut_2 = Box.createHorizontalStrut(50);
        horizontalStrut_2.setFont(new Font("Dialog", Font.PLAIN, 34));
        JPanel_BtnHecho.add(horizontalStrut_2, BorderLayout.WEST);
        
        Component horizontalStrut_3 = Box.createHorizontalStrut(50);
        horizontalStrut_3.setFont(new Font("Dialog", Font.PLAIN, 34));
        JPanel_BtnHecho.add(horizontalStrut_3, BorderLayout.EAST);
        
        Component verticalStrut_2 = Box.createVerticalStrut(23);
        verticalStrut_2.setFont(new Font("Dialog", Font.PLAIN, 34));
        JPanel_BtnHecho.add(verticalStrut_2, BorderLayout.NORTH);
        
        Component verticalStrut_3 = Box.createVerticalStrut(14);
        verticalStrut_3.setFont(new Font("Dialog", Font.PLAIN, 34));
        JPanel_BtnHecho.add(verticalStrut_3, BorderLayout.SOUTH);
        
        JPanel JPanel_Titulo = new JPanel();
        JPanel_Titulo.setBorder(new LineBorder(new Color(0, 0, 0)));
        getContentPane().add(JPanel_Titulo, BorderLayout.NORTH);
        JPanel_Titulo.setBackground(Constantes.Transparente);
        JPanel_Titulo.setLayout(new BorderLayout(0, 0));
        
        JLabel Titulo = new JLabel("Colores De Fondo");
        Titulo.setHorizontalAlignment(SwingConstants.CENTER);
        Titulo.setForeground(Constantes.ColorTexto);
        Titulo.setFont(Constantes.Titulos);
        JPanel_Titulo.add(Titulo, BorderLayout.CENTER);
        
        
        Component horizontalStrut = Box.createHorizontalStrut(20);
        JPanel_Titulo.add(horizontalStrut, BorderLayout.WEST);
        
        Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        JPanel_Titulo.add(horizontalStrut_1, BorderLayout.EAST);
        
        Component verticalStrut = Box.createVerticalStrut(20);
        JPanel_Titulo.add(verticalStrut, BorderLayout.SOUTH);
        
        Component verticalStrut_1 = Box.createVerticalStrut(20);
        JPanel_Titulo.add(verticalStrut_1, BorderLayout.NORTH);
        
        JPanel JPanel_Contenido = new JPanel();
        getContentPane().add(JPanel_Contenido, BorderLayout.CENTER);
        JPanel_Contenido.setLayout(new GridLayout(1, 2, 0, 0));
        JPanel_Contenido.setBackground(Constantes.Transparente);

        
        JPanel JPanel_Caracteristicas = new JPanel();
        JPanel_Contenido.add(JPanel_Caracteristicas);
        JPanel_Caracteristicas.setBackground(Constantes.Transparente);
        JPanel_Caracteristicas.setLayout(new GridLayout(3, 1, 0, 0));
        
        JPanel JPanel_ColorPrimario = new JPanel();
        JPanel_ColorPrimario.setBorder(new LineBorder(new Color(0, 0, 0)));
        JPanel_Caracteristicas.add(JPanel_ColorPrimario);
        JPanel_ColorPrimario.setBackground(Constantes.Transparente);
        JPanel_ColorPrimario.setLayout(new BorderLayout(0, 0));
        
        JPanel JPanel_TituloPrimario = new JPanel();
        JPanel_TituloPrimario.setBackground(Constantes.Transparente);
        JPanel_ColorPrimario.add(JPanel_TituloPrimario, BorderLayout.NORTH);

        
        
        
        JLabel lblNewLabel = new JLabel("Color Primario");
        lblNewLabel.setForeground(Constantes.ColorTexto);
        lblNewLabel.setFont(Constantes.textoNormal);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel_TituloPrimario.add(lblNewLabel);
        ///////////////////////   PRIMERO    /////////////////////////////////////////
        JColorChooser_ColorPrimario  = new JColorChooser();
        JPanel_ColorPrimario.add(JColorChooser_ColorPrimario, BorderLayout.CENTER);
        JColorChooser_ColorPrimario.setPreviewPanel(new JPanel());
        JColorChooser_ColorPrimario.setBackground(Color.BLACK);
        JColorChooser_ColorPrimario.getSelectionModel().addChangeListener(this);
        
        //////////////////////////////////////////////////////////////////////////////
        
        JPanel JPanel_ColorSecundario = new JPanel();
        JPanel_ColorSecundario.setBorder(new LineBorder(new Color(0, 0, 0)));
        JPanel_ColorSecundario.setBackground(Constantes.Transparente);

        JPanel_Caracteristicas.add(JPanel_ColorSecundario);
        JPanel_ColorSecundario.setLayout(new BorderLayout(0, 0));
        
        JPanel JPanel_TituloSecundario = new JPanel();
        JPanel_TituloSecundario.setBackground(new Color(0, 0, 0, 0));
        JPanel_ColorSecundario.add(JPanel_TituloSecundario, BorderLayout.NORTH);
        
        JLabel lblNewLabel_1 = new JLabel("Color Secundario");
        lblNewLabel_1.setForeground(Constantes.ColorTexto);
        lblNewLabel_1.setFont(Constantes.textoNormal);
        JPanel_TituloSecundario.add(lblNewLabel_1);
        ///////////////////////////////////////////////////////           SEGUNDO         ////////////////////////
        JColorChooser_ColorSecundario = new JColorChooser();
        JColorChooser_ColorSecundario.setPreviewPanel(new JPanel());
        JColorChooser_ColorSecundario.setBackground(Color.BLACK);
        JPanel_ColorSecundario.add(JColorChooser_ColorSecundario, BorderLayout.CENTER);
        JColorChooser_ColorSecundario.getSelectionModel().addChangeListener(this);
        
        //////////////////////////////////////////////////////////////////////////////
        JPanel JPanel_ColorTerciario = new JPanel();
        JPanel_ColorTerciario.setBorder(new LineBorder(new Color(0, 0, 0)));
        JPanel_ColorTerciario.setBackground(Constantes.Transparente);

        JPanel_Caracteristicas.add(JPanel_ColorTerciario);
        JPanel_ColorTerciario.setLayout(new BorderLayout(0, 0));
        
        JPanel JPanel_TituloTerciario = new JPanel();
        JPanel_TituloTerciario.setBackground(new Color(0, 0, 0, 0));
        JPanel_ColorTerciario.add(JPanel_TituloTerciario, BorderLayout.NORTH);
        
        JLabel lblNewLabel_1_1 = new JLabel("Color Secundario");
        lblNewLabel_1_1.setForeground(Constantes.ColorTexto);
        lblNewLabel_1_1.setFont(Constantes.textoNormal);
        JPanel_TituloTerciario.add(lblNewLabel_1_1);
        ////////////////////////////////////////////////////////////////////////////////// TERCERO ////////////////////////////////////////////////////////////
        JColorChooser_ColorTerciario = new JColorChooser();
        JColorChooser_ColorTerciario.setPreviewPanel(new JPanel());
        JColorChooser_ColorTerciario.setBackground(Color.BLACK);
        JPanel_ColorTerciario.add(JColorChooser_ColorTerciario, BorderLayout.CENTER);
        JColorChooser_ColorTerciario.getSelectionModel().addChangeListener(this);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        JPanel JPanel_Previsualizacion = new JPanel();
        JPanel_Previsualizacion.setBorder(new LineBorder(new Color(0, 0, 0)));
        JPanel_Previsualizacion.setBackground(Constantes.Transparente);
        JPanel_Contenido.add(JPanel_Previsualizacion);
        JPanel_Previsualizacion.setLayout(new GridLayout(2, 1, 0, 0));
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(Color.WHITE));
        panel_1.setBackground(Color.BLACK);
        JPanel_Previsualizacion.add(panel_1);
        panel_1.setLayout(null);
        
        Panel panel_2_1 = new Panel();
        panel_2_1.setBackground(SystemColor.info);
        panel_2_1.setBounds(10, 52, 285, 342);
        panel_1.add(panel_2_1);
        panel_2_1.setLayout(null);
        
        Vista1_ColorTerciario = new Panel();
        Vista1_ColorTerciario.setBackground(Color.GREEN);
        Vista1_ColorTerciario.setBounds(0, 204, 285, 10);
        panel_2_1.add(Vista1_ColorTerciario);
        
        Panel Vista1_ColorPrimario_2 = new Panel();
        Vista1_ColorPrimario_2.setBackground(new Color(240, 255, 255));
        Vista1_ColorPrimario_2.setBounds(35, 51, 210, 133);
        panel_2_1.add(Vista1_ColorPrimario_2);
        
        JLabel lblBarraDeTareas_1_1 = new JLabel("FOTO DE INTRODUCCION");
        lblBarraDeTareas_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblBarraDeTareas_1_1.setForeground(Color.BLACK);
        lblBarraDeTareas_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblBarraDeTareas_1_1.setBackground(Color.BLACK);
        Vista1_ColorPrimario_2.add(lblBarraDeTareas_1_1);
        
        Panel Vista1_ColorPrimario_2_1 = new Panel();
        Vista1_ColorPrimario_2_1.setBackground(new Color(240, 255, 255));
        Vista1_ColorPrimario_2_1.setBounds(35, 238, 210, 104);
        panel_2_1.add(Vista1_ColorPrimario_2_1);
        
        Vista1_ColorSecundario = new Panel();
        Vista1_ColorSecundario.setBackground(new Color(128, 0, 0));
        Vista1_ColorSecundario.setBounds(10, 0, 285, 30);
        panel_1.add(Vista1_ColorSecundario);
        
        JLabel lblBarraDeTareas = new JLabel("BARRA DE TAREAS");
        lblBarraDeTareas.setBackground(Color.BLACK);
        lblBarraDeTareas.setForeground(Color.WHITE);
        lblBarraDeTareas.setFont(new Font("Tahoma", Font.BOLD, 17));
        Vista1_ColorSecundario.add(lblBarraDeTareas);
        
        JTextPane txtpnPrevistaDelIndice = new JTextPane();
        txtpnPrevistaDelIndice.setEditable(false);
        txtpnPrevistaDelIndice.setFont(new Font("Tahoma", Font.BOLD, 31));
        txtpnPrevistaDelIndice.setForeground(Color.WHITE);
        txtpnPrevistaDelIndice.setBackground(Color.BLACK);
        txtpnPrevistaDelIndice.setText("PRE-VISTA DEL INDICE\r\n");
        txtpnPrevistaDelIndice.setBounds(385, 108, 204, 109);
        panel_1.add(txtpnPrevistaDelIndice);
        
        Vista1_ColorPrimario = new Panel();
        Vista1_ColorPrimario.setBounds(10, 25, 285, 30);
        panel_1.add(Vista1_ColorPrimario);
        Vista1_ColorPrimario.setBackground(new Color(218, 165, 32));
        
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.WHITE));
        panel.setBackground(Color.BLACK);
        JPanel_Previsualizacion.add(panel);
        panel.setLayout(null);
        
        Panel panel_2_1_1 = new Panel();
        panel_2_1_1.setLayout(null);
        panel_2_1_1.setBackground(Color.WHITE);
        panel_2_1_1.setBounds(372, 25, 285, 342);
        panel.add(panel_2_1_1);
        
        Vista2_ColorPrimario = new Panel();
        Vista2_ColorPrimario.setBackground(new Color(218, 165, 32));
        Vista2_ColorPrimario.setBounds(0, -21, 285, 30);
        panel_2_1_1.add(Vista2_ColorPrimario);
        
        Vista2_ColorTerciario = new Panel();
        Vista2_ColorTerciario.setBackground(Color.GREEN);
        Vista2_ColorTerciario.setBounds(0, 174, 285, 10);
        panel_2_1_1.add(Vista2_ColorTerciario);
        
        Panel Vista1_ColorPrimario_2_2 = new Panel();
        Vista1_ColorPrimario_2_2.setBounds(0, 15, 285, 153);
        panel_2_1_1.add(Vista1_ColorPrimario_2_2);
        Vista1_ColorPrimario_2_2.setBackground(new Color(240, 255, 255));
        
        JLabel lblBarraDeTareas_1_1_1 = new JLabel("FOTO DE INTRODUCCION");
        lblBarraDeTareas_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblBarraDeTareas_1_1_1.setForeground(Color.BLACK);
        lblBarraDeTareas_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblBarraDeTareas_1_1_1.setBackground(Color.BLACK);
        Vista1_ColorPrimario_2_2.add(lblBarraDeTareas_1_1_1);
        
        JLabel lblNewLabel_2 = new JLabel("TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO ");
        lblNewLabel_2.setBackground(SystemColor.info);
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_2.setBounds(0, 189, 285, 140);
        panel_2_1_1.add(lblNewLabel_2);
        
        Vista2_ColorSecundario = new Panel();
        Vista2_ColorSecundario.setBackground(new Color(128, 0, 0));
        Vista2_ColorSecundario.setBounds(372, 0, 285, 30);
        panel.add(Vista2_ColorSecundario);
        
        JLabel lblBarraDeTareas_1 = new JLabel("BARRA DE TAREAS");
        lblBarraDeTareas_1.setForeground(Color.WHITE);
        lblBarraDeTareas_1.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblBarraDeTareas_1.setBackground(Color.BLACK);
        Vista2_ColorSecundario.add(lblBarraDeTareas_1);
        
        JTextPane txtpnPrevistaDeLas = new JTextPane();
        txtpnPrevistaDeLas.setEditable(false);
        txtpnPrevistaDeLas.setText("PRE-VISTA DE LAS FICHAS TECNICAS");
        txtpnPrevistaDeLas.setForeground(Color.WHITE);
        txtpnPrevistaDeLas.setFont(new Font("Tahoma", Font.BOLD, 31));
        txtpnPrevistaDeLas.setBackground(Color.BLACK);
        txtpnPrevistaDeLas.setBounds(0, 129, 204, 125);
        panel.add(txtpnPrevistaDeLas);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void SetPreviewColors() {
    	Vista1_ColorPrimario.setBackground(JColorChooser_ColorPrimario.getColor());
    	Vista1_ColorSecundario.setBackground(JColorChooser_ColorSecundario.getColor());
    	Vista1_ColorTerciario.setBackground(JColorChooser_ColorTerciario.getColor());
    	Vista2_ColorPrimario.setBackground(JColorChooser_ColorPrimario.getColor());
    	Vista2_ColorSecundario.setBackground(JColorChooser_ColorSecundario.getColor());
    	Vista2_ColorTerciario.setBackground(JColorChooser_ColorTerciario.getColor());
    }

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		SetPreviewColors();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Proyecto.setColorPrimario(JColorChooser_ColorPrimario.getColor());
		Proyecto.setColorSecundario(JColorChooser_ColorSecundario.getColor());
		Proyecto.setColorTerciario(JColorChooser_ColorTerciario.getColor());
		Proyecto.SetVentanaPortada();
		dispose();

	}
}
