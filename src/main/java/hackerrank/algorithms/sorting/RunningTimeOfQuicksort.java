package hackerrank.algorithms.sorting;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by mokarakaya on 19.10.2016.
 */
public class RunningTimeOfQuicksort {

    public static int QCount=0;
    public static int ICount=0;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        int[] clone = ar.clone();
        qsort(ar,0,ar.length-1);
        insertionSort(clone);
        System.out.println(ICount-QCount);

    }
    public static void insertionSort(int[] A){
        for(int i = 1; i < A.length; i++){
            int value = A[i];
            int j = i - 1;
            while(j >= 0 && A[j] > value){
                A[j + 1] = A[j];
                ICount++;
                j = j - 1;
            }
            if(A[j + 1] != value){
                A[j + 1] = value;

            }

        }
    }
    private static void qsort(int[] ar,int low, int high) {
        if(low<high){
            int p=partition(ar,low,high);
            qsort(ar, low, p - 1);
            qsort(ar,p+1,high);

        }
    }
    static int partition(int[] ar,int low,int high) {
        int pivot=ar[high];
        int j=low;
        for(int i=low;i<high;i++){
            if(ar[i]<pivot){
                int temp=ar[i];
                ar[i]=ar[j];
                ar[j]=temp;
                QCount++;
                j++;
            }
        }
        ar[high]=ar[j];
        ar[j]=pivot;
        QCount++;
        return j;
    }

}
