package hackerrank.algorithms.strings;

import java.util.*;

/**
 * Created by mokarakaya on 30.10.2016.
 */
public class Anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for(int i=0;i<tests;i++){
            String next = scanner.next();
            char[] chars = next.toCharArray();
            if(chars.length%2==1){
                System.out.println(-1);
            }else{
                int result=0;
                Map<Character,Integer> characterSet= new HashMap<>();
                for(int j=chars.length-1;j>=chars.length/2;j--){
                    char charAtIndex = chars[j];
                    characterSet.putIfAbsent(charAtIndex,0);
                    characterSet.put(charAtIndex,characterSet.get(charAtIndex)+1);
                }
                for(int j=0;j<chars.length/2;j++){
                    char charAtIndex = chars[j];
                    Integer count = characterSet.get(charAtIndex);
                    if(count==null || count<=0){
                        result++;
                    }else{
                        characterSet.put(charAtIndex,count-1);
                    }
                }
                System.out.println(result);
            }

        }

    }
}
