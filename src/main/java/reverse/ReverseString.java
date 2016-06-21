package reverse;

import model.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by p.bell on 02.02.2016.
 */
public class ReverseString {

    /**
     * reverses a given string
     * @param string
     * @return
     */
    public String reverse(String string){

        if(string.length()<2){
            return string;
        }
        return reverse(string.substring(1))+string.charAt(0);
    }

    /**
     * reverses a given linkedlist
     * @param node
     * @return
     */
    public Node reverseList(Node node){
        if (node == null || node.next == null) {
            return node;
        }
        Node remaining = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return remaining;
    }


}
