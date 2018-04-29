package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import modelo.Datos;

public class Retroceso implements ActionListener{

	private JPanel panelSeleccionarColor;
	 private JButton botonSeleccionarColor;
	 private Actualizador actualizador;
	
	public Retroceso(JPanel panelSeleccionarColor, JButton botonSeleccionarColor, Actualizador actualizador) {
		super();
		this.panelSeleccionarColor = panelSeleccionarColor;
		this.botonSeleccionarColor = botonSeleccionarColor;
		this.actualizador = actualizador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.panelSeleccionarColor.removeAll();
		this.panelSeleccionarColor.add(botonSeleccionarColor);
		this.actualizador.actualizar(panelSeleccionarColor);
	}

}
