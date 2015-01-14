
public abstract class Temperatur {
	
	/**
	 *
	 * @author 1331770
	 * @author 1320733
	 * @author 1312740
	 * 
	 */

	private volatile int temperatur;

	/**
	 * Konstruktor 
	 *
	 * @param temperatur
	 *            
	 */
	
	public Temperatur(int temperatur) {
		this.temperatur = temperatur;
	}

	public int getTemperatur() {
		return temperatur;
	}

	public void setTemperatur(int temperatur) {
		this.temperatur = temperatur;
	}

}