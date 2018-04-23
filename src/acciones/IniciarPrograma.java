package acciones;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Iterator;

import interfaces.Iniciable;
import modelo.Cola;
import modelo.Colores;
import modelo.Lista;
import modelo.Pila;

public class IniciarPrograma extends Accion implements Iniciable {
	Cola cola;
	Pila pila;
	Lista lista;

	@Override
	public void iniciarPrograma() {
		cola = new Cola(new ArrayDeque<>());
		for (int i = 0; i < utiles.Constantes.TAMANO_COLA; i++) {
			int numero = genNumeroRandom();
			cola.cola.add(Colores.getElement(numero));
		}
		
		pila = new Pila();
		lista = new Lista();
	}

	private int genNumeroRandom() {
		return (int) (Math.random() * 5);
	}

	@Override
	public void mostrarCambios() {
		// TODO Auto-generated method stub

	}

}