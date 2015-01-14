
public class W�rmetauscherReaktor {

	K�hlkreislauf kreislauf;
	Reaktor reaktor;
	Leitware lw;

	public W�rmetauscherReaktor(K�hlkreislauf kreislauf, Reaktor reaktor,Leitware lw) {

		this.kreislauf = kreislauf;
		this.reaktor = reaktor;
		this.lw = lw;
	}

	public void w�rmeTauschen() {

		int ergebnis = (kreislauf.getWasser(kreislauf.getZeigerA()).getTemperatur() + reaktor.getTemperatur()) / 2;
		reaktor.setTemperatur(ergebnis);
		kreislauf.getWasser(kreislauf.getZeigerA()).setTemperatur(ergebnis);
		lw.flussTempAustausch(ergebnis);
	}
}