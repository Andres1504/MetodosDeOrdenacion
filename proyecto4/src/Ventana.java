import javax.swing.JFrame;

public class Ventana extends JFrame {
	
	public Ventana() {
		super("Metodos de Ordenamiento");
		PanelPrincipal pp = new PanelPrincipal();
		this.add(pp);
		super.setSize(840,520);
		super.setVisible(true);
		super.setLayout(null);
		super.setResizable(false);
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
