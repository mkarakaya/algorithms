package algorithms.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by p.bell on 12.06.2016.
 * https://www.hackerrank.com/challenges/quicksort3
 */
public class ClosestNumbers {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("c:/temp/input01.txt"));
        int n = in.nextInt();
        double[] ar = new double[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextDouble();
        }
        sort(ar,0,ar.length-1);
        System.out.print(new DecimalFormat("#").format(ar[(ar.length/2)-1]) + " ");

    }

    private static void sort(double[] ar,int low, int high) {
        if(low<high){
            int p=partition(ar,low,high);
            sort(ar, low, p - 1);
            sort(ar,p+1,high);

        }
    }
    static int partition(double[] ar,int low,int high) {
        int bound=low;
        for(int i=low;i<high;i++){
            if(ar[i]<ar[high]){
                if(i!=bound) {
                    //shift(ar, i, bound);
                    double temp=ar[i];
                    ar[i]=ar[bound];
                    ar[bound]=temp;
                }
                bound++;
            }
        }
        double temp=ar[high];
        ar[high]=ar[bound];
        ar[bound]=temp;
        return bound;
    }





}
