import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class TiempoRadix extends SwingWorker<Integer, String> {

	 private JProgressBar pb;
		private long totalTiempo;
		private ListasDeMetodos lm;
		private JLabel resR;
		private JTextArea txt;
		private ListaDoble aux=new ListaDoble();
		
		public TiempoRadix(ListasDeMetodos lm,JLabel resR,JProgressBar pb,JTextArea txt) {
	        this.lm = lm;
	        this.resR=resR;
	        this.pb=pb;
	        this.txt=txt;
	    }
		
		@Override
		protected Integer doInBackground() throws Exception {
		 	pb.setIndeterminate(true); 
		 	resR.setText("Ordenando...");
		    long tiempoInicio = System.currentTimeMillis();
		    lm.metodoBurbuja();
		    long tiempoFin = System.currentTimeMillis();
		    this.totalTiempo = tiempoFin - tiempoInicio;
		    resR.setText(totalTiempo+"mili segundos");
			pb.setIndeterminate(false);
		    aux=lm.getListaR();
		    txt.setText(aux.imprimirDatos());

			return 0;
		}
}
