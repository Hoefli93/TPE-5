public class Leitware {

	private static final int PUMPE_GESCHWINDIGKEIT = 100;
	private static final int PUMPE_KOEFFIZIENT = 1;
	private final static int RE_KRITISCHE_TEMPERATUR = 2878;
	private static final int RE_START_TEMPERATUR = 10;
	private static final int RE_HITZE_KOEFFIZIENT = 222;
	private static final int WASSER_START_TEMPERATUR = 10;
	private static final int FLUSS_START_TEMPERATUR = 10;
	public static final Object LOCK = new Object();
	private int flussTemp = WASSER_START_TEMPERATUR;
	private int reaktorTemp = RE_START_TEMPERATUR;

	public void start() {

		Reaktor reactor = new Reaktor(RE_START_TEMPERATUR,RE_HITZE_KOEFFIZIENT, this);
		Fluss river = new Fluss(WASSER_START_TEMPERATUR, this);
		Kühlkreislauf A = new Kühlkreislauf(WASSER_START_TEMPERATUR);
		WärmetauscherFluss tauscherFl = new WärmetauscherFluss(A, river);
		WärmetauscherReaktor tauscherRe = new WärmetauscherReaktor(A, reactor,this);
		Thread pumpe = new Thread(new Pumpe(PUMPE_GESCHWINDIGKEIT, A,PUMPE_KOEFFIZIENT, tauscherFl, tauscherRe, this));
		Thread reaktorT = new Thread(reactor);

		pumpe.start();
		reaktorT.start();

		try {

			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();

		}

		pumpe.interrupt();
		reaktorT.interrupt();

		System.exit(0);

	}


	public void printTemperature() {

		System.out.println("Temperatur Reaktor :" + reaktorTemp
				+ ", Temperatur Rueckfluss in Rhein: " + flussTemp);
	}

	public void reaktorTempAustausch(int temp) {
		this.reaktorTemp = temp;
	}

	public void flussTempAustausch(int temperatur) {
		this.flussTemp = temperatur;
	}

	public void printTemperatur() {

	}
}
