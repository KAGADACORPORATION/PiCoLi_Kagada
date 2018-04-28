package acciones;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;

import modelo.Colores;
import modelo.Datos;
import modelo.MemorizadorCola;
import utiles.Constantes;
import utiles.Utiles;
import vista.Casilla;

public class Seleccionador implements ActionListener{
 private JPanel panelSeleccionarColor;
 private JButton botonSeleccionarColor;
 private Datos datos;
 private Actualizador actualizador;
 
 
 
	public Seleccionador(JPanel panelSeleccionarColor, JButton botonSeleccionarColor, Datos datos, Actualizador actualizador) {
		super();
		this.panelSeleccionarColor = panelSeleccionarColor;
		this.botonSeleccionarColor = botonSeleccionarColor;
		this.datos = datos;
		this.actualizador = actualizador;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		panelSeleccionarColor.remove(botonSeleccionarColor);
		for (int i = 0; i < Constantes.PETICION_COLOR_MAX; i++) {
			Casilla casillaActual= new Casilla(obtenerColorValido().toString());
			panelSeleccionarColor.add(casillaActual);
			this.actualizador.actualizar();
		}
	}

	//METODOS
	private Colores obtenerColorValido() {
		Colores nuevoColor;
		do {
			nuevoColor = generarColor();
		} while (validarColor(this.datos.getHistorico(),nuevoColor));
		return nuevoColor;
	}



	private boolean validarColor(MemorizadorCola historico, Colores nuevoColor) {
		boolean retorno = true;
		for (int i = 0; i < historico.getTamanioMemoriaCola(); i++) {
			Colores color = historico.obtenerElementoPosicion(i);
			if (color.toString().equals(nuevoColor.toString())) {
				retorno=false;
			}
		}
		return retorno;
	}



	private Colores generarColor() {
		return Colores.getElement(Utiles.genNumeroRandom(0, Colores.getCantidadElementos()-1));
	}
}