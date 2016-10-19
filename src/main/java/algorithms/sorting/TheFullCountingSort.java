package algorithms.sorting;

import java.util.*;

/**
 * Created by p.bell on 19.10.2016.
 */
public class TheFullCountingSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer,Integer> map= new HashMap<>();
        Map<Integer,StringBuilder> mapWords= new HashMap<>();
        for(int i=0;i<n;i++){
            int number = in.nextInt();
            String word= in.next();
            if(i<n/2) {
                map.putIfAbsent(number,0);
                map.put(number,map.get(number)+1);
            }else{
                mapWords.putIfAbsent(number,new StringBuilder());
                mapWords.get(number).append(word+" ");
            }

        }
        for(int i=0;i<100;i++){
            if(map.containsKey(i)) {
                for(int j=0;j<map.get(i);j++){
                    System.out.print( "- ");
                }
            }
            if(mapWords.containsKey(i)) {
                System.out.print(mapWords.get(i).toString());
            }
        }
    }
}
