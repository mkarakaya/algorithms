/**
 * Created by p.bell on 02.02.2016.
 */
public class Palindrome {

    public boolean isPalindrome(String string){
        if(string.length()==0 || string.length()==1){
            return true;
        }
        if(string.charAt(0)==string.charAt(string.length()-1)){
            return isPalindrome(string.substring(1,string.length()-1));
        }
        return false;
    }
}
