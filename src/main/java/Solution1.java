import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by p.bell on 19.02.2016.
 */
public class Solution1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("c:/temp/input01.txt"));
        int arraySize = sc.nextInt();
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = sc.nextInt();
        }
        int[] sortedArray = insertIntoSorted(array.clone());
        List<Integer> different = new ArrayList<Integer>();
        for (int i = 0; i < sortedArray.length; i++) {
            if (sortedArray[i] != array[i]) {
                different.add(i);
            }
        }
        if (different.size() == 0 || different.size() == 2) {
            System.out.println("yes");
            if (different.size() == 2) {
                System.out.println("swap " + (different.get(0) + 1) + " " + (different.get(1) + 1));
            }
        } else {
            boolean reversable = true;
            for (int i = different.get(0); i < different.get(different.size() - 1); i++) {
                if (array[i] != sortedArray[sortedArray.length - 1 - i]) {
                    reversable = false;
                    break;
                }
            }
            if (reversable) {
                System.out.println("yes");
                System.out.println("reverse " + (different.get(0) + 1) + " " + (different.get(different.size() - 1) + 1));
            } else {
                System.out.println("no");
            }
        }
    }

    public static int[] insertIntoSorted(int[] ar) {
        for (int i = 1; i < ar.length; i++) {
            int number = ar[i];
            int j = i;
            while (j > 0 && ar[j - 1] > number) {
                ar[j] = ar[j - 1];
                j--;
            }
            ar[j] = number;
        }
        return ar;
    }
}