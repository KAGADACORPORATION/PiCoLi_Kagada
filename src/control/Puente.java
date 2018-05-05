package control;

import acciones.Actualizador;
import acciones.Barajador;
import acciones.Borrador;
import acciones.Encolador;
import acciones.Iniciador;
import acciones.ListenerBorrar;
import acciones.ListenerMensaje;
import acciones.Pedidor;
import acciones.Retroceso;
import acciones.Seleccionador;
import modelo.Datos;
import vista.VistaPrincipal;

public class Puente extends VistaPrincipal {
	private Seleccionador seleccionarColor;
	private Pedidor pedirColor;
	private Logica logica;
	private Barajador barajarPila;
	private Borrador borrarColor;
	private Actualizador actualizador;
	private Encolador encolador;
	private Retroceso retroceso;
	private ListenerBorrar listenerBorrar;
	private ListenerMensaje listenerMensaje;
	
	public Puente() {
		super();
		Iniciador iniciador = new Iniciador(this.cola);
		this.logica = iniciador.crearLogica();
		this.actualizador = new Actualizador(logica, cola, pilaUno, pilaDos, lista, puntosMonedas, botonPedirColor, botonSeleccionarColor, botonBorrarColor, botonBarajarPila,this.puntuacionMaxima);
		this.retroceso = new Retroceso(this.panelSeleccionarColor, this.botonSeleccionarColor,this.panelPedirColor,this.botonPedirColor,this.botonBorrarColor,this.panelBorrarColor, actualizador);
		this.encolador = new Encolador(this.logica,this.actualizador,this.botonSeleccionarColor,this.panelSeleccionarColor,this.botonPedirColor,this.panelPedirColor,this.mensaje,this.panelBotones);
		this.seleccionarColor = new Seleccionador(this.panelSeleccionarColor, this.botonSeleccionarColor,this.logica,this.actualizador,this.encolador,this.retroceso);
		this.botonSeleccionarColor.addActionListener(seleccionarColor);
		this.pedirColor= new Pedidor(this.panelPedirColor, this.botonPedirColor,this.actualizador,this.encolador,this.retroceso);
		this.botonPedirColor.addActionListener(pedirColor);
		this.listenerBorrar = new ListenerBorrar(logica, actualizador, botonSeleccionarColor, botonBorrarColor, panelBorrarColor);
		this.borrarColor=new Borrador(panelBorrarColor, botonBorrarColor, actualizador,retroceso, listenerBorrar, logica,this.mensaje);
		this.botonBorrarColor.addActionListener(this.borrarColor);
		this.barajarPila= new Barajador(this.actualizador,this.logica);
		this.botonBarajarPila.addActionListener(barajarPila);
		this.listenerMensaje = new ListenerMensaje(this.logica,this.actualizador,this.panelBotones,this.mensaje);
		this.mensaje.addActionListener(listenerMensaje);
		}

}
