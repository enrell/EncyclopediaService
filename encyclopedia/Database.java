package encyclopedia;

public class Database {
	private BinarySearchTree bst;

	public Database() {
		bst = new BinarySearchTree();
	}

	public String getKeyword(String keyword) {
		return bst.search(keyword);
	}

	public void addKeyword(String keyword, String definition) {
		bst.insert(keyword, definition);
	}

	public void updateKeyword(String keyword, String definition) {
		if (bst.search(keyword) != null) {
			bst.insert(keyword, definition);
			System.out.println("Keyword updated: " + keyword);
		} else {
			System.out.println("Update keyword error: keyword not found: " + keyword);
		}
	}

	public void deleteKeyword(String keyword) {
		if (bst.search(keyword) != null) {
			System.out.println("Delete result: " + keyword + " deleted");
			bst.delete(keyword);
		} else {
			System.out.println("Delete result: " + keyword + " no exist in database.");
		}
	}
	public void printTree() {
		bst.printTree();
	}
}
