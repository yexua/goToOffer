package leetcode.tree;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * 示例:
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 */
public class Trie {

    private class Node {
        Node[] child = new Node[26];
        boolean isLeaf;
    }

    private Node root = new Node();


    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        insert(word, root);
    }

    private void insert(String word, Node node) {
        if (node == null) {
            return;
        }
        if (word.length() == 0) {
            node.isLeaf = true;
            return;
        }
        int index = indexForChar(word.charAt(0));
        if (node.child[index] == null) {
            node.child[index] = new Node();
        }
        insert(word.substring(1), node.child[index]);
    }


    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, Node node) {
        if (node == null) {
            return false;
        }
        if (word.length() == 0) {
            return node.isLeaf;
        }
        int index = indexForChar(word.charAt(0));
        return search(word.substring(1), node.child[index]);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return startsWith(prefix, root);
    }

    private boolean startsWith(String prefix, Node node) {
        if (node == null) {
            return false;
        }
        if (prefix.length() == 0) {
            return true;
        }
        int index = indexForChar(prefix.charAt(0));
        return startsWith(prefix.substring(1), node.child[index]);
    }

    private int indexForChar(char c) {
        return c - 'a';
    }
}
