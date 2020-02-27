package Visitador;
public class OverseasOrder implements Order {
  private double orderAmount;
  private double additionalSH;
  private int ID;
  
  public OverseasOrder() {
  }
  public OverseasOrder(double inp_orderAmount,
      double inp_additionalSH) {
    orderAmount = inp_orderAmount;
    additionalSH = inp_additionalSH;
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public double getAdditionalSH() {
    return additionalSH;
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
