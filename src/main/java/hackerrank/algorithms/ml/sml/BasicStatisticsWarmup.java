package hackerrank.algorithms.ml.sml;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by p.bell on 03.07.2016.
 */
public class BasicStatisticsWarmup {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("c:/temp/input01.txt"));
        //Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        double[] arr= new double[size];
        for(int i=0;i<size;i++){
            arr[i]=in.nextDouble();
        }
        insertionSort(arr);
        double mean=0;
        Map<Double,Integer> map= new HashMap<>();
        for(int i=0;i<size;i++){
            double number = arr[i];
            mean+=number;
            if(map.containsKey(number)){
                map.put(number,map.get(number)+1);
            }else{
                map.put(number,1);
            }
        }
        double mfIndex=-1;
        int mfValue=-1;
        Set<Double> set = map.keySet();
        for(Double key: set){
            Integer freq = map.get(key);
            if(freq>mfValue || (freq==mfValue&&mfIndex>key)){
                mfIndex=key;
                mfValue=freq;
            }
        }
        mean=mean/size;
        double median;
        if(size%2==1){
            median=arr[(size/2)];
        }else{
            median=(arr[(size/2)]+arr[(size/2)-1])/2;
        }

        double sd=0;
        for(int i=0;i<size;i++){
            sd+=Math.pow(arr[i]-mean,2);
        }
        sd=sd/size;
        sd=Math.pow(sd, 0.5);

        double ci=1.96 * sd / Math.sqrt(size);

        System.out.println(round(mean, 1));
        System.out.println(round(median,1));
        System.out.println(String.format("%.0f", round(mfIndex, 0)));
        System.out.println(round(sd,1));
        System.out.println(round(mean-ci,1) +" "+ round(mean+ci,1));
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }



    public static void insertionSort(double[] ar)
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
        }
    }

    private static void shift(double[] ar, int i, int j) {
        double value=ar[i];
        for(int k=i;k>j;k--){
            ar[k]=ar[k-1];
        }
        ar[j]=value;
    }
}
