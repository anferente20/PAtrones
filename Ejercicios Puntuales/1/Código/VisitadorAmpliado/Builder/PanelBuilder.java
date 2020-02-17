package Builder;

import javax.swing.JPanel;

import Visitador.Order;

public interface PanelBuilder {

	public void addUIControls();
	public void initialize();
	public JPanel getPanel();
	public Order getOrder();
}
