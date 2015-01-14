
public class Pumpe implements Runnable {
	
	/**
	 *
	 * @author 1331770
	 * @author 1320733
	 * @author 1312740
	 * 
	 */

	private int leistung;
	private K�hlkreislauf kreislauf;
	private int wasserGepumpt = 0;
	private int koeffizient;
	W�rmetauscherFluss tauscherFl;
	W�rmetauscherReaktor tauscherRe;
	Leitware lw;
	
	/**
	 * Konstruktor 
	 *
	 * @param leistung, kreislauf, koeffizient
	 *            
	 */

	public Pumpe(int leistung, K�hlkreislauf kreislauf, int koeffizient,
			W�rmetauscherFluss tauscherFl, W�rmetauscherReaktor tauscherRe,
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
						w�rmeAustauschen();
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

	private synchronized void w�rmeAustauschen() {
		tauscherFl.w�rmeTauschen();
		tauscherRe.w�rmeTauschen();
		lw.druckTemperatur();
	}

}