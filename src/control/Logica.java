package control;

import java.util.ArrayList;

import modelo.Colores;
import modelo.Datos;
import utiles.Constantes;
import utiles.Utiles;

public class Logica {

	private Datos datos;
	private int monedas = 0;
	private boolean ganador;
	private boolean perdedor;
	private int pedirColor;
	private int borrarColor;
	private int barajarPila;
	private int puntuacionMaxima=0;

	public Logica(Datos datos) {
		super();
		this.datos = datos;
		this.ganador = false;
		this.perdedor = false;
		this.pedirColor = 5;
		this.barajarPila = 3;
		this.borrarColor = 2;
		this.puntuacionMaxima = calcularPuntuacionMaxima(monedas);
	}
	
	private int calcularPuntuacionMaxima(int monedas) {
		if(monedas>=puntuacionMaxima)return monedas;
		else return 0;
	}

	/**
	 * metodo recursivo que me ha salido de potra, borra el color pasado por
	 * parametro y comprueba las parejas cada vez que borra un color ole ole
	 * 
	 * @param color
	 *            enum tipo Colores valor en String
	 */
	public void borrarColor(String color) {
		for (int i = 0; i < datos.getLista().getLista().size(); i++) {
			if (this.datos.getLista().getLista().get(i).equals(Colores.valueOf(color))) {
				this.datos.getLista().getLista().remove(i);
				this.monedas++;
				borrarColor(color);
				i--;
			}
		}
		comprobarParejaEnLista();
	}

	public void barajarColor() {
		barajarPila--;
		ArrayList<Colores> temporal = new ArrayList<Colores>();
		temporal.addAll(datos.getPilaUno().getPila());
		temporal.addAll(datos.getPilaDos().getPila());
		datos.getPilaUno().getPila().clear();
		datos.getPilaDos().getPila().clear();
		for (int i = 0; i < temporal.size(); i++) {
			Colores color = temporal.get(i);
			empilar(color);
		}
	}

	private void comprobarGanador() {
		if (monedas >= Constantes.CANTIDAD_MAX_MONEDAS) {
			this.ganador = true;
		}
	}

	private void comprobarPerdedor() {
		if (datos.getLista().getLista().size()>=Constantes.CANTIDAD_MAX_MONEDAS &&
				this.borrarColor == 0){
			this.perdedor = true;
		}
	}
	
	public void iniciarCola() {
		for (int i = 0; i < Constantes.TAMANO_COLA; i++) {
			int numero = Utiles.genNumeroRandom(0, Colores.getCantidadElementos() - 1);
			datos.getCola().encolar(Colores.getElement(numero));
		}
	}

	private Colores obtenerColorValido() {
		Colores nuevoColor;
		do {
			nuevoColor = generarColor();
		} while (!this.validarColor(nuevoColor));
		return nuevoColor;
	}

	private Colores generarColor() {
		return Colores.getElement(Utiles.genNumeroRandom(0, Colores.getCantidadElementos() - 1));
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
		if (contador == 2)
			retorno = false;
		for (int i = 0; i < this.datos.getMemoriaSeleccionador().size(); i++) {
			if (nuevoColor.toString().equals(this.datos.getMemoriaSeleccionador().get(i).toString())) {
				retorno = false;
			}
		}
		return retorno;
	}

	public void generarSeleccion() {
		if (this.datos.getMemoriaSeleccionador().isEmpty()) {
			for (int i = 0; i < Constantes.CANTIDAD_COLORES_SELECCION; i++) {
				this.datos.getMemoriaSeleccionador().add(obtenerColorValido());
			}
		}
	}

	public void comprobarParejaEnLista() {
		boolean salida = false;
		Colores colorEncontrado = null;
		do {
			if (this.datos.getLista().getLista().size() > 1) {
				for (int i = 0; i < this.datos.getLista().getLista().size() - 1; i++) {
					Colores colorActual = this.datos.getLista().getLista().get(i);
					if (colorEncontrado == null) {
						if (this.datos.getLista().getLista().get(i + 1).equals(colorActual)) {
							colorEncontrado = Colores.valueOf(colorActual.toString());
							salida = false;
							this.datos.getLista().getLista().remove(i);
							this.datos.getLista().getLista().remove(i);
							this.monedas += 2;
						}
					}
				}
			}
		} while (salida);
	}
	
