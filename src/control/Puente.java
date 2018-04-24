package control;

import acciones.BarajarPila;
import acciones.BorrarColor;
import acciones.IniciarPrograma;
import acciones.PedirColor;
import acciones.SeleccionarColor;
import modelo.Datos;
import vista.VistaPrincipal;

public class Puente extends VistaPrincipal {
	private VistaPrincipal vistaPrincipal;
	private SeleccionarColor seleccionarColor;
	private PedirColor pedirColor;
	private Logica logica;
	private BarajarPila barajarPila;
	private BorrarColor borrarColor;
	private Datos datos;

	public Puente() {
		super();
		IniciarPrograma iniciador = new IniciarPrograma();
		datos = iniciador.crearDatos();
		this.vistaPrincipal = new VistaPrincipal();
		this.logica = new Logica();
		
		this.seleccionarColor = new SeleccionarColor(this.panelSeleccionarColor, this.botonSeleccionarColor,this.datos);
		this.barajarPila = new BarajarColor(this.datos);
		this.borrarColor= new BorrarColor(this.datos);
		this.pedirColor= new PedirColor(this.panelSeleccionarColor, this.botonSeleccionarColor,this.datos);
		
		this.botonSeleccionarColor.addActionListener(seleccionarColor);
		this.botonPedirColor.addActionListener(pedirColor);
		this.botonBorrarColor.addActionListener(borrarColor);
		this.botonBarajarPila.addActionListener(barajarPila);
		
	

	}

}
