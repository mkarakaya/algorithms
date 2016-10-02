package algorithms.ml.botBuilding;
import java.util.*;

/**
 * Created by 212457624 on 02.07.2016.
 */
public class BotSavesPrincess {

    static void displayPathtoPrincess(int n, String[] grid) {
        int m = (n - 1) / 2;
        int px = -1;
        int py = -1;
        String gridString = grid[0];
        if (gridString.substring(0, 1).equals("p")) {
            px = 0;
            py = 0;
        } else if (gridString.substring(gridString.length() - 1, gridString.length()).equals("p")) {
            px = gridString.length() - 1;
            py = 0;
        }
        gridString = grid[grid.length - 1];
        if (gridString.substring(0, 1).equals("p")) {
            px = 0;
            py = gridString.length() - 1;
        } else if (gridString.substring(gridString.length() - 1, gridString.length()).equals("p")) {
            px = gridString.length() - 1;
            py = gridString.length() - 1;
        }

        for (int i = 0; i < py - m; i++) {
            System.out.println("DOWN");
        }
        for (int i = 0; i < m - py; i++) {
            System.out.println("UP");
        }
        for (int i = 0; i < px - m; i++) {
            System.out.println("RIGHT");
        }
        for (int i = 0; i < m - px; i++) {
            System.out.println("LEFT");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m;
        m = in.nextInt();
        String grid[] = new String[m];
        for (int i = 0; i < m; i++) {
            grid[i] = in.next();
        }

        displayPathtoPrincess(m, grid);
    }

}
