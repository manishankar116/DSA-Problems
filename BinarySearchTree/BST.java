
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class BST {
	
	Node root;
	
	class Node{
		int value;
		Node left;
		Node right;
		
		Node(int value){
			this.value = value;
		}
	}
	
	
	public  boolean insert(int value) {
		Node newNode = new Node(value);
		if(root == null) {
			root = newNode;
			return true;
		}
		else {
			Node temp = root;
			while(true) {
				if(newNode.value == temp.value) return false;
				
				if(newNode.value < temp.value) {
					if(temp.left == null) {
						temp.left = newNode;
						return true;
						
					}
					temp = temp.left;
				}
				
				else {
					if(temp.right == null) {
						temp.right = newNode;
						return true;
					}
					temp = temp.right;
				}
			}
		}
	}
	
	public boolean contains(int value) {
		Node temp = root;
		
		while(temp != null) {
			if(value < temp.value) {
				temp = temp.left;	
			}
			else if(value > temp.value) {
				temp = temp.right;
			}
			else {
				return true;
			}
		}
		
		return false;
	}
	
	public ArrayList<Integer> BFS(){
		Node currentNode = root;
		Queue<Node> queue = new LinkedList<>();
		ArrayList<Integer> result = new ArrayList<>();
		queue.add(currentNode);
		
		while(queue.size() > 0) {
			currentNode = queue.remove();
			result.add(currentNode.value);
			if(currentNode.left != null) {
				queue.add(currentNode.left);
			}
			if(currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}
		
		return result;
		
		
	}
	
	public void PreOrderTraversal(Node node) {
		if(node == null) {
			return;
		}
		
		PreOrderTraversal(node.left);
		System.out.print(node.value + " ");
		PreOrderTraversal(node.right);
		
	}
	
	public void PostOrderTraversal(Node node) {
		if(node == null) {
			return;
		}
		PostOrderTraversal(node.left);
		PostOrderTraversal(node.right);
		System.out.print(node.value + " ");
		
	}
	
	public void InOrderTraversal(Node node) {
		if(node == null) {
			return;
		}
		
		InOrderTraversal(node.left);
		System.out.print(node.value + " ");
		InOrderTraversal(node.right);
		
	}

	
	public static void main(String[] args) {
		
		BST binarySearchTree = new BST();

		binarySearchTree.insert(47);
		binarySearchTree.insert(21);
		binarySearchTree.insert(76); 
		binarySearchTree.insert(18);
		binarySearchTree.insert(52);
		binarySearchTree.insert(82);
		binarySearchTree.insert(27);
		
		binarySearchTree.contains(18); //true
		
		//Breadth first search
		binarySearchTree.BFS();
		
		//Depth first search
		binarySearchTree.PreOrderTraversal(root);
		binarySearchTree.PostOrderTraversal(root);
		binarySearchTree.InOrderTraversal(root);
		
		
	}
	

}
