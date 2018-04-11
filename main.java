import java.util.Iterator;

/**
 * @author Fernanda M. Gonzalez
 *
 */
public class main {

	public static void main(String[] args) {

		MySimpleLinkedList l1 = new MySimpleLinkedList(5);
		MySimpleLinkedList l2 = new MySimpleLinkedList(6);
		MySimpleLinkedList l3 = new MySimpleLinkedList();
        
        System.out.println("<<-- Listas desordenadas -->>\n");
        
        System.out.println("<<-- Lista 1: ");
        l1.showList();
        System.out.println("\n<<-- Lista 2: ");
        l2.showList();
        
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
        
        System.out.println("\n\n<<-- Tamaño -->");
        System.out.println(l3.getSize());
        
        System.out.println("\n\n<<-- Borrado de listas -->>");
        l1.deleteList();
        System.out.println(l1.getSize());
        l2.deleteList();
        System.out.println(l2.getSize());
        l3.deleteList();
        System.out.println(l3.getSize());
        
        System.out.println("\n\n<<-- Listas Ordenadas -->>\n");
        insertarValores(l1, 8);
        insertarValores(l2, 4);
        
        System.out.println("<<-- Lista 1: ");
        l1.showList();
        System.out.println("\n<<-- Lista 2: ");
        l2.showList();
        
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
        
        System.out.println("\n\n<<-- Tamaño -->");
        System.out.println(l3.getSize());
        
	}
	
	private static void insertarOrdenado(MySimpleLinkedList l3, int valorNodo) {
		if (l3.isEmpty()){
			l3.insertOrd(valorNodo);
		}
		else{
			if (!l3.search(valorNodo)){
				Iterator<Object> it = l3.iterator();
				while (it.hasNext()){
					Node aux = (Node) it.next();
					int valorAux = (int) aux.getInfo();
					if (valorAux < valorNodo)
						it.next();
				}
				l3.insertOrd(valorNodo);
			}
		}
	}
	
	private static void insertarValores(MySimpleLinkedList l, int cN){
		int cantNodos = cN;
        for (int a=0; a < cantNodos; a++){
			int d = (int) (Math.random()*15);
			l.insertOrd(d);
		}
}

}
