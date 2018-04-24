package acciones;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.JLabel;
import interfaces.Borrable;
import modelo.Datos;
import vista.Casilla;

public class BorrarColor implements ActionListener, Borrable {
	Actualizador actualizador;
	Datos datos;
	public BorrarColor(Datos datos, Actualizador actualizador) {
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
		for (int i = 0; i < datos.lista.Lista.size(); i++) {
			datos.lista.Lista.remove(color);
			System.out.println(Integer.valueOf(datos.lista.Lista.size()));
		}
	}

	@Override
	public void actualizar() {
		this.actualizador.actualizar();
	}

}