package dataStructures.trees;

/**
 * Created by mokarakaya on 02.10.2016.
 */
public class BinarySearchTreeInsertion {
    public static void main(String[] args){
        BinarySearchTreeInsertion b= new BinarySearchTreeInsertion();
        Node root=b.insert(null,3);
        root=b.insert(root,6);
        root=b.insert(root,2);
        root=b.insert(root,8);
        root=b.insert(root,7);
        System.out.println(root.data);
    }
    public Node insert(Node root,int value){
        if(root==null)
        {
            Node node=new Node();
            node.data=value;
            node.left=null;
            node.right=null;
            root=node;
        }
        else if(root.data>value)
            root.left=insert(root.left,value);
        else if(root.data<value)
            root.right=insert(root.right,value);

        return root;

    }
}
