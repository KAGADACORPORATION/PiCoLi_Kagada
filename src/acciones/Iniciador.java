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

public class Iniciador implements Iniciable{
	Datos datos;
	
	public Iniciador(Datos datos) {
		super();
		this.datos = datos;
	}

	@Override
	public void iniciarCola() {
		for (int i = 0; i < Constantes.TAMANO_COLA; i++) {
			int numero = Utiles.genNumeroRandom(0,Colores.getCantidadElementos()-1);
			datos.getCola().encolar(Colores.getElement(numero));
		}
	}

	@Override
	public void mostrarCambios() {
		// TODO Auto-generated method stu
		
	}

//	public Logica crearLogica() {
//		logica=new Logica();
//		return logica;
//	}
}