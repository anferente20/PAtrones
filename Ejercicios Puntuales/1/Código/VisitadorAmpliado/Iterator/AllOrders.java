package Iterator;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

import Visitador.Order;
import Visitador.VisitorInterface;

public class AllOrders implements Order {
	private Vector data;

	public AllOrders() {
		data = new Vector();
	}
	
	public Vector getOrders() {
		return data;
	}
	public Enumeration getAllOrders() {
		return data.elements();
	}
	public Iterator getAdministratorOrders() {
		return new AdministratorOrders(this);
	}
	public void add(Object obj) {
		this.data.addElement(obj);
	}
	
	public Order getElement(int id) {
		return (Order) this.data.elementAt(id);
	}
	public int getTamano() {
		return this.data.size();
	}
	public void replace(int id, Object obj) {
		this.data.setElementAt(obj, id);
	}

	@Override
	public void accept(VisitorInterface v) {
		Enumeration e = this.data.elements();
		while(e.hasMoreElements()) {
			Order order = (Order) e.nextElement();
			order.accept(v);
		}
	}

	@Override
	public void setID(int ID) {
		// TODO Auto-generated method stub
		
	}
	
	
}
