public class Lc208_ImplementTrie_M {
    class Trie {
        TrieNode node;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            node = new TrieNode('\0');


        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode curr = node;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode(c);

                }
                curr = curr.children[c - 'a'];

            }
            curr.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {

            TrieNode wordSearch = getNode(word);

            return wordSearch != null && wordSearch.isWord;

        }

        private TrieNode getNode(String word) {
            TrieNode curr = node;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.children[c - 'a'] == null) return null;

                curr = curr.children[c - 'a'];
            }

            return curr;
        }


        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return getNode(prefix) != null;
        }

    }

    public static void main(String[] args) {

    }

    class TrieNode {
        public boolean isWord;
        public char c;

        public TrieNode[] children;


        public  TrieNode(char c) {
            this.c=c;

            isWord=false;

            children=new TrieNode[26];

        }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
