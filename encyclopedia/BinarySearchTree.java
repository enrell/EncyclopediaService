package encyclopedia;

public class BinarySearchTree {
	private class Node {
		String keyword;
		String definition;
		Node left;
		Node right;

		public Node(String keyword, String definition) {
			this.keyword = keyword;
			this.definition = definition;
			left = null;
			right = null;
		}
	}

	private Node root;

	public BinarySearchTree() {
		root = null;
	}

	public void insert(String keyword, String definition) {
		root = insertRecursive(root, keyword, definition);
	}

	private Node insertRecursive(Node node, String keyword, String definition) {
		if (node == null) {
			return new Node(keyword, definition);
		}

		if (keyword.compareTo(node.keyword) < 0) {
			node.left = insertRecursive(node.left, keyword, definition);
		} else if (keyword.compareTo(node.keyword) > 0) {
			node.right = insertRecursive(node.right, keyword, definition);
		}

		return node;
	}

	public String search(String keyword) {
		Node node = searchNode(root, keyword);
		if (node != null) {
			return node.definition;
		}
		return null;
	}

	private Node searchNode(Node node, String keyword) {
		if (node == null || node.keyword.equals(keyword)) {
			return node;
		}

		if (keyword.compareTo(node.keyword) < 0) {
			return searchNode(node.left, keyword);
		}

		return searchNode(node.right, keyword);
	}

	public void delete(String keyword) {
		root = deleteNode(root, keyword);
	}

	private Node deleteNode(Node node, String keyword) {
		if (node == null) {
			return null;
		}

		if (keyword.compareTo(node.keyword) < 0) {
			node.left = deleteNode(node.left, keyword);
		} else if (keyword.compareTo(node.keyword) > 0) {
			node.right = deleteNode(node.right, keyword);
		} else {
        	
			if (node.left == null && node.right == null) {
				return null;
                
			} else if (node.left == null) {
				return node.right;
                
			} else if (node.right == null) {
				return node.left;
                
			} else {
				// Caso o nó a ser excluído possui tanto um filho à esquerda quanto um filho à direita
				Node successorParent = node;
				Node successor = node.right;
				while (successor.left != null) {
					successorParent = successor;
					successor = successor.left;
				}
				if (successorParent != node) {
					successorParent.left = successor.right;
					successor.right = node.right;
				}
				successor.left = node.left;
				return successor;
			}
		}

		return node;
	}
    
	public void printTree() {
		inorderRecursive(root);
	}

	private void inorderRecursive(Node node) {
		if (node != null) {
			inorderRecursive(node.left);
			System.out.println("Keyword: " + node.keyword + ", Definition: " + node.definition);
			inorderRecursive(node.right);
		}
	}
}
