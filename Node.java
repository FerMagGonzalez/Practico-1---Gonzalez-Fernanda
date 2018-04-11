/**
 * @author Fernanda M. Gonzalez
 *
 */
public class Node {

	private Object info;
	private Node next;
	
	/**
	 * @param info
	 * @param next
	 */
	public Node() {
		this.info = null;
		this.next = null;
	}
	
	/**
	 * @param info
	 * @param next
	 */
	public Node(Object o, Node n) {
		this.info = o;
		this.next = n;
	}
	
	/**
	 * @return the info
	 */
	public Object getInfo() {
		return info;
	}
	
	/**
	 * @param info the info to set
	 */
	public void setInfo(Object o) {
		this.info = o;
	}
	
	/**
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}
	
	/**
	 * @param next the next to set
	 */
	public void setNext(Node n) {
		this.next = n;
	}
	
}
