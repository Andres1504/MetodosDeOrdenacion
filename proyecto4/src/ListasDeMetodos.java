import java.util.Random;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class ListasDeMetodos {
	
    private ListaDoble lista1;
    private ListaDoble lista2;
    private ListaDoble lista3;
    private ListaDoble lista4;
    private int numElem;
    private int intInf;
    private int intSup;
    private int mayor;
    
    ListasDeMetodos() {}
    
    
    public void crearListas(int numElem, int intInf, int intSup) {
    	
        this.numElem = numElem;
        this.intInf = intInf;
        this.intSup = intSup;
        lista1 = new ListaDoble();
        lista2 = new ListaDoble();
        lista3 = new ListaDoble();
        lista4 = new ListaDoble();
        this.mayor = 0;
        
        boolean bandera = true;
        int dato;
        Random r = new Random();
        for (int i = 0; i < numElem; i++) {
            dato = (int) ( r.nextDouble() * this.intSup + 1) + this.intInf - 1;
            lista1.insertarInicio(dato);
            lista2.insertarInicio(dato);
            lista3.insertarInicio(dato);
            lista4.insertarInicio(dato);
            if (dato > this.mayor) {
                this.mayor = dato;
            }
        }
    }
    
    public void metodoShell() {
        lista1.ordenarShell(lista1);
    }
    
    public ListaDoble getListaS() {
    	return lista1;
    }

    public void metodoQuickSort() {
        lista2.ordenarQuickSort(lista2);

    }
    
    public ListaDoble getListaQ() {
    	return lista2;
    }

    public void metodoBurbuja() {
        lista3.ordenarBurbuja(lista3);
    }
    
    public ListaDoble getListaB() {
    	return lista3;
    }
    
    public void metodoRadix() {
        lista4.ordenarRadix2();
    }
    
    public ListaDoble getListaR() {
    	return lista3;
    }
    

}
