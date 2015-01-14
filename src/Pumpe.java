
public class Pumpe implements Runnable {
	
	/**
	 *
	 * @author 1331770
	 * @author 1320733
	 * @author 1312740
	 * 
	 */

	private int leistung;
	private Kühlkreislauf kreislauf;
	private int wasserGepumpt = 0;
	private int koeffizient;
	WärmetauscherFluss tauscherFl;
	WärmetauscherReaktor tauscherRe;
	Leitware lw;
	
	/**
	 * Konstruktor 
	 *
	 * @param leistung, kreislauf, koeffizient
	 *            
	 */

	public Pumpe(int leistung, Kühlkreislauf kreislauf, int koeffizient,
			WärmetauscherFluss tauscherFl, WärmetauscherReaktor tauscherRe,
			Leitware lw) {
		this.leistung = leistung;
		this.kreislauf = kreislauf;
		this.koeffizient = koeffizient;
		this.tauscherFl = tauscherFl;
		this.tauscherRe = tauscherRe;
		this.lw = lw;
	}
	
	/**
	 * Thread run, Pumpe wird gestartet
	 *          
	 */

	@Override
	public void run() {

		while (!Thread.currentThread().isInterrupted()) {

			synchronized (Leitware.LOCK) {

				try {

					wasserGepumpt = wasserGepumpt + leistung;

					if (wasserGepumpt >= 100) {
						kreislauf.rotieren();
						wärmeAustauschen();
						wasserGepumpt = wasserGepumpt - 100;
					}

					Leitware.LOCK.wait((long) (1000 / koeffizient));
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}

			}
		}

	}

	public int getLeistung() {
		return this.leistung;
	}

	public void setLeistung(int leistung) {
		this.leistung = leistung;
	}

	private synchronized void wärmeAustauschen() {
		tauscherFl.wärmeTauschen();
		tauscherRe.wärmeTauschen();
		lw.druckTemperatur();
	}

}