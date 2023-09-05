package leetcode.trees;

import java.util.HashMap;
import java.util.Map;

/*
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. 
There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True

Constraints:
1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 104 calls in total will be made to insert, search, and startsWith.
*/

class TrieNode {
    public boolean endOfWord = false;
    public Map<Character, TrieNode> children = new HashMap<>();
}

public class L208_Implement_Trie_Prefix_Tree {

    /*
     * Runtime: 47ms, beats 23.39%
     * Memory: 55.44MB, beats 15.47%
     * 
     * time: O(m) -- length of string
     * space: O(n) -- total number of words
     */

    TrieNode root;

    public L208_Implement_Trie_Prefix_Tree() {
        root = new TrieNode();      
    }

    public void insert(String word) {
        TrieNode curr = root;

        for(char c : word.toCharArray()) {
            if (!curr.children.containsKey(c))
                curr.children.put(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) 
                return false;                            
            curr = curr.children.get(c);
        }
        return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c : prefix.toCharArray()) {
            if (!curr.children.containsKey(c)) 
                return false;
            curr = curr.children.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        L208_Implement_Trie_Prefix_Tree trie = new L208_Implement_Trie_Prefix_Tree();

    trie.insert("apple");
    System.out.println(trie.search("apple") == true);   // return True
    System.out.println(trie.search("app") == false);     // return False
    System.out.println(trie.startsWith("app") == true); // return True
    trie.insert("app");
    System.out.println(trie.search("app") == true);     // return True

    }
}