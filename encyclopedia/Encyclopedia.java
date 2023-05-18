package encyclopedia;

public class Encyclopedia {
	private Database database;

	public Encyclopedia() {
		database = new Database();
	}
	
	public void search(String keyword) {
		String result = database.getKeyword(keyword);
		if (result != null) {
			System.out.println("Search result: " + keyword + ", Definition: " + result);
		} else {
			System.out.println("Search result: Keyword not found: " + keyword);
		}
	}

	public void addWord(String keyword, String out) {
		database.addKeyword(keyword, out);
	}
	
	public void updateKeyword(String keyword, String out) {
		database.updateKeyword(keyword, out);
	}
	
	public void deleteKeyword(String keyword) {
		database.deleteKeyword(keyword);
	}
	public void printTree() {
		database.printTree();
	}
}
