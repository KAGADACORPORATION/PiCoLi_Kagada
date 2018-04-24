package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import org.junit.Test;

import interfaces.Barajable;
import modelo.Datos;
import utiles.Constantes;
import utiles.Utiles;

public class Barajador implements ActionListener, Barajable {

	Datos datos;
	
	public Barajador(Datos datos) {
		super();
		this.datos = datos;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		barajarColor(datos);
	}

	private void addToPila(Stack temporal, int numeroRandom, Datos datos) {
		if (numeroRandom == 0) {
			if (datos.pilaUno.getPila().size() < Constantes.TAMANO_PILA) {
				datos.pilaUno.getPila().add(temporal.pop());
			}else datos.pilaDos.getPila().add(temporal.pop());
			
		} else if (datos.pilaDos.getPila().size() < Constantes.TAMANO_PILA) {
			datos.pilaDos.getPila().add(temporal.pop());
		}else datos.pilaUno.getPila().add(temporal.pop());
			
		
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