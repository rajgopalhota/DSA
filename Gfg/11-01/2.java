import java.util.*;

class Solution {

    void leaves(Node root, ArrayList<Integer> list) {
        
        if (root == null) return;
        
        leaves(root.left, list);

        if (root.left == null && root.right == null) list.add(root.data);

        leaves(root.right, list);
        
    }

    void leftBoundary(Node root, ArrayList<Integer> list) {

        if (root == null) return;
        
        if (root.left != null || root.right != null) list.add(root.data);

        if (root.left != null) leftBoundary(root.left, list);
        
        else if (root.right != null) leftBoundary(root.right, list);
        
    }

    void rightBoundary(Node root, ArrayList<Integer> list) {

        if (root == null) return;
        
        if (root.right != null) rightBoundary(root.right, list);

        else if (root.left != null) rightBoundary(root.left, list);
        

        if (root.left != null || root.right != null) list.add(root.data);
        
    }
    
    ArrayList<Integer> printBoundary(Node node) {

        ArrayList<Integer> list = new ArrayList<>();
        
        if (node == null) return null;
        
        if (node.left == null && node.right == null) list.add(node.data);
        
        else {
            list.add(node.data);
            leftBoundary(node.left, list);
            leaves(node, list);
            rightBoundary(node.right, list);
        }

        return list;

    }

}