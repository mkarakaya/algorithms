package hackerrank.algorithms.search;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by p.bell on 11.06.2016.
 */
public class CurrencyArbitrage {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner sc = new Scanner(new File("c:/temp/input01.txt"));
        Scanner sc = new Scanner(System.in);
        int arraySize = sc.nextInt();
        String[] array = new String[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = sc.next()+" "+sc.next()+" "+sc.next();
        }

        for (int i = 0; i < array.length; i++) {
            String s= array[i];
            String[] split = s.split(" ");
            double first=Double.parseDouble(split[0]);
            double second=Double.parseDouble(split[1]);
            double third=Double.parseDouble(split[2]);
            double result=new Double(100000)/first;
            result=result/second;
            result=result/third;
            System.out.println(result>100000?(int) result-100000:0);
        }

    }
}
