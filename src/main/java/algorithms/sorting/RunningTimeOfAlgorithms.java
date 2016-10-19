package algorithms.sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by p.bell on 19.10.2016.
 */
public class RunningTimeOfAlgorithms {
    public static void insertionSort(int[] A){
        int count=0;
        for(int i = 1; i < A.length; i++){
            int value = A[i];
            int j = i - 1;
            while(j >= 0 && A[j] > value){
                A[j + 1] = A[j];
                count++;
                j = j - 1;
            }
            if(A[j + 1] != value){
                A[j + 1] = value;

            }

        }
        System.out.println(count);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        insertionSort(ar);
    }
}
