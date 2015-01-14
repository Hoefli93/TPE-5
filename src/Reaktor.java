

public class Reaktor extends Temperatur implements Runnable {
	
	/**
	 *
	 * @author 1331770
	 * @author 1320733
	 * @author 1312740
	 * 
	 */

	int koeffizient = 0;
	Leitware lw;
	
	/**
	 * Konstruktor 
	 *
	 * @param temperatur, koeffizient, lw
	 *            
	 */

	public Reaktor(int temperatur, int koeffizient, Leitware lw) {
		super(temperatur);
		this.koeffizient = koeffizient;
		this.lw = lw;
	}

	/**
	 * Thread run, Reaktor wird gestartet
	 *          
	 */
	
	@Override
	public void run() {
		{

			while (!Thread.currentThread().isInterrupted()) {
				synchronized (Leitware.LOCK) {

					try {
						this.setTemperatur(getTemperatur() + 1);

						Leitware.LOCK.wait((long) 1000 / koeffizient);

					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}

				}
			}
		}

	}

}
