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

	public static void wärmeAusgleichen(int warmwasserTemperatur,
			int kaltwasserTemperatur) {
		int ergebnis= ((warmwasserTemperatur + kaltwasserTemperatur) / 2);
		kreislauf.setTemperature(ergebnis);
		kreislauf.getWaterelement(kreislauf.getPointerA()).setTemperature(ergebnis);
		mc.onReactorTempChange(ergebnis);
	}
}