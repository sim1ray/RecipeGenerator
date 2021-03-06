
public class Trie {

	private TrieNode root;

	class TrieNode {
		private TrieNode[] subLetters;
		private int value;

		public TrieNode(){
			subLetters = new TrieNode[128];
			value = 0;
		}

		public int getValue() {
			return value;
		}

	}

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word, int value) {
		int index = 0;
		int level = 0;
		int length = word.length();
		TrieNode current = root;

		while(level < length) {
			index = word.charAt(level);
			if(current.subLetters[index] == null) {
				current.subLetters[index] = new TrieNode();
			}
			current = current.subLetters[index];
			level++;
		}
		current.value = value;
	}

	public int search(String word) {
		int level = 0;
		int index = 0;
		int length = word.length();
		TrieNode current = root;
		while(level < length) {
			index = word.charAt(level);
//			if(index == 65279){
//				word = word.substring(1);
//				index = word.charAt(0);
//			}
			if(current.subLetters[index] == null) {
				return -1;
			}
			current = current.subLetters[index];
			level++;
		}
		return current.value;
	}

}
