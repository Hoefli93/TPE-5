
public class Leitware {
	
	/**
	 *
	 * @author 1331770
	 * @author 1320733
	 * @author 1312740
	 * 
	 */
	private static final int PUMPE_GESCHWINDIGKEIT = 100; 
	private static final int PUMPE_KOEFFIZIENT = 1; 
	private static final int RE_KRITISCHE_TEMPERATUR = 2878;
	private static final int RE_START_TEMPERATUR = 10;
	private static final int RE_HITZE_KOEFFIZIENT = 150;
	private static final int WASSER_START_TEMPERATUR = 10;
	private static final int FLUSS_START_TEMPERATUR = 10;
	public static final Object LOCK = new Object();
	private int flussTemp = WASSER_START_TEMPERATUR;
	private int reaktorTemp = RE_START_TEMPERATUR;

	public void start() {

		Reaktor reaktor = new Reaktor(RE_START_TEMPERATUR,RE_HITZE_KOEFFIZIENT, this);
		Fluss fluss = new Fluss(WASSER_START_TEMPERATUR, this);
		Kühlkreislauf kreislauf = new Kühlkreislauf(WASSER_START_TEMPERATUR);
		WärmetauscherFluss tauscherFl = new WärmetauscherFluss(kreislauf, fluss);
		WärmetauscherReaktor tauscherRe = new WärmetauscherReaktor(kreislauf, reaktor,this);
		Thread pumpe = new Thread(new Pumpe(PUMPE_GESCHWINDIGKEIT, kreislauf,PUMPE_KOEFFIZIENT, tauscherFl, tauscherRe, this));
		Thread reaktorT = new Thread(reaktor);

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

	/**
	 * druckTemperatur, gibt für Simulation aus
	 *         
	 */

	public void druckTemperatur() {

		System.out.println("Temperatur Reaktor :" + reaktorTemp
				+ ", Temperatur Rueckfluss in Rhein: " + flussTemp);
	}

	/**
	 * reaktorTempAustausch, tauscht Temperatur
	 *         
	 */
	
	public void reaktorTempAustausch(int temperatur) {
		this.reaktorTemp = temperatur;
	}

	/**
	 * flussTempAustausch, tauscht Temperatur
	 *         
	 */
	
	public void flussTempAustausch(int temperatur) {
		this.flussTemp = temperatur;
	}


}
