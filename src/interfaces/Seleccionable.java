package interfaces;

import modelo.Colores;
import modelo.Datos;

public interface Seleccionable {

  public void seleccionarColor(Datos datos, Colores colores);

  public void actualizar();

}