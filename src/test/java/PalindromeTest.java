import junit.framework.TestCase;
import algorithms.reverse.Palindrome;

/**
 * Created by p.bell on 02.02.2016.
 */
public class PalindromeTest extends TestCase {

    public void testPalindrome(){
        Palindrome palindrome= new Palindrome();
        System.out.println(palindrome.isPalindrome("ascsa"));
    }
}
