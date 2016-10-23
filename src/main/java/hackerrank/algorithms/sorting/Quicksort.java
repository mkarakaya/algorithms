package hackerrank.algorithms.sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by mokarakaya on 12.06.2016.
 * https://www.hackerrank.com/challenges/quicksort2
 */
public class Quicksort {
    private static void sort(int[] ar,int low, int high) {
        if(low<high){
            int p=partition(ar,low,high);
            sort(ar, low, p - 1);
            sort(ar,p+1,high);
            printArray(ar, 0,ar.length-1);
        }
    }
    static int partition(int[] ar,int low,int high) {
        int pivot=low;
        for(int i=low+1;i<=high;i++){
            if(ar[i]<ar[pivot]){
                shift(ar,i,pivot);
                pivot++;
            }
        }

        return pivot;
    }

    static void printArray(int[] ar,int low,int high) {
        for(int i=low;i<=high;i++){
            System.out.print(ar[i]+" ");
        }
        System.out.println("");
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
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        sort(ar,0,ar.length-1);
    }


}
