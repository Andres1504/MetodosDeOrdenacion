import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class TiempoQuickSort extends SwingWorker<Integer, String> {
	
    private JProgressBar pb;
	private long totalTiempo;
	private ListasDeMetodos lm;
	private JLabel resQ;
	private JTextArea txt;
	private ListaDoble aux=new ListaDoble();
	
    public TiempoQuickSort(ListasDeMetodos lm,JLabel resQ,JProgressBar pb,JTextArea txt) {
        this.lm = lm;
        this.resQ=resQ;
        this.pb=pb;
        this.txt=txt;
    }
	
	

	@Override
	protected Integer doInBackground() throws Exception {
	    pb.setIndeterminate(true);
	 	resQ.setText("Ordenando..."); 
	    long tiempoInicio = System.currentTimeMillis();
	    lm.metodoQuickSort();
	    long tiempoFin = System.currentTimeMillis();
	    this.totalTiempo = tiempoFin - tiempoInicio;
	    resQ.setText(totalTiempo+"ms");
		pb.setIndeterminate(false);
	    aux=lm.getListaQ();
	    txt.setText(aux.imprimirDatos());

		return 0;
	}


}
