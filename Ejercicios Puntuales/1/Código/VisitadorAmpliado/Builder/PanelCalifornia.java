package Builder;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Visitador.CaliforniaOrder;
import Visitador.Order;

public class PanelCalifornia implements PanelBuilder {
	
	private JPanel pnlCaliforniaOrder;
	private JTextField txtAmount;
	private JTextField txtTax;

	@Override
	public void addUIControls() {
		this.pnlCaliforniaOrder = new JPanel();
		this.pnlCaliforniaOrder.setLayout(null);
		
		JLabel lblAmount = new JLabel("Monto de la orden");
		lblAmount.setBounds(12, 12, 250, 23);
		this.pnlCaliforniaOrder.add(lblAmount);
		
		JLabel lblTax = new JLabel("Impuesto adicional");
		lblTax.setBounds(12, 47, 250, 15);
		this.pnlCaliforniaOrder.add(lblTax);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(200, 14, 250, 19);
		this.pnlCaliforniaOrder.add(txtAmount);
		txtAmount.setColumns(10);
		
		txtTax = new JTextField();
		txtTax.setBounds(200, 45, 250, 19);
		this.pnlCaliforniaOrder.add(txtTax);
		txtTax.setColumns(10);
	}

	@Override
	public void initialize() {
		this.txtAmount.setText("0");
		this.txtTax.setText("0");
	}

	@Override
	public JPanel getPanel() {
		this.pnlCaliforniaOrder.setVisible(true);
		return this.pnlCaliforniaOrder;
	}

	@Override
	public Order getOrder() {
		double amount = new Double(this.txtAmount.getText()).doubleValue();
		double tax = new Double(this.txtTax.getText()).doubleValue();
		if (amount >= 0 && tax >= 0 ) {
			return new CaliforniaOrder(amount, tax);
		}
		throw new IllegalArgumentException();
	}

}
