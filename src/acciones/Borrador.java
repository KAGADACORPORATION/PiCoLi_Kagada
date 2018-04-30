package acciones;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import control.Logica;
import interfaces.Borrable;
import modelo.Colores;
import modelo.Datos;
import utiles.Constantes;
import vista.Casilla;
import vista.VistaPrincipal;

public class Borrador implements ActionListener, Borrable {

	JPanel lista;
	JButton botonBorrarColor;
	JPanel panelBorrarColor;
	Logica logica;
	Datos datos;
	Actualizador actualizador;
	Encolador encolador;
	private Retroceso retroceso;
	private JButton botonRetroceder;

	public Borrador(JPanel lista, JButton botonBorrarColor, JPanel panelBorrarColor, Logica logica, Datos datos,
			Actualizador actualizador, Encolador encolador, Retroceso retroceso) {
		super();
		this.lista = lista;
		this.botonBorrarColor = botonBorrarColor;
		this.panelBorrarColor = panelBorrarColor;
		this.logica = logica;
		this.datos = datos;
		this.actualizador = actualizador;
		this.encolador = encolador;
		this.retroceso = retroceso;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.panelBorrarColor.remove(botonBorrarColor);
		this.logica.generarSeleccion();
		for (int i = 0; i < Colores.getCantidadElementos(); i++) {
			Casilla casillaActual = new Casilla(Colores.getElement(i).toString());
			casillaActual.addActionListener(encolador);
			this.panelBorrarColor.add(casillaActual);
		}
		this.botonRetroceder = new JButton(" ");
		this.botonRetroceder.setMaximumSize(new Dimension(222, 222));
		this.botonRetroceder.setMargin(new Insets(0, 0, 0, 0));
		this.botonRetroceder.setIcon(
				new ImageIcon(VistaPrincipal.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		this.botonRetroceder.addActionListener(retroceso);
		this.panelBorrarColor.add(this.botonRetroceder);
		// Casilla etiquetaActual = ((Casilla) e.getSource());
		// borrarColor(etiquetaActual.getColor(), this.datos);
		this.actualizador.actualizar(lista);
	}

	// QUEDA PENDIENTE DE LA LISTA
	@Override
	public void borrarColor(String color, Datos datos) {
		for (int i = 0; i < datos.getLista().getLista().size(); i++) {
			datos.getLista().getLista().remove(color);
		}
	}
	// TODO este metodo tiene que coger los datos de la lista de la logica y
	// manejar pintar los JLabels en el lugar correspondiente
}