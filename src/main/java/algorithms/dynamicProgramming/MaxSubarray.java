package algorithms.dynamicProgramming;

/**
 * https://en.wikipedia.org/wiki/Maximum_subarray_problem
 * Created by p.bell on 19.02.2016.
 */
public class MaxSubarray {
    public int getMax(int[] numbers) {
        int maxEndingHere = numbers[0];
        int maxSoFar = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            maxEndingHere = Math.max(numbers[i], maxEndingHere + numbers[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
