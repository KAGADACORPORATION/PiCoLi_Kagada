package acciones;

import vista.VistaPrincipal;

public class Actualizador {
	VistaPrincipal vistaPrincipal;
  public Actualizador(VistaPrincipal vistaPrincipal) {
	  this.vistaPrincipal = vistaPrincipal;
  }
  	public void actualizar (){
  	  this.vistaPrincipal.revalidate();
  	}
}