public class Leitware {

	private static final int PUMPE_GESCHWINDIGKEIT = 100;
	private static final int PUMPE_KOEFFIZIENT = 1;
	private final static int RE_KRITISCHE_TEMPERATUR = 2878;
	private static final int RE_START_TEMPERATUR = 10;
	private static final int RE_HITZE_KOEFFIZIENT = 222;
	private static final int WASSER_START_TEMPERATUR = 10;
	private int flussTemp = WASSER_START_TEMPERATUR;
	private static final int FLUSS_START_TEMPERATUR = 10;
	private int reaktorTemp = RE_START_TEMPERATUR;
	public static final Object LOCK = new Object();
	
	
	  public void flussTempAustausch(int temperatur) {
          this.flussTemp = temperatur;
  }
}
