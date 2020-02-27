package Visitador;
public class NonCaliforniaOrder implements Order {
  private double orderAmount;
  private int ID;
  
  public NonCaliforniaOrder() {
  }
  public NonCaliforniaOrder(double inp_orderAmount) {
    orderAmount = inp_orderAmount;
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public void setID(int id) {
	  this.ID = id;
  }
  public int getID() {
	  return this.ID;
  }
  public void accept(VisitorInterface v) {
    v.visit(this);
  }
}
