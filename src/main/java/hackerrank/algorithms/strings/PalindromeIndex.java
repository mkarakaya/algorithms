package hackerrank.algorithms.strings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by mokarakaya on 30.10.2016.
 */
public class PalindromeIndex {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner scanner = new Scanner(System.in);
        long start = System.currentTimeMillis();
        Scanner scanner = new Scanner(new File("c:/temp/input14P.txt"));
        int tests = scanner.nextInt();
        for(int i=0;i<tests;i++){
            char[] chars = scanner.next().toCharArray();

            if(isPalindrom(chars,-1)){
                System.out.println(-1);
            }else{
                boolean found=false;
                for(int j=0;j<chars.length;j++){
                    if(isPalindrom(chars,j)){
                        System.out.println(j);
                        found=true;
                        break;
                    }
                }
                if(!found){
                    System.out.println(-1);
                }
            }

        }

        long end= System.currentTimeMillis();
        System.out.println("takes:"+(end-start));
    }

    public static boolean isPalindrom(char[] word,int escape){
        int i1 = 0;
        int i2 = word.length - 1;
        while (i2 > i1) {
            if(i1==escape) i1++;
            if(i2==escape) i2--;
            if (word[i1] != word[i2]) {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;
    }
}
