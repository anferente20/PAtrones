package Builder;

public class BuilderFactory {

	public final static String NONE = "";
	public static final String CA_ORDER = "Orden de california";
	public static final String NON_CA_ORDER = "Orden para fuera de California";
	public static final String OVERSEAS_ORDER = "Orden internacional";
	public static final String COLOMBIAN_ORDER = "Orden para Colombia";
	
	public static PanelBuilder getPanel(String panel) {
		if (panel.equals(BuilderFactory.CA_ORDER)) {
			return new PanelCalifornia();
		} else if (panel.equals(BuilderFactory.NON_CA_ORDER)) {
			return new PanelNoCalifornia();
		} else if (panel.equals(BuilderFactory.OVERSEAS_ORDER)) {
			return new PanelOverseas();
		}else if (panel.equals(BuilderFactory.COLOMBIAN_ORDER)) {
			return new PanelColombia();
		} else {
			throw new IllegalArgumentException();	
		}
	}
}
