package binarysearchtree;

import java.util.Scanner;

import common.Data;
import common.Node;

/**
 * @author @author yogeesh.srkvs@gmail.com
 * 
 * An utility to mimic binary search tree
 */
public class BST {

	public static void main(String args[]) {
		Node H = null;
		Scanner in = new Scanner(System.in);
		
		while (true) {
			System.out.println("--------------------------------------");
			System.out.println("#1. Insert ");
			System.out.println("#2. Delete ");
			System.out.println("#3. In Order Traverse ");
			System.out.println("#4. Pre Order Traverse ");
			System.out.println("#5. Post Order Traverse ");
			System.out.println("#6. Print Root ");
			System.out.println("#7. Exit ");
			System.out.println("--------------------------------------");
			
			int choice = in.nextInt(), data=0;
			
			switch (choice) {
			
			case 1:
				System.out.println("Enter node value to be added :  ");
				data = in.nextInt();
				H = BinarySearchTree.insert(H, new Integer(data));
				break;
			
			case 2:
				System.out.println("Enter node value to be deleted :  ");
				data = in.nextInt();
				H = BinarySearchTree.delete(H, new Integer(data));
				break;
				
			case 3:
				System.out.println(" In order traversal : ");
				BinarySearchTree.inorder(H);
				break;
			
			case 4:
				System.out.println(" Pre order traversal : ");
				BinarySearchTree.preorder(H);
				break;
			
			case 5:
				System.out.println(" Post order traversal : ");
				BinarySearchTree.postorder(H);
				break;
			
			case 6:
				System.out.println(" Root Is : ");
				BinarySearchTree.printRoot(H);
				break;
				
			case 7:
				System.out.println(" Thank You ");
				System.exit(0);
				break;
			
			default:
				System.out.println("* * *  Enter right choice * * *");
				break;
			
			}
		}
	}
}

class BinarySearchTree {
	/**
	 * @param <T>
	 * @param H
	 * @param I
	 * @return insert data into binary search tree
	 * 
	 * * * * * * INSERT * * * * * * * * 
	 */
	public static <T> Node insert(Node H, T I) {
				
		if (H==null) {
			Node item = new Node();
			item.setData(new Data(I));
			item.setNext(null);
			item.setPrev(null);
			return item;			
		}
		
		//Should change integer specific implementation to generic in future
		if (((Integer) I).intValue() >= ((Integer) H.getData().getValue()).intValue()) {
			H.setNext(BinarySearchTree.insert(H.getNext(), I));
		} else {
			H.setPrev(BinarySearchTree.insert(H.getPrev(), I));
		}
		
		return H;
	}
	
	/**
	 * @param H
	 * Utility to print root node
	 */
	public static void printRoot(Node H) {
		if (null==H) {
			System.out.print("Tree is empty");
			return;
		}
		
		System.out.println(H.getData().getValue());
		
		return;
	}

	/**
	 * @param H
	 * @param I
	 * @return delete data from binary search tree
	 * 
	 * * * * * * DELETE * * * * * * * *
	 */
	public static Node delete(Node H, Integer I) {
				
		if (H==null) {
			System.out.println("Tree is empty");
			return null;			
		}
		
		/* This is where root is the data 
		 * Find minimum in right sub tree replace with root
		 * then delete root
		 * */
		if (((Integer) H.getData().getValue()).compareTo(I)==0) {
			Node temp = H.getNext();
			
			/*Right Sub Tree Empty*/
			if (temp==null) {
				return H.getPrev();
			}
			
			/* left sub tree of root's right child empty */
			if (temp.getPrev()==null) {
				H.getNext().setPrev(H.getPrev());
				return H.getNext();
			}
			
			temp = BinarySearchTree.findInOrderSuccessor(H.getNext());
						
			H.getData().setValue(temp.getPrev().getData().getValue());
			temp.setPrev(null);
			
			return H;
		}
		
		Node temparory = H, trial = null;
				
		while (temparory!=null && ((Integer) temparory.getData().getValue()).intValue()!= I.intValue()) {
			trial=temparory;
			temparory = (((Integer) temparory.getData().getValue()).intValue()>I.intValue())? temparory.getNext(): temparory.getPrev();			
		}
		
		if (temparory==null) {
			System.out.println("Element not found\n");
			return H;
		}
		
		/* no child */
		if (temparory.getNext()==null && temparory.getPrev()==null) {
			if (trial.getNext()==temparory) {
				trial.setNext(null);
			} else {
				trial.setPrev(null);
			}
		}
		
		/* has one child*/
		if (temparory.getNext()==null || temparory.getPrev()==null) {
			if (trial.getNext()==temparory){
				trial.setNext((temparory.getNext()==null)? temparory.getPrev() :temparory.getNext());
			} else {
				trial.setPrev((temparory.getNext()==null)? temparory.getPrev() :temparory.getNext());
			}
		}
		
		/* case where there are 2 child */
		//check if it returns null : There can be no in order predecessor for node to be deleted 
		Node inOrderPredecessor = BinarySearchTree.findInOrderSuccessor(temparory);
		temparory.getData().setValue(inOrderPredecessor.getPrev().getData().getValue());
		inOrderPredecessor.setPrev(null);
		
		return H;
	}
	
	private static Node findInOrderSuccessor(Node H) {
		
		if (H==null) {
			return null;
		}
		
		if (H.getPrev()==null) {
			return null;
		}
		
		while (H.getPrev().getPrev()!=null) {
			H=H.getPrev();
		}
		
		/*Pointer to In order Predecessor*/
		return H;		
	}
	
	/**
	 * @param H
	 * 
	 * * * * * * IN ORDER TRAVERSAL * * * * * * * *
	 */
	public static void inorder (Node H) {
		if (H == null) {
			return;
		}
		BinarySearchTree.inorder(H.getPrev());
		System.out.println(" "+H.getData().getValue()+" ");
		BinarySearchTree.inorder(H.getNext());
	}
	
	/**
	 * @param H
	 * 
	 * * * * * * PRE ORDER TRAVERSAL * * * * * * * *
	 */
	public static void preorder (Node H) {
		if (H == null) {
			return;
		}
		
		System.out.println(" "+H.getData().getValue()+" ");
		BinarySearchTree.preorder(H.getPrev());
		BinarySearchTree.preorder(H.getNext());
	}
	
	/**
	 * @param H
	 * 
	 * * * * * * POST ORDER TRAVERSAL * * * * * * * *
	 */
	public static void postorder (Node H) {
		if (H == null) {
			return;
		}
		BinarySearchTree.inorder(H.getPrev());
		BinarySearchTree.inorder(H.getNext());
		System.out.println(" "+H.getData().getValue()+" ");
	}
}
