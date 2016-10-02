package algorithms.ml.botBuilding;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by 212457624 on 03.07.2016.
 */
public class BotClean {

    static void next_move(int posr, int posc, int dimh, int dimw, String[] board){
        int nr=-1;
        int nc=-1;
        double nearest=Double.MAX_VALUE;
        for(int i=0;i<board.length;i++){
            char[] chars = board[i].toCharArray();
            for(int j=0;j<chars.length;j++){
                if('d'==chars[j]){
                    double distance=Math.pow(posr-i,2)+ Math.pow(posc-j ,2);
                    if(distance<nearest){
                        nearest=distance;
                        nr=i;
                        nc=j;
                    }
                }
            }
        }

        if(nr==posr && nc==posc){
            System.out.println("CLEAN");
        }else{
            if (nr < posr) {
                System.out.println("UP");
            } else if (nr > posr) {
                System.out.println("DOWN");
            } else if (nc < posc) {
                System.out.println("LEFT");
            } else if (nc > posc) {
                System.out.println("RIGHT");
            }
        }


    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("c:/tmp/input01.txt"));
        //Scanner in = new Scanner(System.in);
        int [] pos = new int[2];
        String board[] = new String[5];
        for(int i=0;i<2;i++) pos[i] = in.nextInt();
        for(int i=0;i<5;i++) board[i] = in.next();
        next_move(pos[0], pos[1],-1,-1, board);
    }
}
