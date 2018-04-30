package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JPanel;

import org.junit.Test;

import interfaces.Barajable;
import modelo.Colores;
import modelo.Datos;
import utiles.Constantes;
import utiles.Utiles;
import vista.Casilla;

public class Barajador implements ActionListener, Barajable {

	Datos datos;
	Actualizador actualizador;
	JPanel pilaUno;
	JPanel pilaDos;

	public Barajador(JPanel pilaUno, JPanel pilaDos, Datos datos, Actualizador actualizador) {
		super();
		this.datos = datos;
		this.actualizador = actualizador;
		this.pilaUno = pilaUno;
		this.pilaDos = pilaDos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.pilaUno.removeAll();
		this.pilaDos.removeAll();
		barajarColor(this.datos);
		for (int i = 0; i < this.datos.getPilaUno().getPila().size(); i++) {
			this.pilaUno.add(new Casilla(this.datos.getPilaUno().getPila().get(i).toString()));
		}
		for (int i = 0; i < this.datos.getPilaDos().getPila().size(); i++) {
			System.out.println(this.datos.getPilaDos().getPila().get(i).toString());
			this.pilaDos.add(new Casilla(this.datos.getPilaDos().getPila().get(i).toString()));
		}
		this.actualizador.actualizar(this.pilaUno);
		this.actualizador.actualizar(this.pilaDos);
	}

	private void addToPila(Object object, int numeroRandom, Datos datos) {
//		for (int i = 0; i < temporal.size(); i++) {
//			if (i % 2 == 0) {
//				datos.getPilaUno().enpilar((temporal.get(i)));
//			} else {
//				datos.getPilaDos().enpilar((temporal.get(i)));
//			}
//		}
		System.out.println(datos.getPilaDos().getPila().size());
		if (numeroRandom == 0) {
			if (datos.getPilaUno().getPila().size() < Constantes.TAMANO_PILA) {
				datos.getPilaUno().enpilar((Colores) object);
			} else
				datos.getPilaDos().enpilar((Colores) object);

		} else if (datos.getPilaDos().getPila().size() < Constantes.TAMANO_PILA) {
			datos.getPilaDos().enpilar((Colores) object);
		} else
			datos.getPilaUno().enpilar((Colores) object);
	}

	@Override
	public void barajarColor(Datos datos) {
		ArrayList temporal = new ArrayList();
		for (int i = 0; i < datos.getPilaUno().getPila().size(); i++) {
			temporal.add(datos.getPilaUno().getPila().get(i));
		}
		datos.getPilaUno().getPila().removeAllElements();
		
		for (int i = 0; i < datos.getPilaDos().getPila().size(); i++) {
			temporal.add(datos.getPilaDos().getPila().get(i));
		}
		datos.getPilaDos().getPila().removeAllElements();
		for (int i = 0; i < temporal.size(); i++) {
			addToPila(temporal.get(i), Utiles.numeroRandom01(), datos);
		}
		temporal.clear();
	}
}

