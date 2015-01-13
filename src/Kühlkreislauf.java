
public class Kühlkreislauf {
	private Wasser[] wasserkreislauf = new Wasser[12];
	private int zeigerA;
	private int zeigerB;
	
	
	
	//Konstruktor
	public Kühlkreislauf(int temperatur){
		this.zeigerA = 0;
		this.zeigerB = 6;
		befüllen(temperatur);
	}
	
	
	
	private void befüllen(int temperature){
		for (int i = 0; i < wasserkreislauf.length; i++) {
			wasserkreislauf[i] = new Wasser(temperature);
		}
	}
	
	
	public void rotieren(){
		 if(this.zeigerA == 11){
			 this.zeigerA = 0;
		 }else{
			 zeigerA++;
		 }
			 
		 if(this.zeigerB == 11){
			 this.zeigerB = 0;
		 }else{
			 zeigerB++;
		 }
	}

	public int getPointerA(){
		return this.zeigerA;
	}
	
	
	
	public int getPointerB(){
		return this.zeigerB;
	}
	
	public Wasser getWasser(int position){
		return this.wasserkreislauf[position];
	}
}
