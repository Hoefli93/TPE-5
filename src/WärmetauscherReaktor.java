
public class W�rmetauscherReaktor {
	
	/**
	 *
	 * @author 1331770
	 * @author 1320733
	 * @author 1312740
	 * 
	 */

	K�hlkreislauf kreislauf;
	Reaktor reaktor;
	Leitware lw;
	
	/**
	 * Konstruktor 
	 *
	 * @param kreislauf,reaktor,lw
	 *            
	 */

	public W�rmetauscherReaktor(K�hlkreislauf kreislauf, Reaktor reaktor,Leitware lw) {

		this.kreislauf = kreislauf;
		this.reaktor = reaktor;
		this.lw = lw;
	}

	/**
	 * w�rmeTauschen,  tauscht die W�rme
	 *         
	 */
	
	public void w�rmeTauschen() {

		int ergebnis = (kreislauf.getWasser(kreislauf.getZeigerA()).getTemperatur() + reaktor.getTemperatur()) / 2;
		reaktor.setTemperatur(ergebnis);
		kreislauf.getWasser(kreislauf.getZeigerA()).setTemperatur(ergebnis);
		lw.flussTempAustausch(ergebnis);
	}
}