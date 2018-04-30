package acciones;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import control.Logica;
import modelo.Colores;
import modelo.Datos;
import modelo.MemorizadorCola;
import utiles.Constantes;
import utiles.Utiles;
import vista.Casilla;
import vista.VistaPrincipal;

public class Seleccionador implements ActionListener{
 private JPanel panelSeleccionarColor;
 private JButton botonSeleccionarColor;
 private Actualizador actualizador;
 private JButton botonRetroceder;
 private Retroceso retroceso;
 private Encolador encolador;
 private Logica logica;
 
	public Seleccionador(JPanel panelSeleccionarColor, JButton botonSeleccionarColor, Logica logica, Actualizador actualizador,Encolador encolador) {
		super();
		this.panelSeleccionarColor = panelSeleccionarColor;
		this.botonSeleccionarColor = botonSeleccionarColor;
		this.actualizador = actualizador;
		this.retroceso = new Retroceso(this.panelSeleccionarColor,this.botonSeleccionarColor,this.actualizador);
		this.encolador = encolador;
		this.logica = logica;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		this.panelSeleccionarColor.remove(botonSeleccionarColor);
		this.logica.generarSeleccion();
		for (int i = 0; i < Constantes.PETICION_COLOR_MAX; i++) {
			Casilla casillaActual= new Casilla(this.logica.getDatos().getMemoriaSeleccionador().get(i).toString());
			casillaActual.addActionListener(encolador);
			this.panelSeleccionarColor.add(casillaActual);
		}
		this.botonRetroceder = new JButton(" ");
		this.botonRetroceder.setMaximumSize(new Dimension(222, 222));
		this.botonRetroceder.setMargin(new Insets(0, 0, 0, 0));
		this.botonRetroceder.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		this.botonRetroceder.addActionListener(retroceso);
		this.panelSeleccionarColor.add(this.botonRetroceder);
		this.actualizador.actualizar(this.panelSeleccionarColor);
	}

	//METODOS
	

	
}