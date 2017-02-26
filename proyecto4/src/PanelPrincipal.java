import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelPrincipal extends JPanel {
	
	private JLabel ldes;
	private JLabel lord;
	private JTextArea listaIn;
	private JTextArea listaOrd;
	private JScrollPane scroll1;
	private JScrollPane scroll2;
	private JLabel rBurbuja;
	public  JLabel resB;
	private JLabel rShell;
	
	public  JLabel resS;
	private JLabel rQuickSort;
	public  JLabel resQ;
	private JButton generar;
	private JLabel burbuja;
	private JLabel shell;
	private JLabel quickSort;
	public  JLabel resR;
	private JLabel radix;
	private JLabel rRadix;
	
//	@SuppressWarnings("unused")
	
	
	private JLabel numeros;
	private JLabel al;
	private JTextField txtNumeros;
	private JLabel rango;
	private JTextField txtRango1;
	private JTextField txtRango2;
	private JButton hacer;
	private JButton hacer2;
	private JButton hacer3;
	private JButton hacer4;
	private JProgressBar pb;
	private JProgressBar pb2;
	private JProgressBar pb3;
	private JProgressBar pb4;
	private Boolean echo = false;
	private int num=0;
	ListasDeMetodos lm = new ListasDeMetodos();
	
	public PanelPrincipal() {
		
		this.setLayout(null);
		this.setVisible(true);
		
		ldes = new JLabel("Lista Desordenada");
		lord = new JLabel("Lista Ordenada");
		pb = new JProgressBar();
		pb2 = new JProgressBar();
		pb3 = new JProgressBar();
		pb4 = new JProgressBar();
		listaIn = new JTextArea();
		listaIn.setEditable(false);
		listaOrd = new JTextArea();
		listaOrd.setEditable(false);
		scroll1 = new JScrollPane(listaIn,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		ldes.setBounds(500,80,250,25);
		scroll1.setBounds(500,100,100,300);
		scroll2 = new JScrollPane(listaOrd,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		lord.setBounds(700,80,100,25);
		scroll2.setBounds(700,100,100,300);;
		generar = new JButton("Generar");
		resS = new JLabel("******");
		resQ = new JLabel("******");
		resB = new JLabel("******");
		resR = new JLabel("******");
		rShell = new JLabel("Tiempo de ordenacion para shell: ");
		rQuickSort = new JLabel("Tiempo de ordenacion para quick sort: ");
		rBurbuja = new JLabel("Tiempo de ordenacion para burbuja: ");
		rRadix = new JLabel("Tiempo de ordenacion para radix: ");
		numeros = new JLabel("Numeros: ");
		al = new JLabel("al->");
		txtNumeros = new JTextField("");
		rango = new JLabel("Rango de numeros:");
		txtRango1 = new JTextField("");
		txtRango2 = new JTextField("");
		shell = new JLabel("SHELL");
		quickSort = new JLabel("QUICK SORT");
		burbuja = new JLabel("BURBUJA");
		radix = new JLabel("RADIX");
		hacer = new JButton("Ordenar");
		hacer2 = new JButton("Ordenar");
		hacer3 = new JButton("Ordenar");
		hacer4 = new JButton("Ordenar");

		
		
		numeros.setBounds(10,20,80,30);
		txtNumeros.setBounds(150,20,80,30);
		rango.setBounds(10,80,120,30);
		txtRango1.setBounds(150,80,80,30);
		al.setBounds(250,80,40,30);
		txtRango2.setBounds(300,80,80,30);
		generar.setBounds(300,120,100,25);
		
		shell.setBounds(10,180,120,25);
		resS.setBounds(380,180,200,20);
		rShell.setBounds(160,180,200,25);		
		hacer.setBounds(10,200,120,25);
		pb.setBounds(160,210,200,20);
		
		quickSort.setBounds(10,240,120,25);
		rQuickSort.setBounds(160,240,230,25);
		resQ.setBounds(390,240,200,25);
		hacer2.setBounds(10,260,120,25);
		pb2.setBounds(160,270,200,20);
		
		burbuja.setBounds(10,300,120,25);
		rBurbuja.setBounds(160,300,230,25);
		resB.setBounds(380,300,200,25);		
		hacer3.setBounds(10,320,120,25);
		pb3.setBounds(160,330,200,20);
		
		radix.setBounds(10,360,120,25);
		rRadix.setBounds(160,360,230,25);
		resR.setBounds(380,360,200,25);		
		hacer4.setBounds(10,380,120,25);
		pb4.setBounds(160,390,200,20);
		

		
        generar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if( txtNumeros.getText().equals("") )
            	{
            	JOptionPane.showMessageDialog(null, "Cantidad de numeros incorrecta");
            	} 
            	else if(txtRango1.getText().equals(""))
            	{
            		JOptionPane.showMessageDialog(null, "Rango inferior erroneo");
            	}
            	else if (txtRango2.getText().equals(""))
            	{
            		JOptionPane.showMessageDialog(null, "Rango superor erroneo");
            	}
            	else if (Integer.parseInt(txtRango1.getText())>=Integer.parseInt(txtRango2.getText()))
            	{
            		JOptionPane.showMessageDialog(null, "Rangos erroneos");
            	} 
            	else {
                	lm.crearListas(Integer.parseInt(txtNumeros.getText()),Integer.parseInt(txtRango1.getText()),Integer.parseInt(txtRango2.getText()));
                	ListaDoble aux=new ListaDoble();
                	aux=lm.getListaQ();
                	listaIn.setText(aux.imprimirDatos());
                	echo=true;
            	}
            }
        });
		
        hacer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if(echo==false) {
            		JOptionPane.showMessageDialog(null, "NO HAY DATOS QUE ORDENAR");
            	} else {

                    hacer.setEnabled(true);
                    TiempoShell ts = new TiempoShell(lm,resS,pb,listaOrd);
                    ts.execute();
                    
                    /*ListaDoble aux=new ListaDoble();
                    lm.metodoShell();
                	aux=lm.getListaQ();
                	listaOrd.setText(aux.imprimirDatos());*/
        			
            	}
            }
        });
        
        hacer2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if(echo==false) {
            		JOptionPane.showMessageDialog(null, "NO HAY DATOS QUE ORDENAR");
            	} else {
            		hacer2.setEnabled(true);
                	TiempoQuickSort tq = new TiempoQuickSort(lm,resQ,pb2,listaOrd);
    				tq.execute();
    				
                    /*ListaDoble aux=new ListaDoble();
                    lm.metodoQuickSort();
                	aux=lm.getListaQ();
                	listaOrd.setText(aux.imprimirDatos());*/

            		
            	}  
            }
        });
        
        hacer3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if(echo==false) {
            		JOptionPane.showMessageDialog(null, "NO HAY DATOS QUE ORDENAR");
            	} else {
               
                	hacer3.setEnabled(true);
                	TiempoRadix tb = new TiempoRadix(lm,resB,pb3,listaOrd);
                	tb.execute();
    				
                    /*ListaDoble aux=new ListaDoble();
                    lm.metodoBurbuja();
                	aux=lm.getListaQ();
                	listaOrd.setText(aux.imprimirDatos());*/
                	
            	}
            }
        });
        
        
        hacer4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if(echo==false) {
            		JOptionPane.showMessageDialog(null, "NO HAY DATOS QUE ORDENAR");
            	} else {
               
                	hacer4.setEnabled(true);
                	TiempoRadix tb = new TiempoRadix(lm,resR,pb4,listaOrd);
                	tb.execute();
    				
                    /*ListaDoble aux=new ListaDoble();
                    lm.metodoBurbuja();
                	aux=lm.getListaQ();
                	listaOrd.setText(aux.imprimirDatos());*/
                	
            	}
            }
        });
        this.add(pb);
        this.add(pb2);
        this.add(pb3);
        this.add(pb4);
        this.add(ldes);
        this.add(lord);
        this.add(scroll2);
        this.add(scroll1);
        this.add(generar);
        this.add(resQ);
        this.add(resS);
        this.add(resB);
        this.add(resR);
        this.add(burbuja);
        this.add(rBurbuja);
        this.add(quickSort);
        this.add(rQuickSort);
        this.add(shell);
        this.add(rShell);
        this.add(radix);
        this.add(rRadix);
		this.add(al);
		this.add(numeros);
		this.add(txtNumeros);
		this.add(rango);
		this.add(txtRango1);
		this.add(txtRango2);
		this.add(hacer);
		this.add(hacer2);
		this.add(hacer3);
		this.add(hacer4);
		
	}

}
