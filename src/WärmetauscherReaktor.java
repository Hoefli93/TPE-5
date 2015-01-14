public class WärmetauscherReaktor {

	Kühlkreislauf kreislauf;
	Reaktor reaktor;
	Leitware lw;

	public WärmetauscherReaktor(Kühlkreislauf kreislauf, Reaktor reaktor,
			Leitware lw) {

		this.kreislauf = kreislauf;
		this.reaktor = reaktor;
		this.lw = lw;
	}

	public  void wärmeAusgleichen(int warmwasserTemperatur,
			int kaltwasserTemperatur) {
		int ergebnis= ((warmwasserTemperatur + kaltwasserTemperatur) / 2);
		reaktor.setTemperatur(ergebnis);
		kreislauf.getWasser(kreislauf.getPointerA()).setTemperatur(ergebnis);
		lw.flussTempAustausch(ergebnis);
	}
}