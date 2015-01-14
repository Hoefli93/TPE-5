
public class WärmetauscherFluss {
	
	/**
	 *
	 * @author 1331770
	 * @author 1320733
	 * @author 1312740
	 * 
	 */

	Kühlkreislauf kreislauf;
	Fluss fluss;
	
	/**
	 * Konstruktor 
	 *
	 * @param kreislauf,fluss
	 *            
	 */

	public WärmetauscherFluss(Kühlkreislauf kreislauf, Fluss fluss) {
		this.kreislauf = kreislauf;
		this.fluss = fluss;

	}

	/**
	 * wärmeTauschen,  tauscht die Wärme
	 *         
	 */
	
	public void wärmeTauschen() {

		int ergebnis = (kreislauf.getWasser(kreislauf.getZeigerB())
				.getTemperatur() + fluss.getTemperatur()) / 2;
		fluss.setTemperatur(ergebnis);
		kreislauf.getWasser(kreislauf.getZeigerB()).setTemperatur(ergebnis);

	}

}
