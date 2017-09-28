package bst;

public class BinarySearchTree {
	private Node root;
	private int count;
	
	public BinarySearchTree() {
		this.root = null;
		this.count = 0;
	}
	
	/**
	 * Return the root node 
	 * @return
	 */
	public Node getRoot() {
		return this.root;
	}
	
	/**
	 * Set the root node
	 * @param root
	 */
	public void setRoot(Node root) {
		this.root = root;
	}
	
	/**
	 * Increment the BST counter
	 */
	public void increment() {
		this.count++;
	}
	
	/**
	 * Decrement the BST counter
	 */
	public void decrement() {
		this.count--;
	}
	
	/**
	 * Returns number of nodes in BST
	 * @return 
	 */
	public int getCount() {
		return this.count;
	}
	
	/**
	 * Add a node to BST
	 * @param value
	 */
	public void addNode(int value) {
		// Check if there is no root
		if (this.getCount() == 0) {
			this.root = new Node(value);
			this.increment();
			return;
		}
		
		Node nodeCursor = this.getRoot();
		boolean isRunning = true;
		do {
			if (this.root.getLeft() == null || this.root.getRight() == null) {
				if (value > this.root.getValue()) {
					this.root.setRight(new Node(value));
				} else if (value < this.root.getValue()) {
					this.root.setLeft(new Node(value));
				}
				this.increment();
				isRunning = false;
			} 
				
			if (nodeCursor.getLeft() != null && nodeCursor.getRight() != null) {
				if (value < nodeCursor.getValue()) {
					nodeCursor = nodeCursor.getLeft();
				} else if (value > nodeCursor.getValue()) {
					nodeCursor = nodeCursor.getRight();
				}
			} else if (nodeCursor.getLeft() == null && nodeCursor.getRight() != null) {
				if (value < nodeCursor.getValue()) {
					nodeCursor.setLeft(new Node(value));
					this.increment();
					isRunning = false;
				} else if (value > nodeCursor.getValue()) {
					nodeCursor = nodeCursor.getRight();
				}
			} else if (nodeCursor.getLeft() != null & nodeCursor.getRight() == null) {
				if (value < nodeCursor.getValue()) {
					nodeCursor = nodeCursor.getLeft();
				} else if (value > nodeCursor.getValue()) {
					nodeCursor.setRight(new Node(value));
					this.increment();
					isRunning = false;
				}
			} else if (nodeCursor.getLeft() == null && nodeCursor.getRight() == null) {
				if (value < nodeCursor.getValue()) {
					nodeCursor.setLeft(new Node(value));
					this.increment();
				} else if (value > nodeCursor.getValue()) {
					nodeCursor.setRight(new Node(value));
					this.increment();
				}
				isRunning = false;
			}
			
		} while (isRunning);
	}
	
	/**
	 * Helper function for printBST().
	 * Finds number of levels then calculates
	 * how many spaces the root node should 
	 * be moved to the right in console.
	 */
	public int getTabs() {
		return 4 * (int) Math.ceil((Math.log(this.getCount() + 1) / Math.log(2)) - 1);
	}
	
	/**
	 * Helper function for printBST()
	 */
	public void printTabs(int tabs) {
		for (int i = 0; i < tabs; i++) {
			System.out.print(" ");
		}
	}
	
	/**
	 * Print the BST recursively 
	 */
	public void printBST(Node root) {
		if (root.getLeft() != null) {
			System.out.println(root.getLeft().getValue() + " ");
			printBST(root.getLeft());
		}
		if (root.getRight() != null) {
			System.out.println(root.getRight().getValue() + " ");
			printBST(root.getRight());
		}
	}
}
