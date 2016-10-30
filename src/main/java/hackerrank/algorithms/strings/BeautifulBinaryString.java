package hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * Created by mokarakaya on 30.10.2016.
 */
public class BeautifulBinaryString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
        String string = scanner.next();
        int count=0;
        for(int i=0;i<string.length()-2;i++){
            if("010".equals(string.substring(i,i+3))){
                count++;
                i+=2;
            }
        }
        System.out.println(count);

    }
}
