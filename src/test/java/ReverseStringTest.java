import junit.framework.TestCase;
import hackerrank.algorithms.model.Node;
import hackerrank.algorithms.reverse.ReverseString;

/**
 * Created by mokarakaya on 02.02.2016.
 */
public class ReverseStringTest extends TestCase{

    public void testReverse(){
        String reverse="reverseMe";
        ReverseString reverseString=new ReverseString();
        System.out.println(reverseString.reverse(reverse));
    }

    public void testReverseLinkedList(){
        Node node= new Node(1);
        Node node2= new Node(2);
        Node node3= new Node(3);
        node2.next=node3;
        node.next=node2;
        ReverseString reverseString=new ReverseString();
        node=reverseString.reverseList(node);
        while(node!=null){
            System.out.println(node.value);
            node=node.next;
        }
    }
}
