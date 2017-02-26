import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class TiempoBurbuja extends SwingWorker<Integer, String> {
	
    private JProgressBar pb;
	private long totalTiempo;
	private ListasDeMetodos lm;
	private JLabel resB;
	private JTextArea txt;
	private ListaDoble aux=new ListaDoble();
	
	public TiempoBurbuja(ListasDeMetodos lm,JLabel resB,JProgressBar pb,JTextArea txt) {
        this.lm = lm;
        this.resB=resB;
        this.pb=pb;
        this.txt=txt;
    }
	
	@Override
	protected Integer doInBackground() throws Exception {
	 	pb.setIndeterminate(true); 
	 	resB.setText("Ordenando...");
	    long tiempoInicio = System.currentTimeMillis();
	    lm.metodoBurbuja();
	    long tiempoFin = System.currentTimeMillis();
	    this.totalTiempo = tiempoFin - tiempoInicio;
	    resB.setText(totalTiempo+"ms");
		pb.setIndeterminate(false);
	    aux=lm.getListaB();
	    txt.setText(aux.imprimirDatos());

		return 0;
	}


}
