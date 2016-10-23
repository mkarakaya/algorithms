package hackerrank.algorithms.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/connected-cell-in-a-grid
 * Created by mokarakaya on 19.06.2016.
 */
public class ConnectedCellinaGrid {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("c:/temp/input01.txt"));
        int rows = in.nextInt();
        int columns = in.nextInt();
        int[][]ar= new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int k = 0; k < columns; k++) {
                ar[i][k]=in.nextInt();
            }
        }
        int largest=0;
        for (int i = 0; i < rows; i++) {
            for (int k = 0; k < columns; k++) {
                if(ar[i][k]==1) {
                    int count=0;
                    count=findRegion(ar, i, k,count);
                    largest=Math.max(largest,count);
                }
            }
        }
        System.out.println(largest);


    }

    private static int findRegion(int[][] ar, int i, int j,int count) {
        if(ar[i][j]==1){
            count++;
            ar[i][j]=2;
            for(int k=i-1;k<=i+1;k++){
                for(int l=j-1;l<=j+1;l++){
                    if(isFeasible(k,l,ar) && ar[k][l]==1){
                        count=findRegion(ar,k,l,count);
                    }
                }
            }
        }
        return count;
    }

    private static boolean isFeasible(int k, int l, int[][] ar) {
        return  k>=0&& l>=0 &&ar[0].length>l&& ar.length>k;
    }

}
