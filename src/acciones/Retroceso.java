package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import modelo.Datos;

public class Retroceso implements ActionListener{

	private JPanel panelSeleccionarColor;
	 private JButton botonSeleccionarColor;
	 private JPanel panelPedirColor;
	 private JButton botonPedirColor;
	 private Actualizador actualizador;
	
	public Retroceso(JPanel panelSeleccionarColor, JButton botonSeleccionarColor, JPanel panelPedirColor, JButton botonPedirColor, Actualizador actualizador) {
		super();
		this.panelSeleccionarColor = panelSeleccionarColor;
		this.botonSeleccionarColor = botonSeleccionarColor;
		this.actualizador = actualizador;
		this.panelPedirColor = panelPedirColor;
		this.botonPedirColor = botonPedirColor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.panelSeleccionarColor.removeAll();
		this.panelPedirColor.removeAll();
		this.panelPedirColor.add(botonPedirColor);
		this.panelSeleccionarColor.add(botonSeleccionarColor);
		this.actualizador.actualizar(panelSeleccionarColor);
		this.actualizador.actualizar(panelPedirColor);
	}

}
