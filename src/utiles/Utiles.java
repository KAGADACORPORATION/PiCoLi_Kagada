package utiles;

public class Utiles {
	
		/**
		 * crea un numero random 
		 * @param min numero minimo
		 * @param max numero maximo
		 * @return int aleatorio entre min y max
		 */
		public static int genNumeroRandom(int min,int max) {
			int numeroAleatorio=((int)(Math.random()*((max-min)+1)))+min;
			return numeroAleatorio;
		}

}
