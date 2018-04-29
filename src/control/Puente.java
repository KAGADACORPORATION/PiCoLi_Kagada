package control;

import acciones.Actualizador;
import acciones.Barajador;
import acciones.Borrador;
import acciones.Encolador;
import acciones.Iniciador;
import acciones.Pedidor;
import acciones.Seleccionador;
import modelo.Datos;
import vista.VistaPrincipal;

public class Puente extends VistaPrincipal {
	private VistaPrincipal vistaPrincipal;
	private Seleccionador seleccionarColor;
	private Pedidor pedirColor;
	private Logica logica;
	private Barajador barajarPila;
	private Borrador borrarColor;
	private Datos datos;
	private Actualizador actualizador;
	private Encolador encolador;
	
	public Puente() {
		super();
		Iniciador iniciador = new Iniciador(this.cola);
		this.datos = iniciador.crearDatos();
		this.vistaPrincipal = new VistaPrincipal();
		this.logica = iniciador.crearLogica();
		this.actualizador = new Actualizador();
		this.seleccionarColor = new Seleccionador(this.panelSeleccionarColor, this.botonSeleccionarColor,this.datos,this.actualizador,this.encolador);
		this.botonSeleccionarColor.addActionListener(seleccionarColor);
		this.pedirColor= new Pedidor(this.panelPedirColor, this.botonPedirColor, this.datos,this.actualizador);
		this.botonPedirColor.addActionListener(pedirColor);
		
		this.borrarColor=new Borrador(this.lista,this.datos, this.actualizador);
		this.botonBorrarColor.addActionListener(borrarColor);
		
		this.barajarPila= new Barajador(this.pilaUno,this.pilaDos,this.datos,this.actualizador);
		this.botonBarajarPila.addActionListener(barajarPila);
		}

}
