public class Kühlkreislauf {

	/**
	 *
	 * @author 1331770
	 * @author 1320733
	 * @author 1312740
	 * 
	 */
	private Wasserelement[] wasserkreislauf = new Wasserelement[12];
	private int zeigerA;
	private int zeigerB;

	/**
	 * Konstruktor
	 *
	 * @param temperatur
	 * 
	 */

	public Kühlkreislauf(int temperatur) {
		this.zeigerA = 0;
		this.zeigerB = 6;
		befüllen(temperatur);
	}

	/**
	 * befüllen, befüllt den Wasserkreislauf mit Wasserelementen
	 *
	 * @param temperatur
	 * 
	 */

	private void befüllen(int temperatur) {
		for (int i = 0; i < wasserkreislauf.length; i++) {
			wasserkreislauf[i] = new Wasserelement(temperatur);
		}
	}

	/**
	 * rotieren, lässt Wasserelemente im Kreislauf rotieren
	 * 
	 */

	public void rotieren() {
		if (this.zeigerA == 11) {
			this.zeigerA = 0;
		} else {
			zeigerA++;
		}

		if (this.zeigerB == 11) {
			this.zeigerB = 0;
		} else {
			zeigerB++;
		}
	}

	public int getZeigerA() {
		return this.zeigerA;
	}

	public int getZeigerB() {
		return this.zeigerB;
	}

	public Wasserelement getWasser(int position) {
		return this.wasserkreislauf[position];
	}
}
