package common;

/**
 * @author yogeesh.srkvs@gmail.com
 *
 */
public class Node {
	
	/* next pointer */
	private Node next;
	
	/* previous pointer */
	private Node prev;
	
	/* Data in the node */
	private Data data;
	
	/**
	 * @return the data
	 */
	public Data getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Data data) {
		this.data = data;
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
	public void setNext(Node next) {
		this.next = next;
	}
	/**
	 * @return the prev
	 */
	public Node getPrev() {
		return prev;
	}
	/**
	 * @param prev the prev to set
	 */
	public void setPrev(Node prev) {
		this.prev = prev;
	}	
}
