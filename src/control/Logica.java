package control;
import java.util.Vector;

import modelo.Colores;
import modelo.Datos;
import utiles.Constantes;
import utiles.Utiles;

public class Logica implements InterfazLogica {

    private Datos datos;
    private int monedas=0;
    
    
    
	public Logica(Datos datos) {
		super();
		this.datos = datos;
	}
	@Override
	public boolean comprobarGanador() {
		if (monedas>=Constantes.CANTIDAD_MAX_MONEDAS) {
			return true;
		}
		return false;
	}
	@Override
	public void disminuirIntentos() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void incrementarMonedas(int monedas) {
		this.monedas++;
	}
	
	public Datos getDatos() {
		return this.datos;
	}

	public int getMonedas() {
		return this.monedas;
	}
	
	public void iniciarCola() {
		for (int i = 0; i < Constantes.TAMANO_COLA; i++) {
			int numero = Utiles.genNumeroRandom(0,Colores.getCantidadElementos()-1);
			datos.getCola().encolar(Colores.getElement(numero));
		}
	}
	
	private void anadirColorMemoriaSeleccionador(Colores color) {
		this.datos.getMemoriaSeleccionador().add(color);
	}
	
	private Colores obtenerColorValido() {
		Colores nuevoColor;
		do {
			nuevoColor = generarColor();
		} while (!this.validarColor(nuevoColor));
		return nuevoColor;
	}
	
	private Colores generarColor() {
		return Colores.getElement(Utiles.genNumeroRandom(0, Colores.getCantidadElementos()-1));
	}
	
	private boolean validarColor(Colores nuevoColor) {
		boolean retorno = true;
		int contador = 0;
		for (int i = 0; i < datos.getCola().getHistorico().getTamanioMemoriaCola(); i++) {
			Colores color = datos.getCola().getHistorico().obtenerElementoPosicion(i);
			if (color.toString().equals(nuevoColor.toString())) {
				contador++;
			}
		}
		if(contador==2)retorno=false;
		for (int i = 0; i < this.datos.getMemoriaSeleccionador().size(); i++) {
			if(nuevoColor.toString().equals(this.datos.getMemoriaSeleccionador().get(i).toString())) {
				retorno = false;
			}
		}
		return retorno;
	}
	
	public void generarSeleccion() {
		if(this.datos.getMemoriaSeleccionador().isEmpty()) {
			for (int i = 0; i < Constantes.CANTIDAD_COLORES_SELECCION; i++) {
				this.datos.getMemoriaSeleccionador().add(obtenerColorValido());
			}
		}
	}
	
	private void empilar(Colores color) {
		if(Utiles.genNumeroRandom(0, 1)==1)this.datos.getPilaUno().enpilar(color);
		else this.datos.getPilaDos().enpilar(color);
	}
	
	public void encolar(Colores color) {
		this.datos.encolar(color);
		this.datos.getMemoriaSeleccionador().clear();
		this.empilar(desencolar());
	}
	public Colores desencolar() {
		return datos.desencolar();
	}
	public void borrarSeleccion() {
		if(this.datos.getMemoriaSeleccionador().isEmpty()) {
			for (int i = 0; i < Constantes.CANTIDAD_COLORES_SELECCION; i++) {
				this.datos.getMemoriaSeleccionador().add(obtenerColorValido());
			}
		}
	}
}