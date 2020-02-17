package Builder;

public class PanelDirector {
	private PanelBuilder builder;
	
	public PanelDirector(PanelBuilder builder) {
		this.builder = builder;
	}
	
	public void build() {
		this.builder.addUIControls();
		this.builder.initialize();
	}
}
