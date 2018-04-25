/**
 * @author Fernanda M. Gonzalez
 *
 */
public class Node {

	private int info;
	private Node next;
	
	/**
	 * @param info
	 * @param next
	 */
	public Node() {
		this.info = -1;
		this.next = null;
	}
	
	/**
	 * @param info
	 * @param next
	 */
	public Node(int e, Node n) {
		this.info = e;
		this.next = n;
	}
	
	/**
	 * @return the info
	 */
	public int getInfo() {
		return info;
	}
	
	/**
	 * @param info the info to set
	 */
	public void setInfo(int e) {
		this.info = e;
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
