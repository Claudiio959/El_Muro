package Window;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Crypt.Desencriptador;
import Crypt.Encriptador;

import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextPane;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/** 
*	Clase que representa la ventana visual
* @author Paco Gomez
* @author www.cookingsoftware.es
* @version 1.0
*/
public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	
	//Textos orginal y transformado
	JTextPane textoOriginal,textoTransformado;
	
	//Botones de accion
	JButton botonCodificar,botonDeCodificar;
	//Clases encriptadoras y desencriptadoras
	Encriptador encript=new Encriptador();
	Desencriptador deEncript=new Desencriptador();
	

	public static void main(String[] args) {
	}

	/** 
	 * Ventana visual para el desarrollo de code Agent
	*/
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		//Contenedor principal
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		//Contenedor para la primera etiqueta
		JPanel panel1 = new JPanel();
		contentPane.add(panel1);
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Frase a analizar");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(lblNewLabel);
		
		//Contenedor para el texto a codificar o decodificar
		JPanel panel2 = new JPanel();
		contentPane.add(panel2);
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
		
		textoOriginal = new JTextPane();
		panel2.add(textoOriginal);
		
		//Contenedor de los botones de accion
		JPanel panel3 = new JPanel();
		contentPane.add(panel3);
		
		botonCodificar = new JButton("CODIFICAR");
		botonCodificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textoTransformado.setText(encript.encriptarFrase(textoOriginal.getText()));
			}
		});
		panel3.add(botonCodificar);
		
		botonDeCodificar = new JButton("DECODIFICAR");
		botonDeCodificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textoTransformado.setText(deEncript.desencriptarFrase(textoOriginal.getText()));
			}
		});
		panel3.add(botonDeCodificar);
		
		//Contenedor del texto codificado/decodificado
		JPanel panel4 = new JPanel();
		contentPane.add(panel4);
		panel4.setLayout(new BoxLayout(panel4, BoxLayout.X_AXIS));
		
		textoTransformado = new JTextPane();
		textoTransformado.setEditable(false);
		panel4.add(textoTransformado);
	}
	

}