	public void comprobarParejaEnListaRecursivo() {
		Colores colorEncontrado = null;
		if(this.datos.getLista().getLista().size()>1) {
			for (int i = 0; i < this.datos.getLista().getLista().size()-1; i++) {
				Colores colorActual = this.datos.getLista().getLista().get(i);
				if(this.datos.getLista().getLista().get(i+1).equals(colorActual)) {
					colorEncontrado = Colores.valueOf(colorActual.toString());
					this.datos.getLista().getLista().remove(i);
					if(colorEncontrado.equals(this.datos.getLista().getLista().get(i+1))) {
						this.datos.getLista().getLista().remove(i);
						this.datos.getLista().getLista().remove(i);
					}
					else this.datos.getLista().getLista().remove(i);
					this.monedas += 2;
					colorEncontrado = null;
					
				}
			}
		}
	}
	
	private void empilar(Colores color) {
		int sorteoPila = Utiles.genNumeroRandom(0, 1);
		if ( sorteoPila == 1) {
			if(this.datos.getPilaUno().getPila().size() < Constantes.TAMANO_PILA) {
				this.datos.getPilaUno().enpilar(color);
			}
			else if (this.datos.getPilaDos().getPila().size() < Constantes.TAMANO_PILA) {
				this.datos.getPilaDos().enpilar(color);
			}
			else {
				this.datos.getLista().enlistar(this.datos.getPilaUno().desenpilar());
				this.datos.getPilaUno().enpilar(color);
			}
		}
		if (sorteoPila == 0){
			if(this.datos.getPilaDos().getPila().size() < Constantes.TAMANO_PILA) {
				this.datos.getPilaDos().enpilar(color);
			}
			else if (this.datos.getPilaUno().getPila().size() < Constantes.TAMANO_PILA) {
				this.datos.getPilaUno().enpilar(color);
			}
			else {
				this.datos.getLista().enlistar(this.datos.getPilaDos().desenpilar());
				this.datos.getPilaDos().enpilar(color);
			}
		}
	}

	public boolean comprobarEspacioEnLista() {
		if(this.datos.getLista().getLista().size()<Constantes.CANTIDAD_MAX_MONEDAS) {
			return true;
		}
		else return false;
	}
	
	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}

	public void setPuntuacionMaxima(int puntuacionMaxima) {
		this.puntuacionMaxima = puntuacionMaxima;
	}

	public int getPuntuacionMaxima() {
		return puntuacionMaxima;
	}

	public void encolar(Colores color,boolean pedirColor) {

		this.datos.encolar(color);
		borrarSeleccion();
		this.empilar(desencolar());
		this.comprobarParejaEnLista();
		this.comprobarGanador();
		this.comprobarPerdedor();
		if(pedirColor)this.pedirColor--;

	}

	public Colores desencolar() {
		return datos.desencolar();
	}

	private void borrarSeleccion() {
		if (!this.datos.getMemoriaSeleccionador().isEmpty()) {
			this.datos.getMemoriaSeleccionador().clear();
		}
	}

	public boolean isGanador() {
		return ganador;
	}

	public boolean isPerdedor() {
		return perdedor;
	}

	public Datos getDatos() {
		return this.datos;
	}

	public int getMonedas() {
		return this.monedas;
	}

	public int getPedirColor() {
		return pedirColor;
	}

	public void setPedirColor(int pedirColor) {
		this.pedirColor = pedirColor;
	}

	public int getBorrarColor() {
		return borrarColor;
	}

	public void setBorrarColor(int borrarColor) {
		this.borrarColor = borrarColor;
	}

	public int getBarajarPila() {
		return barajarPila;
	}

	public void setBarajarPila(int barajarPila) {
		this.barajarPila = barajarPila;
	}

	public void setGanador(boolean ganador) {
		this.ganador = ganador;
	}

	public void setPerdedor(boolean perdedor) {
		this.perdedor = perdedor;
	}

	public void reiniciarLogica() {
		this.getDatos().getCola().getCola().clear();
		this.iniciarCola();
		this.getDatos().getPilaUno().getPila().clear();
		this.getDatos().getPilaDos().getPila().clear();
		this.getDatos().getLista().getLista().clear();
		this.setPuntuacionMaxima(calcularPuntuacionMaxima());
		this.setMonedas(0);
		this.setGanador(false);
		this.setPerdedor(false);
		this.setBorrarColor(Constantes.PETICION_BORRAR_MAX);
		this.setPedirColor(Constantes.PETICION_COLOR_MAX);
		this.setBarajarPila(Constantes.PETICION_BARAJAR_MAX);
	}
	
	private int calcularPuntuacionMaxima() {
		if(this.getMonedas()>=this.getPuntuacionMaxima())
		return this.getMonedas();
		else return this.getPuntuacionMaxima();
	}

}