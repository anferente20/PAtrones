package Visitador;
import java.util.*;
import java.io.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import Builder.BuilderFactory;
import Builder.PanelBuilder;
import Builder.PanelDirector;
import Iterator.AllOrders;



public class OrderManager extends JFrame {
  public static final String newline = "\n";
  public static final String GET_TOTAL = "Get Total";
  public static final String CREATE_ORDER = "Create Order";
  public static final String MODIFY_ORDER = "Modify Order";
  public static final String SAVE_CHANGE = "Save Change";
  public static final String EXIT = "Exit";
  

  private JComboBox cmbOrderType;
  private JPanel pnlOrder;
  private JScrollPane scrlTable;
  private JLabel lblTotal, lblTotalValue;
  private JTable tblOrders;
  private JButton btnSaveChange;
  private JButton btnGetTotal;
  private JButton btnCreateOrder;

  public OrderManager() {
	  super("Ordenes de envio");
		
		JButton btnExit = new JButton(OrderManager.EXIT);
		btnGetTotal = new JButton(OrderManager.GET_TOTAL);
		btnCreateOrder = new JButton(OrderManager.CREATE_ORDER);
		JButton btnModifyOrder = new JButton(OrderManager.MODIFY_ORDER); 
		btnSaveChange = new JButton(OrderManager.SAVE_CHANGE);

		JLabel labelL = new JLabel("Liquidacion de ordenes:");
		JLabel lblOrderType = new JLabel("Tipo de orden:");
		this.cmbOrderType = new JComboBox();
		this.cmbOrderType.addItem(BuilderFactory.CA_ORDER);
		this.cmbOrderType.addItem(BuilderFactory.NON_CA_ORDER);
		this.cmbOrderType.addItem(BuilderFactory.OVERSEAS_ORDER);
		this.cmbOrderType.addItem(BuilderFactory.COLOMBIAN_ORDER);
		this.pnlOrder = new JPanel(new GridLayout(1,1));
		this.scrlTable = new JScrollPane();
		this.tblOrders = new JTable();
		scrlTable.setViewportView(this.tblOrders);
		this.lblTotalValue = new JLabel("");
		ButtonHandler objButtonHandler = new ButtonHandler(this);
		
		btnExit.addActionListener(objButtonHandler);
		btnGetTotal.addActionListener(objButtonHandler);
		btnCreateOrder.addActionListener(objButtonHandler);
		btnModifyOrder.addActionListener(objButtonHandler);
		btnSaveChange.addActionListener(objButtonHandler);
		btnSaveChange.setEnabled(false);
		
		cmbOrderType.addActionListener(objButtonHandler);
		
		btnExit.setBounds(12, 380, 147, 25);
		btnGetTotal.setBounds(179, 350, 155, 25);
		btnCreateOrder.setBounds(12, 350, 155, 25);
		btnModifyOrder.setBounds(179, 380, 155, 25);
		btnSaveChange.setBounds(90, 410, 155, 25);
		
		labelL.setBounds(344, 350, 246, 25);
		lblOrderType.setBounds(12, 12, 302, 15);
		this.cmbOrderType.setBounds(200, 7, 258, 24);
		this.pnlOrder.setBounds(12, 39, 578, 111);
		this.scrlTable.setBounds(12, 164, 578, 181);
		this.lblTotalValue.setBounds(344, 380, 246, 24);
		
		getContentPane().setLayout(null);
		getContentPane().add(this.cmbOrderType);
		getContentPane().add(lblOrderType);
		getContentPane().add(this.pnlOrder);
		getContentPane().add(this.scrlTable);
		getContentPane().add(btnExit);
		getContentPane().add(btnCreateOrder);
		getContentPane().add(btnGetTotal);
		getContentPane().add(btnModifyOrder);
		getContentPane().add(btnSaveChange);
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
    frame.setSize(610,500);
    frame.setVisible(true);
  }

  public void setTotalValue(String msg) {
    lblTotalValue.setText(msg);
  }
  
  public String getOrderType() {
    return (String) cmbOrderType.getSelectedItem();
  }
  
