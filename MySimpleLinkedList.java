import java.util.Iterator;

/**
 * @author Fernanda M. Gonzalez
 *
 */
public class MySimpleLinkedList implements Iterable<Integer>{

	private Node first;
	private int size = 0;
	
	public class MyIterator implements Iterator<Integer> {
		
		private int posActual;
		private Node cursor;
		private MySimpleLinkedList elementos;
		
		public MyIterator (MySimpleLinkedList l){
			elementos = l;
			posActual = 0;
			cursor = first;
		}

		@Override
		public boolean hasNext() {
			return (posActual < elementos.getSize());
		}

		@Override
		public Integer next() {
			Node tmp = cursor;
			cursor = cursor.getNext();
			posActual++;
			return tmp.getInfo();
		}
		
	}
	
	/**
	 * 
	 */
	public MySimpleLinkedList(){
		first = null;
	}
	
	/**
	 * 
	 */
	public MySimpleLinkedList(int n){
		for(int i=0; i<n; i++) {
			insert((int)(Math.floor(Math.random() * 10) + 1));
		}
	}
	
	/**
	 * @return the first
	 */
	public Node getFirst() {
		return first;
	}

	/**
	 * @param first the first to set
	 */
	public void setFirst(Node first) {
		this.first = first;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * 
	 */
	public boolean isEmpty(){
		return size==0;
	}

	/**
	 * Método que siempre inserta el valor al comienzo de la lista.
	 * Si la lista esta ordenada, esta queda de mayor a menor.
	 * @param e Elemento a insertar.
	 */
	public void insert (int e){
		Node tmp = new Node(e, null);
		tmp.setNext(first);
		first = tmp;
		size++;
	}
	
	/**
	 * Método que inserta ordenado el valo que se pasa como parametro.
	 * @param e Elemento a insertar.
	 */
	public void insertOrd (int e){
		Node nuevo = new Node();
		nuevo.setInfo(e);
		if (isEmpty()){
			first = nuevo;
		}
		else{
			if (e < first.getInfo()){
				nuevo.setNext(first);
				first = nuevo;
			}
			else{
				Node cursor = first;
				Node atras = first;
				while (e >= cursor.getInfo() && (cursor.getNext() != null)){
					atras = cursor;
					cursor = cursor.getNext();
				}
				if (e >= cursor.getInfo()){
					cursor.setNext(nuevo);
				}
				else{
					nuevo.setNext(cursor);
					atras.setNext(nuevo);
				}
			}
			Node tmp = first;
			while (tmp.getNext() != null){
				tmp = tmp.getNext();
			}
			nuevo = tmp.getNext();
			tmp.setNext(nuevo);
		}
		size++;
	}
	
	/**
	 * 
	 */
	public Object extract (){
		Node tmp = first;
		first = first.getNext();
		size--;
		return tmp.getInfo();
	}
	
	/**
	 * Método que vacia la lista.
	 */
	public void deleteList(){
		// Elimina el valor y la referencia a los demas nodos.
        first = null;
        // Reinicia el contador de tamaño de la lista a 0.
        size = 0;
	}
	
	/**
	 * 
	 */
	public Node get(int n){
		Node result = null;
		if ((n>=0) && (n<this.getSize())){
			Node tmp = first;
			for (int i=1; i<=n; i++){
				tmp = tmp.getNext();
			}
			result = tmp;
		}
		return result;
	}
	
	/**
     * Busca si existe un valor en la lista.
     * @param referencia valor a buscar.
     * @return true si existe el valor en la lista.
     */
    public boolean search(int referencia){
        // Crea una copia de la lista.
        Node aux = first;
        // Bandera para indicar si el valor existe.
        boolean encontrado = false;
        // Recorre la lista hasta encontrar el elemento o hasta 
        // llegar al final de la lista.
        while(aux != null && encontrado != true){
            // Consulta si el valor del nodo es igual al de referencia.
            if (aux.getInfo() == referencia){
                // Canbia el valor de la bandera.
                encontrado = true;
            }
            else{
                // Avanza al siguiente. nodo.
                aux = aux.getNext();
            }
        }
        // Retorna el resultado de la bandera.
        return encontrado;
    }
    
    public Iterator<Integer> iterator() {
		return new MyIterator(this);
	}
    
    /**
     * Mustra en pantalla los elementos de la lista.
     **/
    public void showList(){
    	Iterator<Integer> it = this.iterator();
    	int i = 0;
    	while (it.hasNext()){
    		Integer aux = it.next();
    		System.out.print(i + ".[ " + aux + " ]" + " ->  ");
    		i++;
    	}
    }

}
