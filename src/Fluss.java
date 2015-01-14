
public class Fluss extends Temperatur {

	/**
	 *
	 * @author 1331770
	 * @author 1320733
	 * @author 1312740
	 * 
	 */
	private Leitware leitware;

	/**
	 * Konstruktor
	 *
	 * @param temperatur
	 *            , leitware
	 * 
	 */

	public Fluss(int temperatur, Leitware leitware) {
		super(temperatur);
		this.leitware = leitware;

	}

	@Override
	public int getTemperatur() {
		return 10;
	}

	@Override
	public void setTemperatur(int temp) {

	}

}
