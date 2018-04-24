package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import modelo.Datos;
import utiles.Constantes;
import vista.Casilla;

public class SeleccionarColor implements ActionListener{
 private JPanel panelSeleccionarColor;
 private JButton botonSeleccionarColor;
 private Datos datos;
 
 
 
	public SeleccionarColor(JPanel panelSeleccionarColor, JButton botonSeleccionarColor, Datos datos) {
	super();
	this.panelSeleccionarColor = panelSeleccionarColor;
	this.botonSeleccionarColor = botonSeleccionarColor;
	this.datos = datos;
}



	@Override
	public void actionPerformed(ActionEvent e) {
	panelSeleccionarColor.remove(botonSeleccionarColor);
	for (int i = 0; i < Constantes.PETICION_COLOR_MAX; i++) {
		Casilla casillaActual= new Casilla(obtenerColorValido());
		panelSeleccionarColor.add(casillaActual);
	}
	
	}

	//METODOS
	private String obtenerColorValido() {
		// TODO Auto-generated method stub
		return null;
	}
}