
public abstract class Temperatur {

	private volatile int temperatur;

	public Temperatur(int temperatur) {
		this.temperatur = temperatur;
	}

	public int getTemperatur() {
		return temperatur;
	}

	public void setTemperature(int temperatur) {
		this.temperatur = temperatur;
	}

}