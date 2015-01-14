public class Fluss extends Temperatur {

	private Leitware leitware;

	public Fluss(int temperatur, Leitware leitware) {
		super(temperatur);
		this.leitware = leitware;

	}

	@Override
	public int getTemperatur() {
		return 10;
	}

	@Override
	public void setTemperatur(int temp) {

	}

}
