import hackerrank.algorithms.dynamicProgramming.MaxSubarray;
import junit.framework.TestCase;

/**
 * Created by mokarakaya on 20.02.2016.
 */
public class MaxSubarrayTest  extends TestCase {

    public void test(){
        int[] numbers= new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaxSubarray maxSubarray= new MaxSubarray();
        int max = maxSubarray.getMax(numbers);
        assertEquals(6,max);
    }
}
