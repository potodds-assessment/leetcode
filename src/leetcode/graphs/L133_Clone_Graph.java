package leetcode.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import leetcode.utilities.Node;

/*
Given a reference of a node in a connected undirected graph.
Return a deep copy (clone) of the graph.
Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}

Test case format:
For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the 
second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.
An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a 
node in the graph.
The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.

Example 1:
Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
Explanation: There are 4 nodes in the graph.
1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).

Example 2:
Input: adjList = [[]]
Output: [[]]
Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.

Example 3:
Input: adjList = []
Output: []
Explanation: This an empty graph, it does not have any nodes.

Constraints:
The number of nodes in the graph is in the range [0, 100].
1 <= Node.val <= 100
Node.val is unique for each node.
There are no repeated edges and no self-loops in the graph.
The Graph is connected and all nodes can be visited starting from the given node.
*/

public class L133_Clone_Graph {

    Set<Integer> visited = new HashSet<>();
    Node clone = null;

    Map<Node, Node> map = new HashMap<>();


    public void dfs1(Node node) {
        if (visited.contains(node.val))
            return;
        else {
            System.out.println("Visited: " + node.val);
            visited.add(node.val);
        }

        for(Node n : node.neighbors) {
            dfs1(n);

            clone = new Node(n.val, null);
        }
    }


    public Node dfs(Node node) {
        if (map.containsKey(node))
            return map.get(node);

        Node copy = new Node(node.val);
        map.put(node, copy);

        for(Node n : node.neighbors) {
            copy.neighbors.add(dfs(n));
        } 

        return copy;
    }


    /*
     * Runtime: 25ms, beats 95.88%
     * Memory: 41.20MB, beats 99.84%
     * 
     * time: O(n)
     * space: O(1)
     */
    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    public void check(Node node) {
        if (this.visited.contains(node.val))
            return;
        else
            this.visited.add(node.val);

        System.out.println("Node " + node.val + " has " + node.neighbors.size() + " neighbors");
        for(Node n : node.neighbors) {
            check(n);
        }
    }

    public static void main(String[] args) {

        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);

        one.neighbors = List.of(two, four);
        two.neighbors = List.of(one, three);
        three.neighbors = List.of(two, four);
        four.neighbors = List.of(one, three);

        L133_Clone_Graph app = new L133_Clone_Graph();
        app.check(app.cloneGraph(one));
    }
}