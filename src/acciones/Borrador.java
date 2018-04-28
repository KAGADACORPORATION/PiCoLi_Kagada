package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import interfaces.Borrable;
import modelo.Datos;
import vista.Casilla;

public class Borrador implements ActionListener,Borrable {

	Actualizador actualizador;
	Datos datos;
	JPanel lista;
	public Borrador(JPanel lista, Datos datos, Actualizador actualizador) {
		super();
		this.datos = datos;
		this.actualizador = actualizador;
		this.lista=lista;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Casilla etiquetaActual = ((Casilla)e.getSource());
		borrarColor(etiquetaActual.getColor(),datos);
		actualizar();
	}
	//QUEDA PENDIENTE DE LA LISTA
	@Override
	public void borrarColor(String color,Datos datos) {
		for (int i = 0; i < datos.getLista().getLista().size(); i++) {
			datos.getLista().getLista().remove(color);
		}
	}

	@Override
	public void actualizar() {
		this.actualizador.actualizar();
	}
}