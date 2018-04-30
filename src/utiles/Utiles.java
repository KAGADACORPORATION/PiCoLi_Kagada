package utiles;

public class Utiles {
	public static int genNumeroRandom() {
		return (int) (Math.random() *5);
	}
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
		public static int numeroRandom01() {
			return (int) (Math.random() *2);
		}
}
