package bst;

public class Node {
	private int value;
	private Node left;
	private Node right;
	
	public Node(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public int getValue() { return this.value; }
	public void setValue(int value) { this.value = value; } 
	public Node getLeft() { return this.left; } 
	public Node getRight() { return this.right; }
	public void setLeft(Node left) { this.left = left; }
	public void setRight(Node right) { this.right = right; }
}
