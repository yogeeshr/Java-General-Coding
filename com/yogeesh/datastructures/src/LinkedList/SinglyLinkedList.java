package LinkedList;

import common.Data;
import common.Node;

/**
 * @author yogeesh.srkvs@gmail.com
 *
 */
public class SinglyLinkedList {
	
	/**
	 * @param head
	 * @param I
	 * @return
	 */
	public static Node insert (Node head, Integer I) {
		Node item = new Node();
		item.setData(new Data(I));
		item.setNext(null);
		
		if (null==head) {
			return item;
		}
		
		Node temp = head;
		
		while (null!=temp.getNext()) {
			temp = temp.getNext();
		}
		temp.setNext(item);
		
		return head;
	}
	
	/**
	 * @param head
	 * @param I
	 * @return to delete a node given integer
	 */
	public static Node delete (Node head, Integer I) {
		
		if (head.getData().getValue().compareTo(I)==0) {
			return head.getNext();
		}
		
		Node temp = head;
		while (temp.getNext().getData().getValue().compareTo(I)==0) {
			temp = temp.getNext();
		}
		
		temp.setNext(temp.getNext().getNext());		
		
		return head;
	}
	
	/**
	 * @param head
	 * print all elements
	 */
	public static void traverse (Node head) {
		while (head!=null) {
			System.out.print(head.getData().getValue()+ " ");
			head = head.getNext();
		}
	}
	
	public static void main(String args[]) {
		Node head  = null;
		head = SinglyLinkedList.insert(head, new Integer(10));
		head = SinglyLinkedList.insert(head, new Integer(10));
		head = SinglyLinkedList.insert(head, new Integer(10));
		head = SinglyLinkedList.insert(head, new Integer(10));
		SinglyLinkedList.traverse(head);
		head = SinglyLinkedList.delete(head, new Integer(10));
		System.out.println("");
		SinglyLinkedList.traverse(head);
		head = SinglyLinkedList.delete(head, new Integer(10));
		System.out.println("");
		SinglyLinkedList.traverse(head);
		head = SinglyLinkedList.delete(head, new Integer(10));
		System.out.println("");
		SinglyLinkedList.traverse(head);
		head = SinglyLinkedList.delete(head, new Integer(10));
		System.out.println("");
		SinglyLinkedList.traverse(head);
		
	}
	
}
