package Iterator;

import java.util.*;

import Visitador.Order;

public class AdministratorOrders implements Iterator{
	private HashMap h;
	AllOrders ao;
	int key;
	Order nextOrder;
	Enumeration ec;
	
	public AdministratorOrders(AllOrders inp_ao){
		ao = inp_ao;
		
	}
	
	public boolean hasNext() {
		if(ec.hasMoreElements()) {
			return true;
		}		
		return false;
	}

	
	public Object next() {
		if (hasNext()) {
			nextOrder = (Order)ec.nextElement();
			return nextOrder;
		}else {
			throw new NoSuchElementException();
		}		
	}
	/**
	public boolean SearchOrder(int key) {
		
		return false;
	}**/
}
