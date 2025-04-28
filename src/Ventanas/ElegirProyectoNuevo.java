package Ventanas;

import Proyecto.Proyecto;
import ValoresDefault.Constantes;
import ValoresDefault.Constantes.Tipo_Proyecto;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import org.w3c.dom.events.EventException;

public class ElegirProyectoNuevo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField TextField_NombreDelProyecto;
	private ButtonGroup RadioButtonMenuItem_TipoDeApp;
	private JTextPane TextPane_Descripcion;
	public ElegirProyectoNuevo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Constantes.PantallaOrdenadorX/4,Constantes.PantallaOrdenadorY/4,Constantes.PantallaOrdenadorX/2,Constantes.PantallaOrdenadorY/2);
		setResizable(false);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel JLabel_Titulo = new JLabel("Nuevo Proyecto");
		JLabel_Titulo.setFont(Constantes.Titulos);
		panel.add(JLabel_Titulo);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout());
		
		JPanel Panel_TituloDeProyecto = new JPanel();
		panel_1.add(Panel_TituloDeProyecto, BorderLayout.NORTH);
		Panel_TituloDeProyecto.setLayout(new BorderLayout(0, 0));
		
		JPanel Panel_TituloProyecto = new JPanel();
		Panel_TituloDeProyecto.add(Panel_TituloProyecto);
		Panel_TituloProyecto.setLayout(new GridLayout(2,1,0,0));
		
		JLabel JLabel_NombreDelProyecto = new JLabel("Nombre del proyecto:");
		JLabel_NombreDelProyecto.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_NombreDelProyecto.setFont(Constantes.textoNormal);
		Panel_TituloProyecto.add(JLabel_NombreDelProyecto);
		
		TextField_NombreDelProyecto = new JTextField();
		Panel_TituloProyecto.add(TextField_NombreDelProyecto);
		TextField_NombreDelProyecto.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("                               ");
		Panel_TituloDeProyecto.add(lblNewLabel, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("                               ");
		Panel_TituloDeProyecto.add(lblNewLabel_1, BorderLayout.EAST);
		
		JLabel lblNewLabel_14 = new JLabel("                               ");
		Panel_TituloDeProyecto.add(lblNewLabel_14, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_15 = new JLabel("                               ");
		Panel_TituloDeProyecto.add(lblNewLabel_15, BorderLayout.NORTH);
		
		JPanel Panel_TipoDeProyecto = new JPanel();
		panel_1.add(Panel_TipoDeProyecto, BorderLayout.CENTER);
		Panel_TipoDeProyecto.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel Panel_Caracteristicas = new JPanel();
		Panel_TipoDeProyecto.add(Panel_Caracteristicas);
		Panel_Caracteristicas.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		Panel_Caracteristicas.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Tipo de proyecto:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Source Serif Pro Semibold", Font.PLAIN, 25));
		panel_5.add(lblNewLabel_4, BorderLayout.CENTER);
		
		JLabel lblNewLabel_12 = new JLabel("         ");
		panel_5.add(lblNewLabel_12, BorderLayout.WEST);
		
		JLabel lblNewLabel_13 = new JLabel("         ");
		panel_5.add(lblNewLabel_13, BorderLayout.EAST);
		
		JPanel panel_7 = new JPanel();
		Panel_Caracteristicas.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_7.add(panel_6);
		panel_6.setLayout(new GridLayout(3, 1, 0, 0));
		

	    RadioButtonMenuItem_TipoDeApp = new ButtonGroup();
		
		JRadioButton JRadioButton_TemarioEducativo = new JRadioButton("Temario Educativo");
		panel_6.add(JRadioButton_TemarioEducativo);
		JRadioButton_TemarioEducativo.setActionCommand("Temario Educativo");
		JRadioButton_TemarioEducativo.setFont(Constantes.botones);
		
		JRadioButton JRadioButton_GuiaEducativa = new JRadioButton("Guia Educativa");
		panel_6.add(JRadioButton_GuiaEducativa);
		JRadioButton_GuiaEducativa.setActionCommand("Guia Educativa");
		JRadioButton_GuiaEducativa.setFont(Constantes.botones);
		
		JRadioButton JRadioButton_TipsDiarios = new JRadioButton("Tips Diarios");
		panel_6.add(JRadioButton_TipsDiarios);
		JRadioButton_TipsDiarios.setActionCommand("Tips Diarios");
		JRadioButton_TipsDiarios.setFont(Constantes.botones);
		
		RadioButtonMenuItem_TipoDeApp.add(JRadioButton_TemarioEducativo);
		RadioButtonMenuItem_TipoDeApp.add(JRadioButton_GuiaEducativa);
		RadioButtonMenuItem_TipoDeApp.add(JRadioButton_TipsDiarios);

		
		
		
		
		/////////////////////////////////////////////////////////////////////////
		JLabel lblNewLabel_16 = new JLabel("                        ");
		Panel_Caracteristicas.add(lblNewLabel_16, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_17 = new JLabel("                        ");
		Panel_Caracteristicas.add(lblNewLabel_17, BorderLayout.WEST);
		
		JLabel label = new JLabel("                        ");
		Panel_Caracteristicas.add(label, BorderLayout.EAST);
		
		JPanel Panel_DescripcionDelProyecto = new JPanel();
		Panel_TipoDeProyecto.add(Panel_DescripcionDelProyecto);
		Panel_DescripcionDelProyecto.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_8 = new JLabel("            ");
		Panel_DescripcionDelProyecto.add(lblNewLabel_8, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_6 = new JLabel("            ");
		Panel_DescripcionDelProyecto.add(lblNewLabel_6, BorderLayout.WEST);
		
		JLabel lblNewLabel_7 = new JLabel("            ");
		Panel_DescripcionDelProyecto.add(lblNewLabel_7, BorderLayout.EAST);
		
		JLabel lblNewLabel_9 = new JLabel("            ");
		Panel_DescripcionDelProyecto.add(lblNewLabel_9, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		Panel_DescripcionDelProyecto.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("Descripcion:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_5);
		
	    TextPane_Descripcion = new JTextPane();
		panel_3.add(TextPane_Descripcion);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JButton btn_NuevoProyectoHecho = new JButton("Hecho");
		panel_2.add(btn_NuevoProyectoHecho);
		btn_NuevoProyectoHecho.addActionListener(this);
		
		JLabel lblNewLabel_11 = new JLabel("                                      ");
		panel_2.add(lblNewLabel_11, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_10 = new JLabel("                                      ");
		panel_2.add(lblNewLabel_10, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("                                      ");
		panel_2.add(lblNewLabel_2, BorderLayout.WEST);
		
		JLabel lblNewLabel_3 = new JLabel("                                      ");
		panel_2.add(lblNewLabel_3, BorderLayout.EAST);
	
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
	if(!TextField_NombreDelProyecto.getText().isEmpty() && RadioButtonMenuItem_TipoDeApp != null && !TextPane_Descripcion.getText().isEmpty()) {
		System.out.print("Creando ");
      Proyecto.setDescripcion_Proyecto(TextPane_Descripcion.getText());
      Proyecto.setNombre_Proyecto(TextField_NombreDelProyecto.getText());
     switch(RadioButtonMenuItem_TipoDeApp.getSelection().getActionCommand()){
     case "Guia Educativa":
      Proyecto.setTipo_Proyecto(Tipo_Proyecto.Guia_Educativa);
		System.out.println("Guia Educativa");
		Proyecto.SetVentanaColores();
		dispose();
      break;
     case "Temario Educativo":
         Proyecto.setTipo_Proyecto(Tipo_Proyecto.Temario_Educativo);
   		System.out.println("Temario Educativo");
   		Proyecto.SetVentanaColores();
   		dispose();
   		break;
     case "Tips Diarios":
         Proyecto.setTipo_Proyecto(Tipo_Proyecto.Tips_Diarios);
   		System.out.println("Tips Diarios");
   		Proyecto.SetVentanaColores();
   		dispose();
   		break;
   		default: System.out.println(RadioButtonMenuItem_TipoDeApp.getSelection().toString()); break;
      
     }
	}
	else {
		JOptionPane.showMessageDialog(this,"Error al llenar el formulario");
	}
		}
		catch(EventException e){
			
			JOptionPane.showMessageDialog(this,"Error al llenar el formulario");
			}
		
	}


}
