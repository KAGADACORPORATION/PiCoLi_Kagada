package control;

import acciones.Barajador;
import acciones.Borrador;
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

	public Puente() {
		super();
		Iniciador iniciador = new Iniciador();
		datos = iniciador.crearDatos();
		this.vistaPrincipal = new VistaPrincipal();
		this.logica = new Logica();
		
		this.seleccionarColor = new Seleccionador(this.panelSeleccionarColor, this.botonSeleccionarColor,this.datos);
		this.barajarPila = new Barajador(this.datos);
		this.borrarColor= new Borrador(this.datos);
		this.pedirColor= new Pedidor(this.panelSeleccionarColor, this.botonSeleccionarColor,this.datos);
		
		this.botonSeleccionarColor.addActionListener(seleccionarColor);
		this.botonPedirColor.addActionListener(pedirColor);
		this.botonBorrarColor.addActionListener(borrarColor);
		this.botonBarajarPila.addActionListener(barajarPila);
		
	

	}

}
