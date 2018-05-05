package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import control.Logica;
import modelo.Datos;
import utiles.Constantes;

public class ListenerMensaje implements ActionListener{

	private Logica logica;
	private Actualizador actualizador;
	private JPanel panelBotones;
	private JButton mensaje;
	
	public ListenerMensaje(Logica logica, Actualizador actualizador, JPanel panelBotones,JButton mensaje) {
		this.logica = logica;
		this.actualizador = actualizador;
		this.panelBotones = panelBotones;
		this.mensaje = mensaje;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.logica.reiniciarLogica();
		this.mensaje.setVisible(false);
		this.panelBotones.setVisible(true);
		this.actualizador.actualizar();
		this.actualizador.activarBotones();

	}


}
