
public class K�hlkreislauf {
	private Wasser[] wasserkreislauf = new Wasser[12];
	private int zeigerA;
	private int zeigerB;
	
	
	

	public K�hlkreislauf(int temperatur){
		this.zeigerA = 0;
		this.zeigerB = 6;
		bef�llen(temperatur);
	}
	
	
	
	private void bef�llen(int temperatur){
		for (int i = 0; i < wasserkreislauf.length; i++) {
			wasserkreislauf[i] = new Wasser(temperatur);
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

	public int getZeigerA(){
		return this.zeigerA;
	}
	
	
	
	public int getZeigerB(){
		return this.zeigerB;
	}
	
	public Wasser getWasser(int position){
		return this.wasserkreislauf[position];
	}
}
