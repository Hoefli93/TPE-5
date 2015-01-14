public class WärmetauscherFluss {

	Kühlkreislauf kreislauf;
	Fluss fluss;

	public WärmetauscherFluss(Kühlkreislauf kreislauf, Fluss fluss) {
		this.kreislauf = kreislauf;
		this.fluss = fluss;

	}

	public void wärmeTauschen() {

		int ergebnis = (kreislauf.getWasser(kreislauf.getZeigerB()).getTemperatur() + fluss.getTemperatur()) / 2;
		fluss.setTemperatur(ergebnis);
		kreislauf.getWasser(kreislauf.getZeigerB()).setTemperatur(ergebnis);

	}
}
