import java.util.Iterator;

/**
 * @author Fernanda M. Gonzalez
 *
 */
public class MySimpleLinkedList implements Iterable<Object>{

	private Node first;
	private int size = 0;
	
	public class MyIterator implements Iterator<Object> {
		
		private int posActual;
		private MySimpleLinkedList elementos;
		
		public MyIterator (MySimpleLinkedList l){
			elementos = l;
			posActual = 0;
		}

		@Override
		public boolean hasNext() {
			return (posActual < elementos.getSize());
		}

		@Override
		public Node next() {
			Node n = (Node) elementos.get(posActual);
			posActual++;
			return n;
		}
		
	}
	
	/**
	 * 
	 */
	public MySimpleLinkedList(){
		first = null;
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
	 * 
	 */
	public void insert (Object o){
		Node tmp = new Node(o, null);
		tmp.setNext(first);
		first = tmp;
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
	 * 
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
    public boolean search(Object referencia){
        // Crea una copia de la lista.
        Node aux = first;
        // Bandera para indicar si el valor existe.
        boolean encontrado = false;
        // Recorre la lista hasta encontrar el elemento o hasta 
        // llegar al final de la lista.
        while(aux != null && encontrado != true){
            // Consulta si el valor del nodo es igual al de referencia.
            if (aux.getInfo().equals(referencia)){
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
    
    public Iterator<Object> iterator() {
		return new MyIterator(this);
	}
    
    /**
     * Mustra en pantalla los elementos de la lista.
     **/
    public void showList(){
    	Iterator<Object> it = this.iterator();
    	int i = 0;
    	while (it.hasNext()){
    		Node aux = (Node) it.next();
    		System.out.print(i + ".[ " + aux.getInfo() + " ]" + " ->  ");
    		i++;
    	}
    }

}