  public JComboBox getCmbOrderType() {
		return this.cmbOrderType;
	}
  public JButton getBtnSaveChanges() {
	  return this.btnSaveChange;
  }
  public JButton getBtnCreateOrder() {
	  return this.btnCreateOrder;
  }
  public JButton getBtnGetTotal() {
	  return this.btnGetTotal;
  }
  public void displayNewUI(JPanel panel) {
		this.pnlOrder.removeAll();
		this.pnlOrder.add(panel);
		this.pnlOrder.validate();
		this.pnlOrder.setBounds(12, 39, 578, 111);
		this.validate();
	}
  public void setDataTable(DefaultTableModel dtm) {
		this.tblOrders.setModel(dtm);
  }
} // End of class OrderManager

class ButtonHandler implements ActionListener {
	private OrderManager manager;
	private AllOrders allOrders;
	private PanelBuilder panel;
	private int id =1;
	
	private String changeType;
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals(OrderManager.EXIT)) {
      System.exit(1);
    }
    if (e.getActionCommand().equals(OrderManager.CREATE_ORDER)
        ) {
      //get input values
    	
    	
    	id = allOrders.getTamano()+1;
    	
    	Order order = this.panel.getOrder();

    	order.setID(id);
    	allOrders.add(order);
    	VisitorTable visitor = new VisitorTable();
		this.allOrders.accept(visitor);
		this.manager.setDataTable(visitor.getTableModel());
		manager.setTotalValue(
        " Order Created Successfully");
      	id++;
    }

    if (e.getActionCommand().equals(OrderManager.GET_TOTAL)) {
      //Get the Visitor
      OrderVisitor visitor = new OrderVisitor();
      allOrders.accept(visitor);
      manager.setTotalValue(String.valueOf(visitor.getOrderTotal()));
    }
    
    if (e.getSource() == manager.getCmbOrderType()) {
		String orderType = manager.getOrderType();
		this.panel = BuilderFactory.getPanel(orderType);
		PanelDirector director = new PanelDirector(this.panel);
		director.build();
		this.manager.displayNewUI(this.panel.getPanel());
	}
    if(e.getActionCommand().equals(OrderManager.MODIFY_ORDER)) { 
    	
    	changeType = "";
    	
    	try {
    	id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la"
    			+ " orden que desea modificar"));

    	id--;
    	
	    	try {
	    		Order order= allOrders.getElement(id);	    		
	        	String type = order.getClass().getName();
	        	type = type.substring(10);
	        	
	        	if(type.equals("CaliforniaOrder")) {
	        		changeType = BuilderFactory.CA_ORDER;
	        	}
	    		if(type.equals("NonCaliforniaOrder")) {
	    			changeType = BuilderFactory.NON_CA_ORDER;		
	    		}
	    		if(type.equals("OverseasOrder")) {
	    			changeType = BuilderFactory.OVERSEAS_ORDER;
	    		}
	    		if(type.equals("ColombianOrder")) {			
	    			changeType = BuilderFactory.COLOMBIAN_ORDER;		
	    		}
	    		this.panel = BuilderFactory.getPanel(changeType);
	    		
	    		PanelDirector director = new PanelDirector(this.panel);
	    		director.build();
	    		this.manager.displayNewUI(this.panel.getPanel());
	    		manager.getBtnSaveChanges().setEnabled(true);
	        	manager.getCmbOrderType().setEnabled(false);
	        	manager.getBtnCreateOrder().setEnabled(false);
	        	manager.getBtnGetTotal().setEnabled(false);
	    	}catch(ArrayIndexOutOfBoundsException ex) {
	    		JOptionPane.showMessageDialog(null, "El ID ingresado no corresponde a ninguna orden registrada.");
	    	};
    	}catch(NumberFormatException nf) {
    		JOptionPane.showMessageDialog(null, "El ID ingresado no es numérico");
    	}    	    	    
    					
    }
    if(e.getActionCommand().equals(OrderManager.SAVE_CHANGE)) {
    	Order order = this.panel.getOrder();
    	order.setID(id+1);
    	allOrders.replace(id, order);
    	VisitorTable visitor = new VisitorTable();
		this.allOrders.accept(visitor);
		this.manager.setDataTable(visitor.getTableModel());
		this.manager.getBtnSaveChanges().setEnabled(false);
		manager.getCmbOrderType().setEnabled(true);
		manager.getBtnCreateOrder().setEnabled(true);
    	manager.getBtnGetTotal().setEnabled(true);
    }
  }

  public ButtonHandler() {
  }
  public ButtonHandler(OrderManager inObjOrderManager) {
    manager = inObjOrderManager;
    allOrders = new AllOrders();
  }

} // End of class ButtonHandler

