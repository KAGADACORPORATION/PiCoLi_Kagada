package acciones;

import java.util.Iterator;

import javax.swing.JPanel;

import control.Logica;
import interfaces.Iniciable;
import modelo.Cola;
import modelo.Colores;
import modelo.Datos;
import modelo.Lista;
import modelo.Pila;
import utiles.Constantes;
import utiles.Utiles;
import vista.Casilla;

public class Iniciador implements Iniciable{
	private Datos datos;
	private Logica logica;
	private JPanel cola;
	
	public Iniciador(JPanel cola) {
		super();
		this.datos = new Datos();
		this.logica = new Logica(this.datos);
		this.logica.iniciarCola();
		this.cola = cola;
	}

	@Override
	public void iniciarColaVista() {
		//TODO generar JLabels segun la cola de la logica
	}

	public Datos crearDatos() {
		return this.datos;
	}

	public Logica crearLogica() {
		return this.logica;
	}

}