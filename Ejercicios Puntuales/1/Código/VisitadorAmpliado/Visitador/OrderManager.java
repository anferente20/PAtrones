package Visitador;
import java.util.*;
import java.io.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import Builder.BuilderFactory;
import Builder.PanelBuilder;
import Builder.PanelDirector;
import Iterator.AllOrders;



public class OrderManager extends JFrame {
  public static final String newline = "\n";
  public static final String GET_TOTAL = "Get Total";
  public static final String CREATE_ORDER = "Create Order";
  public static final String EXIT = "Exit";
  

  private JComboBox cmbOrderType;
  private JPanel pnlOrder;
  private JTextField txtOrderAmount, txtAdditionalTax,
  txtAdditionalSH;
  private JLabel lblOrderType, lblOrderAmount;
  private JLabel lblAdditionalTax, lblAdditionalSH;
  private JLabel lblTotal, lblTotalValue;

  private OrderVisitor objVisitor;

  public OrderManager() {
	  super("Ordenes de envio");
		
		JButton btnExit = new JButton(OrderManager.EXIT);
		JButton btnGetTotal = new JButton(OrderManager.GET_TOTAL);
		JButton btnCreateOrder = new JButton(OrderManager.CREATE_ORDER);

		JLabel labelL = new JLabel("Liquidacion de ordenes:");
		JLabel lblOrderType = new JLabel("Tipo de orden:");
		this.cmbOrderType = new JComboBox();
		this.cmbOrderType.addItem(BuilderFactory.CA_ORDER);
		this.cmbOrderType.addItem(BuilderFactory.NON_CA_ORDER);
		this.cmbOrderType.addItem(BuilderFactory.OVERSEAS_ORDER);
		this.cmbOrderType.addItem(BuilderFactory.COLOMBIAN_ORDER);
		this.pnlOrder = new JPanel(new GridLayout(1,1));
		
		this.lblTotalValue = new JLabel("");
		ButtonHandler objButtonHandler = new ButtonHandler(this);
		
		btnExit.addActionListener(objButtonHandler);
		btnGetTotal.addActionListener(objButtonHandler);
		btnCreateOrder.addActionListener(objButtonHandler);

		cmbOrderType.addActionListener(objButtonHandler);
		
		btnExit.setBounds(179, 394, 147, 25);
		btnGetTotal.setBounds(12, 394, 155, 25);
		btnCreateOrder.setBounds(12, 300, 155, 25);

		labelL.setBounds(344, 357, 246, 25);
		lblOrderType.setBounds(12, 12, 302, 15);
		this.cmbOrderType.setBounds(200, 7, 258, 24);
		this.pnlOrder.setBounds(12, 39, 578, 111);

		this.lblTotalValue.setBounds(344, 394, 246, 24);
		
		getContentPane().setLayout(null);
		getContentPane().add(this.cmbOrderType);
		getContentPane().add(lblOrderType);
		getContentPane().add(this.pnlOrder);

		getContentPane().add(btnExit);
		getContentPane().add(btnCreateOrder);
		getContentPane().add(btnGetTotal);
		getContentPane().add(labelL);
		getContentPane().add(this.lblTotalValue);


		
  }

  public static void main(String[] args) {
    JFrame frame = new OrderManager();

    frame.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
            System.exit(0);
          }
        }
                           );

    //frame.pack();
    frame.setSize(500, 400);
    frame.setVisible(true);
  }

  public void setTotalValue(String msg) {
    lblTotalValue.setText(msg);
  }
  public OrderVisitor getOrderVisitor() {
    return objVisitor;
  }
  public String getOrderType() {
    return (String) cmbOrderType.getSelectedItem();
  }
  
  public JComboBox getCmbOrderType() {
		return this.cmbOrderType;
	}
  public void displayNewUI(JPanel panel) {
		this.pnlOrder.removeAll();
		this.pnlOrder.add(panel);
		this.pnlOrder.validate();
		this.pnlOrder.setBounds(12, 39, 578, 111);
		this.validate();
	}
} // End of class OrderManager

class ButtonHandler implements ActionListener {
	private OrderManager manager;
	private AllOrders allOrders;
	private PanelBuilder panel;
  public void actionPerformed(ActionEvent e) {
    String totalResult = null;

    if (e.getActionCommand().equals(OrderManager.EXIT)) {
      System.exit(1);
    }
    if (e.getActionCommand().equals(OrderManager.CREATE_ORDER)
        ) {
      //get input values
    	
    	Order order = this.panel.getOrder();
    	
    	allOrders.add(order);
     

     

     /**
      //Create the order
      Order order = createOrder(orderType, dblOrderAmount,
                    dblTax, dblSH);
**/
      //Get the Visitor
      OrderVisitor visitor =
        manager.getOrderVisitor();

     /** // accept the visitor instance
      order.accept(visitor);
**/
      manager.setTotalValue(
        " Order Created Successfully");
    }

    if (e.getActionCommand().equals(OrderManager.GET_TOTAL)) {
      //Get the Visitor
      OrderVisitor visitor =
        manager.getOrderVisitor();
      totalResult = new Double(
                      visitor.getOrderTotal()).toString();
      totalResult = " Orders Total = " + totalResult;
      manager.setTotalValue(totalResult);
    }
    if (e.getSource() == manager.getCmbOrderType()) {
		String orderType = manager.getOrderType();
		this.panel = BuilderFactory.getPanel(orderType);
		PanelDirector director = new PanelDirector(this.panel);
		director.build();
		this.manager.displayNewUI(this.panel.getPanel());
	}
  }
/**
  public Order createOrder(String orderType,
      double orderAmount, double tax, double SH) {
    if (orderType.equalsIgnoreCase(OrderManager.CA_ORDER)) {
      return new CaliforniaOrder(orderAmount, tax);
    }
    if (orderType.equalsIgnoreCase(
      OrderManager.NON_CA_ORDER)) {
      return new NonCaliforniaOrder(orderAmount);
    }
    if (orderType.equalsIgnoreCase(
          OrderManager.OVERSEAS_ORDER)) {
      return new OverseasOrder(orderAmount, SH);
    }
    return null;
  }
**/
  public ButtonHandler() {
  }
  public ButtonHandler(OrderManager inObjOrderManager) {
    manager = inObjOrderManager;
    allOrders = new AllOrders();
  }

} // End of class ButtonHandler

