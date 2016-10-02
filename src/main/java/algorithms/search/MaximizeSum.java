package algorithms.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/maximize-sum
 * Created by p.bell on 19.06.2016.
 */
public class MaximizeSum {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("c:/temp/input14.txt"));
        int test = in.nextInt();
        for(int i=0;i<test;i++){
            int size = in.nextInt();
            double modulo = in.nextDouble();
            TreeSet<Double> set =new TreeSet<>();
            Map<Double,int[]> map=new HashMap<>();
            double currentModule=0;
            for (int k = 0; k < size; k++) {
                double value=in.nextDouble();
                currentModule=((value%modulo)+currentModule)%modulo;
                set.add(currentModule);
                int[] bound = map.get(currentModule);
                if(bound==null){
                    bound=new int[2];
                    bound[0]=k;
                    bound[1]=k;
                    map.put(currentModule,bound);

                }else{
                    if(k<bound[0]){
                        bound[0]=k;
                    }else if(k>bound[1]){
                        bound[1]=k;
                    }
                }


            }
            double max=0;
            if(set.size()>0) {
                Iterator<Double> iterator = set.iterator();
                double first=iterator.next();
                max=first;
                int[] firstBound = map.get(first);
                while(iterator.hasNext()) {
                    double second=iterator.next();
                    int[] secondBound = map.get(second);
                    if (firstBound[1] > secondBound[0]) {
                        max = Math.max(max, modulo-(second- first ));
                    }
                    max = Math.max(max, second);
                    first=second;
                    firstBound=secondBound;
                }
            }
            System.out.printf("%.0f\n", max);

        }

    }

}
