package interfaces;

import modelo.Datos;

public interface Borrable {

  /**
   * Borra el color que le llega por parametros de la lista	
   * (solo visualmente) es la logica la que se encarga de borrar
   * este metodo en la accion solo actualiza la vista de la lista 
   * basandose en la lista que hay en el enum
   * @param Color enum Colores valor del elemento en String
   */
  public void borrarColor(String Color);

}