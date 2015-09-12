package LinkedList;

import common.Data;
import common.Node;

/**
 * @author yogeesh.srkvs@gmail.com
 *
 * An utility to insert delete traverse in a singly linked list
 */
public class SinglyLinkedList {
	
	/**
	 * @param <T>
	 * @param head
	 * @param I
	 * @return
	 */
	public static <T> Node insert (Node head, T I) {
		Node item = new Node();
		item.setData(new Data<T>(I));
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
	 * @param <T>
	 * @param head
	 * @param element
	 * @return to delete a node given integer
	 */
	public static <T> Node delete (Node head, T element) {
		
		if (head.getData().getValue().equals(element)) {
			return head.getNext();
		}
		
		Node temp = head;
		
		while (!temp.getNext().getData().getValue().equals(element)) {
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
		head = SinglyLinkedList.insert(head, new Integer(20));
		head = SinglyLinkedList.insert(head, new Integer(30));
		head = SinglyLinkedList.insert(head, new Integer(40));
		SinglyLinkedList.traverse(head);
		head = SinglyLinkedList.delete(head, new Integer(20));
		System.out.println("");
		SinglyLinkedList.traverse(head);
		head = SinglyLinkedList.delete(head, new Integer(30));
		System.out.println("");
		SinglyLinkedList.traverse(head);
		head = SinglyLinkedList.delete(head, new Integer(40));
		System.out.println("");
		SinglyLinkedList.traverse(head);
		head = SinglyLinkedList.delete(head, new Integer(10));
		System.out.println("");
		SinglyLinkedList.traverse(head);
		
	}
	
}
