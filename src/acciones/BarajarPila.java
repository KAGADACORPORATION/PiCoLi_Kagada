package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import org.junit.Test;

import interfaces.Barajable;
import modelo.Datos;
import utiles.Utiles;

public class BarajarPila implements ActionListener, Barajable {

	Datos datos;
	// NO ESTA COMPLETO
	
	@Override
	public void actionPerformed(ActionEvent e) {
		barajarColor(datos);
	}

	private void addToPila(Stack temporal, int numeroRandom, Datos datos) {
		if (numeroRandom == 0 && datos.pilaUno.getPila().size() <= 5) {
			datos.pilaUno.getPila().add(temporal.pop());
		} else if (numeroRandom == 1 && datos.pilaDos.getPila().size() <= 5) {
			datos.pilaDos.getPila().add(temporal.pop());
		}
	}

	@Override
	public void barajarColor(Datos datos) {
		Stack temporal = new Stack();
		for (int i = 0; i < datos.pilaUno.getPila().size(); i++) {
			temporal.add(datos.pilaUno.getPila().pop());
		}
		for (int i = 0; i < datos.pilaDos.getPila().size(); i++) {
			temporal.add(datos.pilaDos.getPila().pop());
		}
		for (int i = 0; i < temporal.size(); i++) {
			addToPila(temporal, Utiles.numeroRandom01(), datos);
		}

	}
}