package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import control.Logica;
import interfaces.Barajable;
import modelo.Colores;
import modelo.Datos;
import utiles.Constantes;
import utiles.Utiles;
import vista.Casilla;

public class Barajador implements ActionListener {

	private Actualizador actualizador;
	private Logica logica;

	public Barajador(Actualizador actualizador, Logica logica) {
		super();
		this.actualizador = actualizador;
		this.logica = logica;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		logica.barajarColor();
		actualizador.actualizar();
	}

}
