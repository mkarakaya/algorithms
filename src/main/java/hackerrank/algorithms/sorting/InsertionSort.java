package hackerrank.algorithms.sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by p.bell on 12.06.2016.
 */
//https://www.hackerrank.com/challenges/insertionsort2
public class InsertionSort {
    public static void insertionSortPart2(int[] ar)
    {
        for(int i=1;i<ar.length;i++){
            int shiftIndex=i;
            for(int j=i-1;j>=0;j--){
                if(ar[i]<ar[j]){
                    shiftIndex=j;
                }
            }
            if(shiftIndex!=i)
                shift(ar,i,shiftIndex);
            printArray(ar);
        }
    }

    private static void shift(int[] ar, int i, int j) {
        int value=ar[i];
        for(int k=i;k>j;k--){
            ar[k]=ar[k-1];
        }
        ar[j]=value;
    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("c:/temp/input01.txt"));
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertionSortPart2(ar);

    }
    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
