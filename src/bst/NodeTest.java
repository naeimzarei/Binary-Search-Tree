package bst;

public class NodeTest {
	public static void main(String[] args) {
		// Instantiate BST
		BinarySearchTree tree = new BinarySearchTree();
		
		// Insert into BST
		tree.addNode(44);
		tree.addNode(45);
		tree.addNode(30);
		tree.addNode(46);
		tree.addNode(46);
		System.out.println(tree.getRoot().getValue());
		System.out.println(tree.getRoot().getLeft().getValue());
		System.out.println(tree.getRoot().getRight().getValue());
		System.out.println(tree.getRoot().getRight().getRight().getValue());
		
		System.out.println();
		
		// Print BST
		tree.printBST(tree.getRoot());
	}
}
