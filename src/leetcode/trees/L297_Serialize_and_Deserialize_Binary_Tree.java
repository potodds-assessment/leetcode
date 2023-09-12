package leetcode.trees;

/////////////////////////////////////////////////////////////
// 297. Serialize and Deserialize Binary Tree
// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
/////////////////////////////////////////////////////////////

public class L297_Serialize_and_Deserialize_Binary_Tree {

    StringBuilder result = new StringBuilder();
    int pos = 0;
    String[] values;

    /*
    Runtime: 13ms beats 74.06%
    Memory 45.14mb beats 27.04%
    Time: O(n)
    Space: O(n)
     */

    public void inorder(TreeNode node) {
        if ( node == null ) {
            result.append("n,");
            return;
        }

        result.append(node.val + ",");
        inorder(node.left);
        inorder(node.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        inorder(root);
        System.out.println();
        return result.toString();
    }

    public TreeNode inorder() {
        if (values[pos].equals("n")) {
            pos++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(values[pos]));
        pos++;
        node.left = inorder();
        node.right = inorder();

        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        values = data.split(",");
        return inorder();
    }

    public static void main(String[] args) {
        L297_Serialize_and_Deserialize_Binary_Tree app = new L297_Serialize_and_Deserialize_Binary_Tree();

        
        TreeNode n = new TreeNode(100);
        n.left = new TreeNode(200);
        n.right = new TreeNode(300);
        n.right.left = new TreeNode(400);
        n.right.right = new TreeNode(500);

        TreeNode.print(n, TTYPE.PREORDER);
        TreeNode.print(app.deserialize(app.serialize(n)), TTYPE.PREORDER);

//        TreeNode ans = app.deserialize(app.serialize(n));

    }
}
