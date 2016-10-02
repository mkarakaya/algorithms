package algorithms.dynamicProgramming;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by 212457624 on 27.07.2016.
 */
public class FibonacciModified {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("c:/tmp/input01.txt"));
        BigInteger first = in.nextBigInteger();
        BigInteger second= in.nextBigInteger();
        int n = in.nextInt();
        fibonacci(first,second,n-1);
    }

    private static void fibonacci(BigInteger first, BigInteger second, int n) {
        if(n==0){
            System.out.println(first);
        }else{
            fibonacci(second,second.multiply(second).add(first),n-1);
        }
    }
}
