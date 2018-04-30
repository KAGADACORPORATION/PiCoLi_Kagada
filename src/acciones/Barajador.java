package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
			this.pilaUno.add(new Casilla(datos.getPilaUno().desenpilar().toString()));
		}
		for (int i = 0; i < this.datos.getPilaDos().getPila().size(); i++) {
			this.pilaDos.add(new Casilla(datos.getPilaDos().desenpilar().toString()));
		}
		System.out.println(this.datos.getPilaUno().getPila().size()+""+this.datos.getPilaDos().getPila().size());
		this.actualizador.actualizar(this.pilaUno);
		this.actualizador.actualizar(this.pilaUno);
	}

	private void addToPila(Stack<Colores> temporal, int numeroRandom, Datos datos) {
//		for (int i = 0; i < temporal.size(); i++) {
//			if (i % 2 == 0) {
//				datos.getPilaUno().enpilar((temporal.get(i)));
//			} else {
//				datos.getPilaDos().enpilar((temporal.get(i)));
//			}
//		}
		if (numeroRandom == 0) {
			if (this.datos.getPilaUno().getPila().size() < Constantes.TAMANO_PILA) {
				this.datos.getPilaUno().enpilar((Colores) temporal.pop());
			} else
				this.datos.getPilaDos().enpilar((Colores) temporal.pop());

		} else if (this.datos.getPilaDos().getPila().size() < Constantes.TAMANO_PILA) {
			this.datos.getPilaDos().enpilar((Colores) temporal.pop());
		} else
			this.datos.getPilaUno().enpilar((Colores) temporal.pop());
	}

	@Override
	public void barajarColor(Datos datos) {
		Stack temporal = new Stack();
		for (int i = 0; i < datos.getPilaUno().getPila().size(); i++) {
			temporal.add(this.datos.getPilaUno().getPila().pop());
		}
		for (int i = 0; i < datos.getPilaDos().getPila().size(); i++) {
			temporal.add(this.datos.getPilaDos().getPila().pop());
		}
		for (int i = 0; i < temporal.size(); i++) {
			addToPila(temporal, Utiles.numeroRandom01(), this.datos);
		}

	}
}

