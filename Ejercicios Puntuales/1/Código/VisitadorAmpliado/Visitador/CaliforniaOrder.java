package Visitador;
public class CaliforniaOrder implements Order {
  private double orderAmount;
  private double additionalTax;
  private int ID;

  public CaliforniaOrder() {
  }
  public CaliforniaOrder(double inp_orderAmount,
      double inp_additionalTax) {
    orderAmount = inp_orderAmount;
    additionalTax = inp_additionalTax;
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public double getAdditionalTax() {
    return additionalTax;
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

