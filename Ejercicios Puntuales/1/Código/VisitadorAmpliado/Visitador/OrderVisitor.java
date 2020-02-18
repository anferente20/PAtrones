package Visitador;
import java.util.*;

class OrderVisitor implements VisitorInterface {
 
  private double orderTotal;

  public OrderVisitor() {
	  orderTotal = 0;
  }
  public void visit(NonCaliforniaOrder inp_order) {
    orderTotal = orderTotal + inp_order.getOrderAmount();
  }
  public void visit(CaliforniaOrder inp_order) {
    orderTotal = orderTotal + inp_order.getOrderAmount() +
                 inp_order.getAdditionalTax();
  }
  public void visit(OverseasOrder inp_order) {
    orderTotal = orderTotal + inp_order.getOrderAmount() +
                 inp_order.getAdditionalSH();
  }
  public double getOrderTotal() {
    return orderTotal;
  }

	public void visit(ColombianOrder inp_order) {
		orderTotal = orderTotal + inp_order.getOrderAmount() +
				inp_order.getFourxThousand();
	}
}
