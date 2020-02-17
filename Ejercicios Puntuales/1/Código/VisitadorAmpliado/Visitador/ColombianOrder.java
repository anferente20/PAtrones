package Visitador;

public class ColombianOrder implements Order{
 
	private double orderAmount;
	private double fourxThousand;
	
	
	public ColombianOrder() {
	}
	
	public ColombianOrder(double inp_orderAmount,double inp_fourxThousand) {
		orderAmount = inp_orderAmount;
		fourxThousand = inp_fourxThousand;
	}
	
	
	@Override
	public void accept(OrderVisitor v) {
		v.visit(this);
		
	}
	
	public double getOrderAmount() {
	    return orderAmount;
	 }

	public double getFourxThousand() {
	    return fourxThousand;
	 }
}
