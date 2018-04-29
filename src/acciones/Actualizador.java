package acciones;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Actualizador {
	
  	public void actualizar (JPanel panel){
  		SwingUtilities.updateComponentTreeUI(panel);
  	}
}