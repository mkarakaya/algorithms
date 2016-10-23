package javaStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by p.bell on 18.08.2016.
 * this example folds a list by adding value of the the first element to rest of the list and removes the first element
 * until we have only one element in the list.
 * ex:
 * lets say we have 2,5,4 on the list. in the first iteration we will have;
 * 7,6 (2 is added to rest of the elements in the list and then removed.) then;
 * 13
 * since we have only 13 in the list, we return 13
 */

public class FoldList {

    public static void main(String[] args) {
        List<Integer> data1 = Arrays.asList(2,5,4);
        FoldList obj = new FoldList();
        int result = obj.fold(data1);
        System.out.println(result);
    }

    private int fold(final List<Integer> input) {
        if(input.size()<=1){
            return input.get(0);
        }
        return fold(IntStream.range(1, input.size())
                .mapToObj(i -> input.get(i) + input.get(0))
                .collect(Collectors.toList()));
    }
}
