package Builder;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Visitador.NonCaliforniaOrder;
import Visitador.Order;

public class PanelNoCalifornia implements PanelBuilder {

	private JPanel pnlNonCaliforniaOrder;
	private JTextField txtAmount;
	
	@Override
	public void addUIControls() {
		this.pnlNonCaliforniaOrder = new JPanel();
		this.pnlNonCaliforniaOrder.setLayout(null);
		
		JLabel lblAmount = new JLabel("Monto de la orden");
		lblAmount.setBounds(12, 12, 263, 23);
		this.pnlNonCaliforniaOrder.add(lblAmount);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(200, 14, 250, 19);
		this.pnlNonCaliforniaOrder.add(txtAmount);
		txtAmount.setColumns(10);
	}

	@Override
	public void initialize() {
		this.txtAmount.setText("0");
	}

	@Override
	public JPanel getPanel() {
		pnlNonCaliforniaOrder.setVisible(true);
		return this.pnlNonCaliforniaOrder;
	}


	@Override
	public Order getOrder() {
		double amount = new Double(this.txtAmount.getText()).doubleValue();
		if (amount >= 0) {
			return new NonCaliforniaOrder(amount);
		}
		throw new IllegalArgumentException();
	}

}
