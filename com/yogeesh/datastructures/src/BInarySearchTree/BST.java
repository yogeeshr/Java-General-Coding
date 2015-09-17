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
			System.out.println("#01. Insert ");
			System.out.println("#02. Delete ");
			System.out.println("#03. In Order Traverse ");
			System.out.println("#04. Pre Order Traverse ");
			System.out.println("#05. Post Order Traverse ");
			System.out.println("#06. Print Root ");
			System.out.println("#07. Height of Tree ");
			System.out.println("#08. Mirror of Tree ");
			System.out.println("#09. Level Order Traversal ");
			System.out.println("#10. Spiral Traversal ");
			System.out.println("#11. Exit ");
			System.out.println("--------------------------------------");
			System.out.println("Enter Choice (1, 2, 3 etc . . .) : ");
			
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
					int height = BinarySearchTree.findHeight(H);
					System.out.println("Height of tree : "+ height);
					break;
				
				case 8:
					System.out.println(" Mirror Of Tree ");
					Node M = BinarySearchTree.getMirrorTree(H);
					BinarySearchTree.inorder(M);
					break;
				
				case 9:
					System.out.println(" Level order traversal ");
					BinarySearchTree.levelOrder(H);
					break;
					
				case 10:
					System.out.println(" Level order traversal ");
					BinarySearchTree.spiralLevelOrder(H);
					break;					
					
				case 11:
					System.out.println(" Thank You ");
					in.close();
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
	 * level order traversal
	 */
	public static void levelOrder(Node H) {
		int height = BinarySearchTree.findHeight(H);
		for (int i=1; i<=height; i++) {
			printLevel(H, i, true);
		}
	}
	
	/**
	 * @param H
	 * level order spiral traversal
	 */
	public static void spiralLevelOrder(Node H) {
		int height = BinarySearchTree.findHeight(H);
		for (int i=1; i<=height; i++) {
			printLevel(H, i, (i%2)!=0);
		}
	}

	/**
	 * @param H
	 * @param i
	 * Print given a level
	 */
	private static void printLevel(Node H, int i, boolean direction) {
		if (H==null) {
			return;
		}
		if (i==1) {
			System.out.println(H.getData().getValue());
			return;
		}
		printLevel(direction? H.getPrev() : H.getNext(), i-1, direction);
		printLevel(direction? H.getNext() : H.getPrev(), i-1, direction);
	}

	/**
	 * @param H
	 * @return mirror tree of given tree
	 */
	public static Node getMirrorTree(Node H) {
		if (null==H) {			
			return null;
		}
		
		Node temp=new Node();
		Data data = new Data(H.getData().getValue());
		temp.setData(data);
		
		Node temp1 = BinarySearchTree.getMirrorTree(H.getPrev());
		Node temp2 = BinarySearchTree.getMirrorTree(H.getNext());

		temp.setPrev(temp2);
		temp.setNext(temp1);
		
		return temp;		
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
	
	
	/**
	 * @param H
	 * @return
	 */
	public static int findHeight(Node H) {
		if (H==null) {
			return 0;
		}
		
		int leftSubTreeHeight = BinarySearchTree.findHeight(H.getPrev());
		int rightSubTreeHeight = BinarySearchTree.findHeight(H.getNext());
		
		if (leftSubTreeHeight > rightSubTreeHeight) {
			return (leftSubTreeHeight+1);			
		}
		
		return (rightSubTreeHeight+1);
	}
}
