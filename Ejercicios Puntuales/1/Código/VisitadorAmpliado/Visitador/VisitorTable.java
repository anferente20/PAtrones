package Visitador;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import Builder.BuilderFactory;

public class VisitorTable implements VisitorInterface {
	private DefaultTableModel tableModel;
	private int id;
	public VisitorTable() {
		id = 1;
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
		row.add(id);
		row.add(BuilderFactory.NON_CA_ORDER);
		row.add(nco.getOrderAmount());
		this.tableModel.addRow(row);
		id++;
	}


	public void visit(CaliforniaOrder co) {
		Vector row = new Vector();
		row.add(id);
		row.add(BuilderFactory.CA_ORDER);
		row.add(co.getOrderAmount());
		row.add(co.getAdditionalTax());
		this.tableModel.addRow(row);
		id++;
	}


	public void visit(OverseasOrder oo) {
		Vector row = new Vector();
		row.add(id);
		row.add(BuilderFactory.OVERSEAS_ORDER);
		row.add(oo.getOrderAmount());
		row.add(null);
		row.add(oo.getAdditionalSH());
		id++;
		this.tableModel.addRow(row);
	}
	
	public void visit(ColombianOrder co) {
		Vector row = new Vector();
		row.add(id);
		row.add(BuilderFactory.COLOMBIAN_ORDER);
		row.add(co.getOrderAmount());
		row.add(null);
		row.add(null);
		row.add(co.getFourxThousand());
		id++;
		this.tableModel.addRow(row);
	}
	public DefaultTableModel getTableModel() {
		return tableModel;
	}

}
