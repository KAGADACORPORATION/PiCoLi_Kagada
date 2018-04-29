package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import org.junit.Test;

import interfaces.Barajable;
import modelo.Colores;
import modelo.Datos;
import utiles.Constantes;
import utiles.Utiles;

public class Barajador implements ActionListener, Barajable {

	Datos datos;
	Actualizador actualizador;
	
	public Barajador(Datos datos, Actualizador actualizador) {
		super();
		this.datos = datos;
		this.actualizador = actualizador;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		barajarColor(datos);
		System.out.println("Barajar");
	}

	private void addToPila(Stack temporal, int numeroRandom, Datos datos) {
		if (numeroRandom == 0) {
			if (datos.getPilaUno().getPila().size() < Constantes.TAMANO_PILA) {
				datos.getPilaUno().enpilar((Colores) temporal.pop());
			}else datos.getPilaDos().enpilar((Colores) temporal.pop());
			
		} else if (datos.getPilaDos().getPila().size() < Constantes.TAMANO_PILA) {
			datos.getPilaDos().enpilar((Colores) temporal.pop());
		}else datos.getPilaUno().enpilar((Colores) temporal.pop());
			
		
	}

	@Override
	public void barajarColor(Datos datos) {
		Stack temporal = new Stack();
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
	//TODO este metodo tiene que coger los datos de la pila de la logica y 
//	manejar pintar los JLabels en el lugar correspondiente
	@Override
	public void actualizar() {
			
	}
}