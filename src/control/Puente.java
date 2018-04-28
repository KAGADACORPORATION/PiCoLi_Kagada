package control;

import acciones.Actualizador;
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
	private Actualizador actualizador;
	
	public Puente() {
		super();
		Iniciador iniciador = new Iniciador(this.cola);
		this.datos = iniciador.crearDatos();
		this.vistaPrincipal = new VistaPrincipal();
		this.logica = iniciador.crearLogica();
		this.actualizador = new Actualizador(vistaPrincipal);
		this.seleccionarColor = new Seleccionador(this.panelSeleccionarColor, this.botonSeleccionarColor,this.datos,this.actualizador);
		this.botonSeleccionarColor.addActionListener(seleccionarColor);
//		this.pedirColor = new Pedidor(AQUI LOS PANELES QUE VAS A USAR MAS LOGICA ETC LO QUE NECESITES COMO EJEMPLO LA LINEA 29);
		this.botonPedirColor.addActionListener(pedirColor);
//		this.borrarColor = new Borrador(datos, actualizador, Y LO QUE NECESITES MAS)
		this.botonBorrarColor.addActionListener(borrarColor);
//		this.barajarPila = new Barajador(datos, actualizador, Y LO QUE NECESITES)
//		ADEMAS TENDRAS QUE ADAPTAR EL CONSTRUCTOR DE LAS ACCIONES PARA QUE RECOJAN ESTA INFORMACION
		this.botonBarajarPila.addActionListener(barajarPila);
		actualizador.actualizar();
	}

}
