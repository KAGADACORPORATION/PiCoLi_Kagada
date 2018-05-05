package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import control.Logica;
import modelo.Colores;
import vista.Casilla;

public class Encolador implements ActionListener{

	private Logica logica;
	private Actualizador actualizador;
	private JButton botonSeleccionarColor;
	private JPanel panelSeleccionarColor;
	private JButton botonPedirColor;
	private JPanel panelPedirColor;
	private JButton mensaje;
	private JPanel panelBotones;
	
	public Encolador(Logica logica,
			Actualizador actualizador, JButton botonSeleccionarColor,
			JPanel panelSeleccionarColor, JButton botonPedirColor, JPanel panelPedirColor, JButton mensaje, JPanel panelBotones) {
		super();
		this.logica = logica;
		this.actualizador = actualizador;
		this.botonSeleccionarColor = botonSeleccionarColor;
		this.panelSeleccionarColor = panelSeleccionarColor;
		this.panelPedirColor = panelPedirColor;
		this.botonPedirColor = botonPedirColor;
		this.mensaje = mensaje;
		this.panelBotones = panelBotones;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Casilla botonPulsado =((Casilla)e.getSource());
		boolean pedido = false;
		if(((JPanel)botonPulsado.getParent()).getComponentCount()==Colores.getCantidadElementos()+1) {
			pedido = true;
		}
		if(this.logica.comprobarEspacioEnLista()) {
			this.logica.encolar(Colores.valueOf(botonPulsado.getColor()),pedido);
			this.panelSeleccionarColor.removeAll();
			this.panelSeleccionarColor.add(botonSeleccionarColor);
			this.panelPedirColor.removeAll();
			this.panelPedirColor.add(botonPedirColor);
		}
		else {
			this.mensaje.setVisible(true);
			this.mensaje.setText("LA LISTA ESTA LLENA BORRAR COLOR");
		}
		if(logica.isGanador()) {
			this.mensaje.setVisible(true);
			this.mensaje.setText(String.valueOf("HAS GANADO       REINICIAR"));
			this.panelBotones.setVisible(false);
		}
		if(logica.isPerdedor()) {
			this.mensaje.setVisible(true);
			this.mensaje.setText(String.valueOf("HAS PERDIDO       REINICIAR"));
			this.panelBotones.setVisible(false);
		}
		actualizador.actualizar();
	}	
	
}
