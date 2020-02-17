package Builder;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Visitador.Order;

public class PanelOverseas implements PanelBuilder{
	private JPanel pnlOverseasOrder;
	private JTextField txtAmount;
	private JTextField txtSH;
	
	@Override
	public void addUIControls() {
		this.pnlOverseasOrder = new JPanel();
		this.pnlOverseasOrder.setLayout(null);
		
		JLabel lblAmount = new JLabel("Monto de la orden");
		lblAmount.setBounds(12, 12, 302, 15);
		this.pnlOverseasOrder.add(lblAmount);
		
		JLabel lblSH = new JLabel("S & H adicional");
		lblSH.setBounds(12, 47,302, 15);
		this.pnlOverseasOrder.add(lblSH);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(200, 14, 258, 19);
		this.pnlOverseasOrder.add(txtAmount);
		txtAmount.setColumns(10);
		
		txtSH = new JTextField();
		txtSH.setBounds(200, 49, 258, 19);
		this.pnlOverseasOrder.add(txtSH);
		txtSH.setColumns(10);
	}

	@Override
	public void initialize() {
		this.txtAmount.setText("0");
		this.txtSH.setText("0");
	}

	@Override
	public JPanel getPanel() {
		pnlOverseasOrder.setVisible(true);
		return pnlOverseasOrder;
	}


	@Override
	public Order getOrder() {
		// TODO Auto-generated method stub
		return null;
	}

}
