package hackerrank.algorithms.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/missing-numbers
 * Created by mokarakaya on 19.06.2016.
 */
public class MissingNumbers {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("c:/temp/missingNumbers/input02.txt"));
        int size = in.nextInt();
        Map<Integer,Integer> firstMap=new HashMap<>();
        for (int k = 0; k < size; k++) {
            int value = in.nextInt();
            put(firstMap,value);
        }
        size = in.nextInt();
        Map<Integer,Integer> secondMap=new HashMap<>();
        for (int k = 0; k < size; k++) {
            int value = in.nextInt();
            put(secondMap,value);
        }
        Set<Integer> set = new HashSet<>();
        Iterator<Integer> iterator = secondMap.keySet().iterator();
        while(iterator.hasNext()){
            int next = iterator.next();
            Integer integer = firstMap.get(next);
            if(integer==null || !secondMap.get(next).equals(integer)){
                set.add(next);
            }
        }
        List<Integer> list=new ArrayList<>(set);
        Collections.sort(list);
        for(int value:list){
            System.out.print(value + " ");
        }


    }
    private  static void put(Map<Integer,Integer> map,int value){
        Integer freq = map.get(value);
        if(freq==null){
            map.put(value,1);
        }else{
            map.put(value,freq+1);
        }
    }
}
