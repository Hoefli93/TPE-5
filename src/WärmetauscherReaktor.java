
public class WärmetauscherReaktor {

	Kühlkreislauf kreislauf;
	Reaktor reaktor;
	Leitware lw;

	public WärmetauscherReaktor(Kühlkreislauf kreislauf, Reaktor reaktor,Leitware lw) {

		this.kreislauf = kreislauf;
		this.reaktor = reaktor;
		this.lw = lw;
	}

	public void wärmeTauschen() {

		int ergebnis = (kreislauf.getWasser(kreislauf.getZeigerA()).getTemperatur() + reaktor.getTemperatur()) / 2;
		reaktor.setTemperatur(ergebnis);
		kreislauf.getWasser(kreislauf.getZeigerA()).setTemperatur(ergebnis);
		lw.flussTempAustausch(ergebnis);
	}
}