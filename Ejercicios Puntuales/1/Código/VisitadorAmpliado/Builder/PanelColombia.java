package Builder;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Visitador.ColombianOrder;
import Visitador.Order;

public class PanelColombia implements PanelBuilder {
	private JPanel pnlColombianOrder;
	private JTextField txtAmount;
	private JTextField txtFourxThousand;
	
	@Override
	public void addUIControls() {
		this.pnlColombianOrder = new JPanel();
		this.pnlColombianOrder.setLayout(null);
		
		JLabel lblAmount = new JLabel("Monto de la orden");
		lblAmount.setBounds(12, 12, 263, 23);
		this.pnlColombianOrder.add(lblAmount);
		
		JLabel lblSH = new JLabel("Impuesto 4x1000");
		lblSH.setBounds(12, 47, 263, 23);
		this.pnlColombianOrder.add(lblSH);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(200, 14, 250, 19);
		this.pnlColombianOrder.add(txtAmount);
		txtAmount.setColumns(10);
		
		txtFourxThousand = new JTextField();
		txtFourxThousand.setBounds(200, 49, 250, 19);
		txtFourxThousand.setEditable(false);
		this.pnlColombianOrder.add(txtFourxThousand);
		txtFourxThousand.setColumns(10);
	}

	@Override
	public void initialize() {
		this.txtAmount.setText("0");
		this.txtFourxThousand.setText("0");
	}

	@Override
	public JPanel getPanel() {
		pnlColombianOrder.setVisible(true);
		return pnlColombianOrder;
	}


	@Override
	public Order getOrder() {
		double amount = new Double(this.txtAmount.getText()).doubleValue();
		txtFourxThousand.setText(String.valueOf(amount*0.004));
		if (amount >= 0 ) {
			return new ColombianOrder(amount);
		}
		throw new IllegalArgumentException();
	}

}
