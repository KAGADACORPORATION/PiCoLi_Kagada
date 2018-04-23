package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import org.junit.Test;

import interfaces.Barajable;
import modelo.Datos;
import utiles.Utiles;

public class BarajarColor implements ActionListener, Barajable {

	Datos datos;
	@Override
	public void actionPerformed(ActionEvent e) {
		barajarColor(datos);
	}

	private void addToPila(Stack temporal, int numeroRandom, Datos datos) {
		if (numeroRandom == 0 && datos.pilaUno.pila.size() <= 5) {
			datos.pilaUno.pila.add(temporal.pop());
		} else if (numeroRandom == 1 && datos.pilaDos.pila.size() <= 5) {
			datos.pilaDos.pila.add(temporal.pop());
		}
	}

	@Override
	public void barajarColor(Datos datos) {
		// NO ESTA COMPLETOo
		Stack temporal = new Stack();
		for (int i = 0; i < datos.pilaUno.pila.size(); i++) {
			temporal.add(datos.pilaUno.pila.pop());
		}
		for (int i = 0; i < datos.pilaDos.pila.size(); i++) {
			temporal.add(datos.pilaDos.pila.pop());
		}
		for (int i = 0; i < temporal.size(); i++) {
			addToPila(temporal, Utiles.numeroRandom01(), datos);
		}

	}
}