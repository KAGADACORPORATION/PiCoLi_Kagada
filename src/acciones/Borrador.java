package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interfaces.Borrable;
import modelo.Datos;
import vista.Casilla;

public class Borrador implements ActionListener,Borrable {

	Actualizador actualizador;
	Datos datos;
	public Borrador(Datos datos, Actualizador actualizador) {
		super();
		this.datos = datos;
		this.actualizador = actualizador;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Casilla etiquetaActual = ((Casilla)e.getSource());
		borrarColor(etiquetaActual.getColor(),datos);
	}
	//QUEDA PENDIENTE DE LA LISTA
	@Override
	public void borrarColor(String color,Datos datos) {
		for (int i = 0; i < datos.getLista().getLista().size(); i++) {
			datos.getLista().getLista().remove(color);
		}
	}
	//TODO este metodo tiene que coger los datos de la lista de la logica y 
//	manejar pintar los JLabels en el lugar correspondiente
	@Override
	public void actualizar() {
	}
}