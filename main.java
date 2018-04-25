
/**
 * @author Fernanda M. Gonzalez
 *
 */
public class Main {

	public static void main(String[] args) {

		MySimpleLinkedList l1 = new MySimpleLinkedList(9);
		MySimpleLinkedList l2 = new MySimpleLinkedList(6);
		MySimpleLinkedList l3 = new MySimpleLinkedList();
        
        System.out.println("------------------ Listas desordenadas ----------------\n");
        
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
            		l3.insertOrd(valorNI);	//Aqui se utiliza este método ya que las listas no estan ordenadas.
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
        
        System.out.println("\n\n------------ Listas Ordenadas --------------\n");
        insertarValores(l1, 8);
        insertarValores(l2, 4);
        
        System.out.println("<<-- Lista 1: ");
        l1.showList();
        System.out.println("\n<<-- Lista 2: ");
        l2.showList();
        
        System.out.println("\n\n<<-- Armado de lista 3 con valores en comun -->");
        for (int i=0; i<l1.getSize(); i++){
        	Node nodoI = l1.get(i);
        	int valorNI = nodoI.getInfo();
        	for (int j=0; j<l2.getSize(); j++){
        		Node nodoJ = l2.get(j);
            	int valorNJ = nodoJ.getInfo();
            	if (valorNI == valorNJ){
            		l3.insert(valorNI);  //Aqui se puede usar este otro método ya que las listas ya estan ordenadas.
            	}
            }
        }
        
        System.out.println("\n<<-- Lista 3: ");
        l3.showList();
        
        System.out.println("\n\n<<-- Tamaño -->");
        System.out.println(l3.getSize());
        
	}
	
	private static void insertarValores(MySimpleLinkedList l, int cN){
		int cantNodos = cN;
        for (int a=0; a < cantNodos; a++){
			int d = (int) (Math.random()*20);
			l.insertOrd(d);
		}
	}
	
}
