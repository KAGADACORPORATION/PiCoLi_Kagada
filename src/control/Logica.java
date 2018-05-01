package control;

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

	public Logica(Datos datos) {
		super();
		this.datos = datos;
		this.ganador = false;
		this.perdedor = false;
		this.pedirColor = 5;
		this.barajarPila = 3;
		this.borrarColor = 2;
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

	private void comprobarGanador() {
		if (monedas >= Constantes.CANTIDAD_MAX_MONEDAS) {
			this.ganador = true;
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

	private void empilar(Colores color) {
		if (Utiles.genNumeroRandom(0, 1) == 1) {
			this.datos.getPilaUno().enpilar(color);
			if (this.datos.getPilaUno().getPila().size() >= Constantes.TAMANO_PILA) {
				this.datos.getLista().enlistar(this.datos.getPilaUno().desenpilar());
			}
		} else {
			this.datos.getPilaDos().enpilar(color);
			if (this.datos.getPilaDos().getPila().size() >= Constantes.TAMANO_PILA) {
				this.datos.getLista().enlistar(this.datos.getPilaDos().desenpilar());
			}
		}
	}

	public void encolar(Colores color, boolean pedirColor) {
		this.datos.encolar(color);
		borrarSeleccion();
		this.empilar(desencolar());
		this.comprobarParejaEnLista();
		this.comprobarGanador();
		if (pedirColor)
			this.pedirColor--;
		this.comprobarPerdedor();
	}

	private void comprobarPerdedor() {
		if (this.datos.getLista().getLista().size()>=(Constantes.TAMANO_LISTA_ALTO*Constantes.TAMANO_LISTA_ANCHO)) {
			this.perdedor = true;
		}
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

}