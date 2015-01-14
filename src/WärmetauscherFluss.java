
public class W�rmetauscherFluss {
	
	/**
	 *
	 * @author 1331770
	 * @author 1320733
	 * @author 1312740
	 * 
	 */

	K�hlkreislauf kreislauf;
	Fluss fluss;
	
	/**
	 * Konstruktor 
	 *
	 * @param kreislauf,fluss
	 *            
	 */

	public W�rmetauscherFluss(K�hlkreislauf kreislauf, Fluss fluss) {
		this.kreislauf = kreislauf;
		this.fluss = fluss;

	}

	/**
	 * w�rmeTauschen,  tauscht die W�rme
	 *         
	 */
	
	public void w�rmeTauschen() {

		int ergebnis = (kreislauf.getWasser(kreislauf.getZeigerB())
				.getTemperatur() + fluss.getTemperatur()) / 2;
		fluss.setTemperatur(ergebnis);
		kreislauf.getWasser(kreislauf.getZeigerB()).setTemperatur(ergebnis);

	}

}
