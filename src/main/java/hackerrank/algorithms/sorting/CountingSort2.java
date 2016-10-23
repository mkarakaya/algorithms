package hackerrank.algorithms.sorting;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by p.bell on 19.10.2016.
 */
public class CountingSort2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<n;i++){
            int number = in.nextInt();
            map.putIfAbsent(number,0);
            map.put(number,map.get(number)+1);
        }
        for(int i=0;i<100;i++){
            if(map.containsKey(i)) {
                for(int j=0;j<map.get(i);j++)
                System.out.print(i + " ");
            }
        }
    }
}
