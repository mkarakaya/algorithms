package hackerrank.algorithms.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by mokarakaya on 30.10.2016.
 */
public class SherlockAndAnagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int i = 0; i < tests; i++) {
            String next = scanner.next();
            int count = 0;
            for (int k = 1; k < next.length(); k++) {
                for (int l = 0; l <= next.length() - k; l++) {
                    char[] char1 = next.substring(l, k+l).toCharArray();
                    for (int m = l + 1; m <= next.length() - k; m++) {
                        char[] char2 = next.substring(m, k+m).toCharArray();
                        if (isAnagram(char1, char2)) {
                            count++;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static boolean isAnagram(char[] char1, char[] char2) {
        Map<Character,Integer> characterSet= new HashMap<>();
        for(int j=0;j<char1.length;j++){
            char charAtIndex = char1[j];
            characterSet.putIfAbsent(charAtIndex,0);
            characterSet.put(charAtIndex,characterSet.get(charAtIndex)+1);
        }
        for(int j=0;j<char2.length;j++){
            char charAtIndex = char2[j];
            Integer count = characterSet.get(charAtIndex);
            if(count==null || count<=0){
                return false;
            }else{
                characterSet.put(charAtIndex,count-1);
            }
        }
        return true;
    }

}

