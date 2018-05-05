package vista;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Component;

public class VistaPrincipal extends JFrame{
	protected JLabel puntosMonedas;
	protected JPanel cola;
	protected JPanel pilaUno;
	protected JPanel pilaDos;
	protected JPanel lista;
	protected JPanel panelSeleccionarColor;
	protected JPanel panelPedirColor;
	protected JButton botonPedirColor;
	protected JPanel panelBarajarPila;
	protected JButton botonBarajarPila;
	protected JPanel panelBorrarColor;
	protected JButton botonBorrarColor;
	protected JButton mensaje;
	protected JButton botonSeleccionarColor;
	protected JPanel panelBotones;
	protected JLabel puntuacionMaxima;
	
	public VistaPrincipal() {
		setSize(new Dimension(600, 400));
		setMinimumSize(new Dimension(300, 150));
		setPreferredSize(new Dimension(600, 400));
		getContentPane().setBackground(new Color(255, 255, 255));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {15, 40, 30, 30, 30, 30, 30, 30, 30, 30, 62, 49, 30, 14};
		gridBagLayout.rowHeights = new int[] {37, 20, 69, 36, 28, 30, 28, 21, 10};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblPicoli = new JLabel("PI");
		lblPicoli.setForeground(new Color(0, 0, 205));
		lblPicoli.setFont(new Font("Old English Text MT", Font.BOLD, 30));
		GridBagConstraints gbc_lblPicoli = new GridBagConstraints();
		gbc_lblPicoli.anchor = GridBagConstraints.EAST;
		gbc_lblPicoli.gridwidth = 4;
		gbc_lblPicoli.insets = new Insets(0, 0, 5, 5);
		gbc_lblPicoli.gridx = 2;
		gbc_lblPicoli.gridy = 0;
		getContentPane().add(lblPicoli, gbc_lblPicoli);
		
		JLabel lblCo = new JLabel("CO");
		lblCo.setForeground(new Color(50, 205, 50));
		lblCo.setFont(new Font("Old English Text MT", Font.BOLD, 30));
		GridBagConstraints gbc_lblCo = new GridBagConstraints();
		gbc_lblCo.gridwidth = 3;
		gbc_lblCo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCo.gridx = 6;
		gbc_lblCo.gridy = 0;
		getContentPane().add(lblCo, gbc_lblCo);
		
		JLabel lblNewLabel = new JLabel("LI");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Old English Text MT", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 9;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		cola = new JPanel();
		cola.setBackground(new Color(240, 255, 240));
		cola.setFocusable(false);
		GridBagConstraints gbc_cola = new GridBagConstraints();
		gbc_cola.insets = new Insets(2, 2, 5, 5);
		gbc_cola.gridheight = 5;
		gbc_cola.fill = GridBagConstraints.BOTH;
		gbc_cola.gridx = 1;
		gbc_cola.gridy = 1;
		getContentPane().add(cola, gbc_cola);
		cola.setLayout(new GridLayout(10, 1, 0, 0));
		
		pilaUno = new JPanel();
		pilaUno.setBackground(new Color(255, 255, 240));
		GridBagConstraints gbc_pilaUno = new GridBagConstraints();
		gbc_pilaUno.gridheight = 5;
		gbc_pilaUno.insets = new Insets(0, 0, 5, 5);
		gbc_pilaUno.fill = GridBagConstraints.BOTH;
		gbc_pilaUno.gridx = 2;
		gbc_pilaUno.gridy = 1;
		getContentPane().add(pilaUno, gbc_pilaUno);
		pilaUno.setLayout(new GridLayout(4, 1, 0, 0));
		
		pilaDos = new JPanel();
		pilaDos.setBackground(new Color(255, 255, 240));
		GridBagConstraints gbc_pilaDos = new GridBagConstraints();
		gbc_pilaDos.gridheight = 5;
		gbc_pilaDos.insets = new Insets(0, 0, 5, 5);
		gbc_pilaDos.fill = GridBagConstraints.BOTH;
		gbc_pilaDos.gridx = 3;
		gbc_pilaDos.gridy = 1;
		getContentPane().add(pilaDos, gbc_pilaDos);
		pilaDos.setLayout(new GridLayout(4, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Record");
		lblNewLabel_1.setFont(new Font("Bradley Hand ITC", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 4;
		gbc_lblNewLabel_1.gridy = 1;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		puntuacionMaxima = new JLabel("0");
		puntuacionMaxima.setHorizontalTextPosition(SwingConstants.LEFT);
		puntuacionMaxima.setHorizontalAlignment(SwingConstants.LEFT);
		puntuacionMaxima.setForeground(new Color(255, 140, 0));
		puntuacionMaxima.setFont(new Font("Stencil", Font.BOLD, 20));
		GridBagConstraints gbc_puntuacionMaxima = new GridBagConstraints();
		gbc_puntuacionMaxima.insets = new Insets(0, 0, 5, 5);
		gbc_puntuacionMaxima.gridx = 6;
		gbc_puntuacionMaxima.gridy = 1;
		getContentPane().add(puntuacionMaxima, gbc_puntuacionMaxima);
		
		JLabel tituloMonedas = new JLabel("Monedas");
		tituloMonedas.setHorizontalTextPosition(SwingConstants.LEADING);
		tituloMonedas.setHorizontalAlignment(SwingConstants.RIGHT);
		tituloMonedas.setPreferredSize(new Dimension(43, 24));
		tituloMonedas.setFont(new Font("Bradley Hand ITC", Font.BOLD, 20));
		tituloMonedas.setMinimumSize(new Dimension(46, 24));
		tituloMonedas.setMaximumSize(new Dimension(46, 24));
		GridBagConstraints gbc_tituloMonedas = new GridBagConstraints();
		gbc_tituloMonedas.fill = GridBagConstraints.BOTH;
		gbc_tituloMonedas.gridwidth = 3;
		gbc_tituloMonedas.insets = new Insets(0, 0, 5, 5);
		gbc_tituloMonedas.gridx = 8;
		gbc_tituloMonedas.gridy = 1;
		getContentPane().add(tituloMonedas, gbc_tituloMonedas);
		
		puntosMonedas = new JLabel("0");
		puntosMonedas.setForeground(new Color(255, 165, 0));
		puntosMonedas.setFont(new Font("Stencil", Font.BOLD, 20));
		puntosMonedas.setMaximumSize(new Dimension(1888, 1111));
		puntosMonedas.setMinimumSize(new Dimension(44, 20));
		puntosMonedas.setHorizontalTextPosition(SwingConstants.CENTER);
		puntosMonedas.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_puntosMonedas = new GridBagConstraints();
		gbc_puntosMonedas.fill = GridBagConstraints.VERTICAL;
		gbc_puntosMonedas.insets = new Insets(0, 0, 5, 0);
		gbc_puntosMonedas.gridx = 11;
		gbc_puntosMonedas.gridy = 1;
		getContentPane().add(puntosMonedas, gbc_puntosMonedas);
		
		lista = new JPanel();
		lista.setBackground(new Color(255, 245, 238));
		GridBagConstraints gbc_lista = new GridBagConstraints();
		gbc_lista.gridwidth = 9;
		gbc_lista.gridheight = 4;
		gbc_lista.insets = new Insets(0, 0, 5, 0);
		gbc_lista.fill = GridBagConstraints.BOTH;
		gbc_lista.gridx = 4;
		gbc_lista.gridy = 2;
		getContentPane().add(lista, gbc_lista);
		GridBagLayout gbl_lista = new GridBagLayout();
		gbl_lista.columnWidths = new int[] {63, 63, 63, 63, 63, 63, 63, 0};
		gbl_lista.rowHeights = new int[] {45, 45, 45, 45, 45, 0};
		gbl_lista.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_lista.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		lista.setLayout(gbl_lista);
		
		panelBotones = new JPanel();
		panelBotones.setMaximumSize(new Dimension(32767, 50));
		GridBagConstraints gbc_panelBotones = new GridBagConstraints();
		gbc_panelBotones.gridwidth = 12;
		gbc_panelBotones.insets = new Insets(0, 0, 5, 0);
		gbc_panelBotones.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelBotones.gridx = 1;
		gbc_panelBotones.gridy = 6;
		getContentPane().add(panelBotones, gbc_panelBotones);
		panelBotones.setLayout(new GridLayout(0, 4, 0, 0));
		
		panelSeleccionarColor = new JPanel();
		panelSeleccionarColor.setMaximumSize(new Dimension(32767, 50));
		panelBotones.add(panelSeleccionarColor);
		panelSeleccionarColor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelSeleccionarColor.setMinimumSize(new Dimension(10, 22));
		panelSeleccionarColor.setLayout(new BoxLayout(panelSeleccionarColor, BoxLayout.X_AXIS));
		
		botonSeleccionarColor = new JButton("Selecciona Color");
		panelSeleccionarColor.add(botonSeleccionarColor);
		botonSeleccionarColor.setMargin(new Insets(0, 0, 0, 0));
		botonSeleccionarColor.setPreferredSize(new Dimension(100, 22));
		botonSeleccionarColor.setMinimumSize(new Dimension(10, 22));
		botonSeleccionarColor.setMaximumSize(new Dimension(999, 50));
		botonSeleccionarColor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		botonSeleccionarColor.setBorder(new LineBorder(new Color(0, 255, 0), 1, true));
		botonSeleccionarColor.setBackground(new Color(204, 255, 153));
		
		
		panelPedirColor = new JPanel();
		panelPedirColor.setMaximumSize(new Dimension(32767, 50));
		panelBotones.add(panelPedirColor);
		panelPedirColor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelPedirColor.setMinimumSize(new Dimension(10, 22));
		panelPedirColor.setLayout(new BoxLayout(panelPedirColor, BoxLayout.X_AXIS));
		
		botonPedirColor = new JButton("Pedir Color (x5)\r\n");
		panelPedirColor.add(botonPedirColor);
		botonPedirColor.setPreferredSize(new Dimension(100, 22));
		
		botonPedirColor.setMinimumSize(new Dimension(10, 22));
		botonPedirColor.setMaximumSize(new Dimension(999, 50));
		botonPedirColor.setBackground(new Color(255, 204, 0));
		
		panelBarajarPila = new JPanel();
		panelBarajarPila.setMaximumSize(new Dimension(32767, 50));
		panelBotones.add(panelBarajarPila);
		panelBarajarPila.setMinimumSize(new Dimension(10, 22));
		panelBarajarPila.setLayout(new BoxLayout(panelBarajarPila, BoxLayout.X_AXIS));
		
		botonBarajarPila = new JButton("Barajar Pila (x3)");
		panelBarajarPila.add(botonBarajarPila);
		botonBarajarPila.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonBarajarPila.setPreferredSize(new Dimension(100, 22));
		botonBarajarPila.setMinimumSize(new Dimension(10, 22));
		botonBarajarPila.setMaximumSize(new Dimension(999, 50));
		botonBarajarPila.setBackground(new Color(255, 204, 0));
		
		panelBorrarColor = new JPanel();
		panelBorrarColor.setMaximumSize(new Dimension(32767, 50));
		panelBotones.add(panelBorrarColor);
		panelBorrarColor.setMinimumSize(new Dimension(10, 22));
		panelBorrarColor.setLayout(new BoxLayout(panelBorrarColor, BoxLayout.X_AXIS));
		
		botonBorrarColor = new JButton("Borrar Color (x2)");
		panelBorrarColor.add(botonBorrarColor);
		botonBorrarColor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonBorrarColor.setPreferredSize(new Dimension(100, 22));
		botonBorrarColor.setMinimumSize(new Dimension(10, 22));
		botonBorrarColor.setMaximumSize(new Dimension(999, 50));
		botonBorrarColor.setBackground(new Color(255, 204, 0));
		
		mensaje = new JButton("");
		mensaje.setVisible(false);
		mensaje.setHorizontalAlignment(SwingConstants.CENTER);
		mensaje.setBorder(new LineBorder(new Color(255, 222, 173), 1, true));
		mensaje.setPreferredSize(new Dimension(40, 15));
		GridBagConstraints gbc_mensaje = new GridBagConstraints();
		gbc_mensaje.fill = GridBagConstraints.BOTH;
		gbc_mensaje.gridwidth = 12;
		gbc_mensaje.gridx = 1;
		gbc_mensaje.gridy = 7;
		getContentPane().add(mensaje, gbc_mensaje);
	}
	
}
