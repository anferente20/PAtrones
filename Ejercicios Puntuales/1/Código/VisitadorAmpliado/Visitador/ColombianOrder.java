package Visitador;

public class ColombianOrder implements Order{
 
	private double orderAmount;
	private double fourxThousand;
	private int ID;
	
	public ColombianOrder() {
	}
	
	public ColombianOrder(double inp_orderAmount) {
		orderAmount = inp_orderAmount;
		fourxThousand = inp_orderAmount*0.004;
	}
	
	
	@Override
	public void accept(VisitorInterface v) {
		v.visit(this);
		
	}
	public int getID() {
		  return this.ID;
	  }
	
	public double getOrderAmount() {
	    return orderAmount;
	 }
	 public void setID(int id) {
		  this.ID = id;
	 }
	public double getFourxThousand() {
	    return fourxThousand;
	 }
}
