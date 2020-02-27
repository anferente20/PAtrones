package Visitador;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import Builder.BuilderFactory;

public class VisitorTable implements VisitorInterface {
	private DefaultTableModel tableModel;
	public VisitorTable() {
		
		this.tableModel = new DefaultTableModel();
		Vector headers = new Vector();
		headers.add("ID");
		headers.add("Tipo");
		headers.add("Monto");
		headers.add("Impuestos");
		headers.add("S & H");
		headers.add("4x1000");
		this.tableModel.setColumnIdentifiers(headers);
	}


	public void visit(NonCaliforniaOrder nco) {
		Vector row = new Vector();
		row.add(nco.getID());
		row.add(BuilderFactory.NON_CA_ORDER);
		row.add(nco.getOrderAmount());
		this.tableModel.addRow(row);
		
	}


	public void visit(CaliforniaOrder co) {
		Vector row = new Vector();
		row.add(co.getID());
		row.add(BuilderFactory.CA_ORDER);
		row.add(co.getOrderAmount());
		row.add(co.getAdditionalTax());
		this.tableModel.addRow(row);
		
	}


	public void visit(OverseasOrder oo) {
		Vector row = new Vector();
		row.add(oo.getID());
		row.add(BuilderFactory.OVERSEAS_ORDER);
		row.add(oo.getOrderAmount());
		row.add(null);
		row.add(oo.getAdditionalSH());
		
		this.tableModel.addRow(row);
	}
	
	public void visit(ColombianOrder co) {
		Vector row = new Vector();
		row.add(co.getID());
		row.add(BuilderFactory.COLOMBIAN_ORDER);
		row.add(co.getOrderAmount());
		row.add(null);
		row.add(null);
		row.add(co.getFourxThousand());
		
		this.tableModel.addRow(row);
	}
	public DefaultTableModel getTableModel() {
		return tableModel;
	}

}
