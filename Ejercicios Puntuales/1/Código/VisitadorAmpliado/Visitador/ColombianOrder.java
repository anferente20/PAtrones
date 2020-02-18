package Visitador;

public class ColombianOrder implements Order{
 
	private double orderAmount;
	private double fourxThousand;
	
	
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
	
	public double getOrderAmount() {
	    return orderAmount;
	 }

	public double getFourxThousand() {
	    return fourxThousand;
	 }
}
