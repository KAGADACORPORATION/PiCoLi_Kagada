package acciones;

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

public class IniciarPrograma implements Iniciable{
	private Cola<Casilla> cola;
	private Pila pila, pilaDos;
	private Lista lista;
	private Logica logica;
	
	@Override
	public void iniciarPrograma() {
		this.cola = new Cola<Casilla>();
		for (int i = 0; i < Constantes.TAMANO_COLA; i++) {
			int numero = Utiles.genNumeroRandom(0,Colores.getCantidadElementos()-1);
			this.cola.encolar(new Casilla(Colores.getElement(numero).toString()));
		}
		this.pila = new Pila();
		this.pilaDos = new Pila();
		this.lista = new Lista();
		
	}

	@Override
	public void mostrarCambios() {
		// TODO Auto-generated method stu
		
	}

	public Logica crearLogica() {
		logica=new Logica();
		return logica;
	}
	public Datos crearDatos() {
		Datos datos=new Datos(cola,lista,pila,pilaDos);
		return datos;
	}
}