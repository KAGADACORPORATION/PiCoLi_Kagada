package modelo;

import java.util.ArrayList;

public class Lista {

	private ArrayList<Colores> lista = new ArrayList<Colores>();

	public ArrayList<Colores> getLista() {
		return lista;
	}

	public void enlistar(Colores t) {
		lista.add(t);
	}

}