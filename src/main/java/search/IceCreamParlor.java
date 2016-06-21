package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/icecream-parlor
 * Created by p.bell on 19.06.2016.
 */
public class IceCreamParlor {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("c:/temp/input01.txt"));
        int test = in.nextInt();
        for(int i=0;i<test;i++){
            List<Integer> results= new ArrayList<Integer>();
            int amount = in.nextInt();
            int flavors = in.nextInt();
            Map<Integer,List<Integer>> map = new HashMap();
            for (int k = 0; k < flavors; k++) {
                int flavorAmount=in.nextInt();
                if(!map.containsKey(flavorAmount)){
                    List<Integer>list= new ArrayList<Integer>();
                    list.add(k+1);
                    map.put(flavorAmount,list);
                }else{
                    map.get(flavorAmount).add(k+1);
                }
            }
            Set<Integer> set = map.keySet();
            for(int flavorAmount: set){
                if(flavorAmount<amount){
                    List<Integer> flavorsIndex = map.get(flavorAmount );
                    for(int flavorIndex:flavorsIndex){
                        List<Integer> secondFlavors = map.get(amount - flavorAmount);
                        if(secondFlavors!=null){
                            for(int secondFlavor: secondFlavors){
                                if(flavorIndex<secondFlavor){
                                    results.add(flavorIndex);
                                    results.add(secondFlavor);
                                }
                            }
                        }
                    }

                }
            }

            for(int result:results){
                System.out.print(result+" ");
            }
            System.out.println();
        }

    }
}
