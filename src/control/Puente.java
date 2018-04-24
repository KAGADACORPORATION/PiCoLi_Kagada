package control;

<<<<<<< HEAD
import acciones.Actualizador;
import acciones.BarajarPila;
import acciones.BorrarColor;
import acciones.IniciarPrograma;
import acciones.PedirColor;
import acciones.SeleccionarColor;
=======
import acciones.Barajador;
import acciones.Borrador;
import acciones.Iniciador;
import acciones.Pedidor;
import acciones.Seleccionador;
>>>>>>> branch 'master' of https://github.com/juanantoniot10/PiCoLi_Kagada.git
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
	
	public Puente() {
		super();
		Iniciador iniciador = new Iniciador();
		datos = iniciador.crearDatos();
		this.vistaPrincipal = new VistaPrincipal();
		this.logica = new Logica();
		this.actualizador = actualizador;
		
<<<<<<< HEAD
		this.seleccionarColor = new SeleccionarColor(this.panelSeleccionarColor, this.botonSeleccionarColor,this.datos);
		this.barajarPila = new BarajarPila(this.datos,this.actualizador);
		this.borrarColor= new BorrarColor(this.datos,this.actualizador);
		this.pedirColor= new PedirColor(this.panelSeleccionarColor, this.botonSeleccionarColor,this.datos,this.actualizador);
=======
		this.seleccionarColor = new Seleccionador(this.panelSeleccionarColor, this.botonSeleccionarColor,this.datos);
		this.barajarPila = new Barajador(this.datos);
		this.borrarColor= new Borrador(this.datos);
		this.pedirColor= new Pedidor(this.panelSeleccionarColor, this.botonSeleccionarColor,this.datos);
>>>>>>> branch 'master' of https://github.com/juanantoniot10/PiCoLi_Kagada.git
		
		this.botonSeleccionarColor.addActionListener(seleccionarColor);
		this.botonPedirColor.addActionListener(pedirColor);
		this.botonBorrarColor.addActionListener(borrarColor);
		this.botonBarajarPila.addActionListener(barajarPila);
		
	

	}

}
