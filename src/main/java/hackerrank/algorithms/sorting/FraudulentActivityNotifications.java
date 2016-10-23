package hackerrank.algorithms.sorting;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by p.bell on 19.10.2016.
 */
public class FraudulentActivityNotifications {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        //Scanner in = new Scanner(new File("c:/temp/input102.txt"));
        int n = in.nextInt();
        int d = in.nextInt();
        int[] arr= new int[n];
        int[] arrSorted= new int[d];
        Arrays.fill(arrSorted, -1);
        int count=0;
        for(int i=0;i<n;i++){
            int expenditure =in.nextInt();
            arr[i]=expenditure;
            int replace=-1;
            if(i>=d){
                replace=arr[i-d];
                //printArray(arrSorted);
                int median=arrSorted[(d/2)];
                if(d%2==0){
                    median+=arrSorted[(d/2)-1];
                }else{
                    median+=median;
                }
                if(expenditure>=median){
                    count++;
                }

            }
            replaceAndSort(arrSorted,arr[i],replace);

        }
        System.out.println(count);

    }



    private static void replaceAndSort(int[] arrSorted, int add, int remove) {
        int removeIndex=-1;
        for(int i=0;i<arrSorted.length;i++){
            if(remove==arrSorted[i]){
                removeIndex=i;
                break;
            }
        }


        if(remove<add){
            boolean replaced=false;
            for(int i=removeIndex+1;i<arrSorted.length;i++){
                if(add>arrSorted[i] ){
                    arrSorted[i-1]=arrSorted[i];
                }else{
                    arrSorted[i-1]=add;
                    replaced=true;
                    break;
                }
            }
            if(!replaced){
                arrSorted[arrSorted.length-1]=add;
            }
        }else if(remove>add){
            boolean replaced=false;
            for(int i=removeIndex;i>0;i--){
                if(add<arrSorted[i] ){
                    arrSorted[i]=arrSorted[i-1];
                }else{
                    arrSorted[i+1]=add;
                    replaced=true;
                    break;
                }
            }
            if(!replaced){
                if(add<arrSorted[0]){
                    arrSorted[0]=add;
                }else{
                    arrSorted[1]=add;
                }
            }
        }
    }


}
