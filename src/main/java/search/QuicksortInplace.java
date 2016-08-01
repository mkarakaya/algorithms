package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by p.bell on 12.06.2016.
 * https://www.hackerrank.com/challenges/quicksort3
 */
public class QuicksortInplace {
    private static void sort(int[] ar,int low, int high) {
        if(low<high){
            int p=partition(ar,low,high);
            printArray(ar, 0, ar.length - 1);
            sort(ar, low, p - 1);
            sort(ar,p+1,high);

        }
    }
    static int partition(int[] ar,int low,int high) {
        int bound=low;
        for(int i=low;i<high;i++){
            if(ar[i]<ar[high]){
                if(i!=bound) {
                    //shift(ar, i, bound);
                    int temp=ar[i];
                    ar[i]=ar[bound];
                    ar[bound]=temp;
                }
                bound++;
            }
        }
        int temp=ar[high];
        ar[high]=ar[bound];
        ar[bound]=temp;
        return bound;
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
