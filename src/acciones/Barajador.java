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
		barajarColor(this.datos);
		for (int i = 0; i < Constantes.TAMANO_PILA; i++) {
			this.pilaUno.remove(i);
			this.pilaDos.remove(i);
		}
		for (int i = 0; i < Constantes.TAMANO_PILA; i++) {
			this.pilaUno.add(new Casilla(datos.getPilaUno().desenpilar().toString()));
			this.pilaDos.remove(i);
		}
		this.actualizador.actualizar(this.pilaUno);
		this.actualizador.actualizar(this.pilaUno);
	}

	private void addToPila(Stack<Colores> temporal, int numeroRandom, Datos datos) {
		if (numeroRandom == 0) {
			if (datos.getPilaUno().getPila().size() < Constantes.TAMANO_PILA) {
				datos.getPilaUno().enpilar((Colores) temporal.pop());
			} else
				datos.getPilaDos().enpilar((Colores) temporal.pop());

		} else if (datos.getPilaDos().getPila().size() < Constantes.TAMANO_PILA) {
			datos.getPilaDos().enpilar((Colores) temporal.pop());
		} else
			datos.getPilaUno().enpilar((Colores) temporal.pop());

	}

	@Override
	public void barajarColor(Datos datos) {
		Stack<Colores> temporal = new Stack();
		for (int i = 0; i < datos.getPilaUno().getPila().size(); i++) {
			temporal.add(datos.getPilaUno().desenpilar());
		}
		for (int i = 0; i < datos.getPilaDos().getPila().size(); i++) {
			temporal.add(datos.getPilaDos().desenpilar());
		}
		for (int i = 0; i < temporal.size(); i++) {
			addToPila(temporal, Utiles.numeroRandom01(), datos);
		}

	}

