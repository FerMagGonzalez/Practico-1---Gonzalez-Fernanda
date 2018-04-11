import java.util.Iterator;

/**
 * @author Fernanda M. Gonzalez
 *
 */
public class main {

	public static void main(String[] args) {

		MySimpleLinkedList l1 = new MySimpleLinkedList();
		MySimpleLinkedList l2 = new MySimpleLinkedList();
		MySimpleLinkedList l3 = new MySimpleLinkedList();
        
        System.out.println("<<-- Listas desordenadas -->>\n");
        
        insertarValores(l1,6);
        insertarValores(l2,3);
        
        System.out.println("<<-- Lista 1: ");
        l1.showList();
        System.out.println("\n<<-- Lista 2: ");
        l2.showList();
        
        System.out.println("\n\n<<-- Tama�os -->");
        System.out.println(l1.getSize());
        System.out.println(l2.getSize());
        
        System.out.println("\n\n<<-- Armado de lista 3 con valores en comun -->");
        for (int i=0; i<l1.getSize(); i++){
        	Node nodoI = l1.get(i);
        	Integer valorNI = (Integer) nodoI.getInfo();
        	for (int j=0; j<l2.getSize(); j++){
        		Node nodoJ = l2.get(j);
            	Integer valorNJ = (Integer) nodoJ.getInfo();
            	if (valorNI == valorNJ){
            		insertarOrdenado(l3, valorNI);
            	}
            }
        }
        
        System.out.println("\n<<-- Lista 3: ");
        l3.showList();
        
        System.out.println("\n\n<<-- Tama�o -->");
        System.out.println(l3.getSize());
        
        System.out.println("\n\n<<-- Fin de ejemplo lista simple -->>");

	}
	
	private static void insertarValores(MySimpleLinkedList l, int cN){
		int cantNodos = cN;
        for (int a=0; a < cantNodos; a++){
			int d = (int) (Math.random()*15);
			l.insert(d);
		}
	}
	
	private static void insertarOrdenado(MySimpleLinkedList l3, int valorNodo) {
		if (!l3.isEmpty()){
			Iterator<Object> it = l3.iterator();
			while (it.hasNext()){
				Node aux = (Node) it.next();
				int valorAux = (int) aux.getInfo();
				if (valorAux < valorNodo)
					it.next();
			}
		}
		l3.insert(valorNodo);
	}

}