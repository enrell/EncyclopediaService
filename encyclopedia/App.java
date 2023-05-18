package encyclopedia;

public class App extends Encyclopedia {

	public static void main(String[] args) {
		Encyclopedia enc = new Encyclopedia();
		
		enc.addWord("Geodo", "Geodo é uma rocha...");
		enc.addWord("Abelha", "Abelha é um inseto...");
		enc.addWord("Banana", "Banana é uma fruta");
		
//		enc.search("Geodo");
//		
//		enc.deleteKeyword("Geodo");
//		enc.deleteKeyword("Geodo");
//		
//		enc.search("Geodo");
//		
//		enc.updateKeyword("Mosca", "é um inseto...");
//		
//		enc.search("Mosca");
//		enc.search("Abelha");
		
		enc.printTree();
	}

}
