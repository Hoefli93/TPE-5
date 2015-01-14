public class W�rmetauscherFluss {

	K�hlkreislauf kreislauf;
	Fluss fluss;

	public W�rmetauscherFluss(K�hlkreislauf kreislauf, Fluss fluss) {
		this.kreislauf = kreislauf;
		this.fluss = fluss;

	}

	public void w�rmeTauschen() {

		int ergebnis = (kreislauf.getWasser(kreislauf.getZeigerB()).getTemperatur() + fluss.getTemperatur()) / 2;
		fluss.setTemperatur(ergebnis);
		kreislauf.getWasser(kreislauf.getZeigerB()).setTemperatur(ergebnis);

	}
}
