package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import control.Logica;
import vista.Casilla;

public class ListenerBorrar implements ActionListener {

	private Logica logica;
	private Actualizador actualizador;
	private JButton botonBorrarColor;
	private JPanel panelBorrarColor;

	public ListenerBorrar(Logica logica, Actualizador actualizador, JButton botonSeleccionarColor,
		 JButton botonBorrarColor, JPanel panelBorrarColor) {
		super();
		this.logica = logica;
		this.actualizador = actualizador;
		this.botonBorrarColor = botonBorrarColor;
		this.panelBorrarColor = panelBorrarColor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Casilla etiquetaActual = ((Casilla) e.getSource());
		logica.borrarColor(etiquetaActual.getColor());
		this.panelBorrarColor.removeAll();
		this.panelBorrarColor.add(botonBorrarColor);
		actualizador.actualizar();
	}
}
