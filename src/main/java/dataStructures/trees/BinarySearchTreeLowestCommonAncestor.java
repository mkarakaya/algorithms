package dataStructures.trees;

/**
 * Created by mokarakaya on 02.10.2016.
 */
public class BinarySearchTreeLowestCommonAncestor {

    public static void main(String[] args){

    }
    public Node lca(Node root,int v1,int v2)
    {
        int min= Math.min(v1,v2);
        int max= Math.max(v1,v2);
        if(root.data>min && root.data>max){
            return lca(root.left,min,max);
        }else if(root.data<min && root.data<max){
            return lca(root.right,min,max);
        }else{
            return root;
        }

    }
}
class Node {
    int data;
    Node left;
    Node right;
}