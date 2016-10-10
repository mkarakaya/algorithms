package dataStructures.trees;

/**
 * Created by mokarakaya on 02.10.2016.
 */
public class IsThisaBinarySearchTree {
    boolean checkBST(Node root) {
        return check(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean check(Node root, int minValue, int maxValue) {
        if(root==null) return true;
        if(root.data<=minValue || root.data>=maxValue)return false;
        return check(root.left,minValue,root.data) && check(root.right,root.data,maxValue);
    }
}
