public class Reaktor extends Temperatur implements Runnable {

	int koeffizient = 0;
	Leitware lw;

	public Reaktor(int temperatur, int koeffizient, Leitware lw) {
		super(temperatur);
		this.koeffizient = koeffizient;
		this.lw = lw;
	}

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
