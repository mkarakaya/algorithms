package ml.botBuilding;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by 212457624 on 02.07.2016.
 */
public class BotSavesPrincess2 {

    static void nextMove(int n, int r, int c, String[] grid) {
        int px = -1;
        int py = -1;
        int y = -1;
        int x = -1;
        for (int i = 0; i < n; i++) {
            String input = grid[i];
            char[] chars = input.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if ('p' == chars[j]) {
                    px = j;
                    py = i;
                }else if('m'==chars[j]){
                    x = j;
                    y = i;
                }
            }
        }
        if (px < x) {
            System.out.println("LEFT");
        } else if (px > x) {
            System.out.println("RIGHT");
        } else if (py < y) {
            System.out.println("UP");
        } else if (py > y) {
            System.out.println("DOWN");
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("c:/tmp/input01.txt"));
        //Scanner in = new Scanner(System.in);
        int n, r, c;
        n = in.nextInt();
        r = in.nextInt();
        c = in.nextInt();
        in.useDelimiter("\n");
        String grid[] = new String[n];


        for (int i = 0; i < n; i++) {
            grid[i] = in.next();
        }

        nextMove(n, r, c, grid);

    }
}
