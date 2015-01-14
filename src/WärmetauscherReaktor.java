
public class WärmetauscherReaktor {
	
	/**
	 *
	 * @author 1331770
	 * @author 1320733
	 * @author 1312740
	 * 
	 */

	Kühlkreislauf kreislauf;
	Reaktor reaktor;
	Leitware lw;
	
	/**
	 * Konstruktor 
	 *
	 * @param kreislauf,reaktor,lw
	 *            
	 */

	public WärmetauscherReaktor(Kühlkreislauf kreislauf, Reaktor reaktor,Leitware lw) {

		this.kreislauf = kreislauf;
		this.reaktor = reaktor;
		this.lw = lw;
	}

	/**
	 * wärmeTauschen,  tauscht die Wärme
	 *         
	 */
	
	public void wärmeTauschen() {

		int ergebnis = (kreislauf.getWasser(kreislauf.getZeigerA()).getTemperatur() + reaktor.getTemperatur()) / 2;
		reaktor.setTemperatur(ergebnis);
		kreislauf.getWasser(kreislauf.getZeigerA()).setTemperatur(ergebnis);
		lw.flussTempAustausch(ergebnis);
	}
}