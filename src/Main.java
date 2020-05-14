import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Trie trie = new Trie();
//        trie.insert("apl");
//        trie.search("apl");

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app"));      // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true

        System.out.println("Hello World!");
    }
    
    static class Trie {

        /** Initialize your data structure here. */
        Node root;

        public Trie() {
            root = new Node();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {

            //save root hierarchy
            Node tempRoot = root;

            //send root forward to prepare/fill up the path
            for(char c : word.toCharArray()) {

                if (root.map[c] != null) {

                    root = root.map[c];

                } else {
                    root.map[c] = new Node();
                    root = root.map[c];
                }

            }

            //now last Node at the root should have the word
            root.word=word;

            //give root back it's original hierarchy
            root=tempRoot;

        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {

            Node tempRoot = root;

            for(char c : word.toCharArray()){
                if(tempRoot.map[c]==null) return false;
                else tempRoot = tempRoot.map[c];
            }

            //tempRoot is guaranteed to not be null, but word may be.
            if(tempRoot.word!= null && tempRoot.word.equals(word)) return true;

            return false;

        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {

            Node tempRoot = root;

            //as long as you can move forward, do it, if you are blocked, return false
            for(char c : prefix.toCharArray()){
                if(tempRoot.map[c]==null) return false;
                else tempRoot = tempRoot.map[c];
            }

            return true;

        }

        class Node {

            Node[] map;
            String word=null;

            Node () {
                map = new Node[256];
            }

        }

    }

}
