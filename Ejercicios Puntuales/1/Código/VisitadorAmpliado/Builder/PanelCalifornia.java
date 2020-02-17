package Builder;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		lblAmount.setBounds(12, 12, 263, 23);
		this.pnlCaliforniaOrder.add(lblAmount);
		
		JLabel lblTax = new JLabel("Impuesto adicional");
		lblTax.setBounds(12, 47, 263, 15);
		this.pnlCaliforniaOrder.add(lblTax);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(200, 14, 258, 19);
		this.pnlCaliforniaOrder.add(txtAmount);
		txtAmount.setColumns(10);
		
		txtTax = new JTextField();
		txtTax.setBounds(200, 45, 258, 19);
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
		// TODO Auto-generated method stub
		return null;
	}

}
