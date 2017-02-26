
public class ListaDoble {
	
	public NodoDoble inicio;
	public NodoDoble fin;
	private int cifraMayor;
	
	
	public ListaDoble() {
		inicio=null;
	}
	

	public void insertarInicio(Integer elem) {
		NodoDoble nuevo = new NodoDoble();
		nuevo.setDato(elem);
		if(inicio == null) {
			fin=nuevo;
			inicio = nuevo;
		}
		else {
			nuevo.setSiguiente(inicio);
			inicio.setAnterior(nuevo);
			inicio = nuevo;
		}
	}
	
	public void insertarFinal(Integer elem) {
        NodoDoble nuevo = new NodoDoble(elem);
        if (inicio == null) {
            inicio = nuevo;
            fin = inicio;

        } else {

            fin.setSiguiente(nuevo);
            nuevo.setAnterior(fin);
            fin = nuevo;
        }

    }

	
	public int obtenerNumeroCifras() {
        int c = this.cifraMayor;
        int numCifras = 0;

        while (c != 0) {
            c = c / 10;
            numCifras++;

        }
        return numCifras;
    }

	
	public void mostrarIF(ListaDoble g) {
		System.out.println();
		System.out.println("Inicio:"+g.inicio.getDato());
		System.out.println("Fin: "+g.fin.getDato());
	}

	public String imprimirDatos() {
		String s ="";
		NodoDoble aux = inicio;
			while(aux != null) {			
				s = s + aux.getDato()+"\n";
				aux=aux.getSiguiente();
			}
			return s;
	}
	
	public NodoDoble getInicio() {
        return inicio;
    }
	
	public void mostrarDatos() {
		NodoDoble aux = inicio;
		NodoDoble aux2=null;
			while(aux != null){			
				System.out.printf("%d, ", aux.getDato());
				aux2=aux;
				aux=aux.getSiguiente();
				
			}
			System.out.printf("\n");
	}
	
	private int numeroNodos() {
		NodoDoble aux=inicio;
		int numeroNodos=0;
		while(aux!=null) {
			numeroNodos++;
			aux=aux.getSiguiente();
		}
		return numeroNodos;
	}
	
	public void ordenarShell(ListaDoble g) {
		shell(g.inicio);
	}
	
	private void shell(NodoDoble i) {
		
		NodoDoble ii = i; 
		NodoDoble item;
		NodoDoble item2;
		int aux;
		int saltos = numeroNodos();
		while((saltos!=0)) {
			int sal=0;
			saltos/=2;
			while(sal<saltos) {
				ii=ii.getSiguiente();
				sal++;
			}	
			while(ii!=null) {
				if(i.getDato()>ii.getDato()) {
					cambio(i,ii);
					item=ii;
					item2=ii;
					aux=saltos;
					while((item!=null) && (aux>0)) {
						item=item.getAnterior();
						aux--;
					}
					while (item != null) {
                        if (item.getDato()>(item2.getDato())) {
                            cambio(item,item2);
                            item2 = item;
                        }
                        item = item.getAnterior();
                    }
				}
				i=i.getSiguiente();
				ii=ii.getSiguiente();
			}
			i=inicio;
			ii=inicio;
		}	
	}
	
	private void cambio(NodoDoble i,NodoDoble j) {
		int aux = i.getDato();
		i.setDato(j.getDato());
		j.setDato(aux);
	}
	
	public void ordenarBurbuja(ListaDoble g) {
		burbuja(g.inicio);
	}
	
	private void burbuja(NodoDoble i) {
		NodoDoble ii = i;
		NodoDoble j = i.getSiguiente();
		while((i!=null)) {
			while(j!= null) {
				if(i.getDato()<j.getDato()) {
					cambio(i,j);		
				}
				j=j.getSiguiente();
			}
			j=ii;
			i=i.getSiguiente();
		}
	}
	
	public void ordenarQuickSort(ListaDoble g) {
		quickSort(g.inicio,g.fin);
		
	}
	
	private void quickSort(NodoDoble i, NodoDoble j) {
		NodoDoble ii = i;
		NodoDoble jj=j;
		while(i!=j) {
			while((i.getDato()<j.getDato())&&(i!=j)) {
				i=i.getSiguiente();
			}
			cambio(i,j);
			while((i.getDato()<=j.getDato())&&(i!=j)) {
				j=j.getAnterior();
			}
			cambio(i,j);
		}
		if(ii!=i) {
			quickSort(ii,i.getAnterior());	
		}
		if(jj!=j) {
			quickSort(j.getSiguiente(),jj);	
		}
	}
	
	
	  public void ordenarRadix2() {
	        ListaDoble[][] radix = new ListaDoble[obtenerNumeroCifras()][10];
	        NodoDoble aux;
	        int numCifras = obtenerNumeroCifras();

	        for (int i = 0; i < numCifras; i++) {
	            ListaDoble listTemp = new ListaDoble();
	            for (int j = 0; j < 10; j++) {
	                aux = inicio;
	                while (aux != null) {
	                    String temp = "" + aux.getDato();
	                    while ((temp.length() - 1) < (numCifras - i - 1)) {
	                        temp = "0" + temp;
	                    }

	                    //System.out.println("temp " + (temp.length() - 1) + "  charat" + (numCifras - i - 1));
	                    temp = "" + temp.charAt((numCifras - i - 1));
	                    if (temp.trim().equals(String.valueOf(j))) {
	                        radix[i][j] = new ListaDoble();
	                        radix[i][j].insertarFinal(aux.getDato());
	                        listTemp.insertarFinal(aux.getDato());

	                    }
	                    aux = aux.getSiguiente();
	                }

	            }
	            this.inicio = listTemp.getInicio();
	        }

	    }
	
	
	
}
