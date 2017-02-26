import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class TiempoShell extends SwingWorker<Integer, String> {

    private JProgressBar pb;
	private long totalTiempo;
	private ListasDeMetodos lm;
	private JLabel resS;
	private JTextArea txt;
	private ListaDoble aux=new ListaDoble();
	
    public TiempoShell(ListasDeMetodos lm,JLabel resS,JProgressBar pb,JTextArea txt) {
        this.lm = lm;
        this.resS=resS;
        this.pb=pb;
        this.txt=txt;

    }

	@Override
	protected Integer doInBackground() throws Exception {
		pb.setIndeterminate(true); 
		resS.setText("Ordenando...");
	    long tiempoInicio = System.currentTimeMillis();
	    lm.metodoShell();
	    long tiempoFin = System.currentTimeMillis();
	    this.totalTiempo = tiempoFin - tiempoInicio;
	    resS.setText(totalTiempo+"ms");
		pb.setIndeterminate(false);
		lm.metodoQuickSort();
	    aux=lm.getListaQ();
	    txt.setText(aux.imprimirDatos());

		return 0;
	}

}
