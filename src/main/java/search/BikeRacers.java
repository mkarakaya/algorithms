package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by p.bell on 26.06.2016.
 */
public class BikeRacers {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("c:/temp/input01.txt"));
        int bikers= in.nextInt();
        int bikes= in.nextInt();
        int limit=in.nextInt();
        Map<Integer,double[]> bikesCoor=new HashMap<>();
        for (int i = 0; i < bikes; i++) {
            double[] coor=new double[2];
            coor[0]=in.nextDouble();
            coor[1]=in.nextDouble();
            bikesCoor.put(i,coor);
        }

        Map<Integer,int[][]> bikesNearest=new HashMap<>();
        for (int i = 0; i < bikers; i++) {
            double[][] nearest=new double[2][limit];
            double x=in.nextDouble();
            double y=in.nextDouble();
            updateNearests(bikesNearest,bikesCoor,x,y);
        }


    }

    private static void updateNearests(Map<Integer, int[][]> bikesNearest, Map<Integer, double[]> bikesCoor, double x, double y) {

    }
}
