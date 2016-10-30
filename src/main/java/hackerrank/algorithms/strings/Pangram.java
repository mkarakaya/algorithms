package hackerrank.algorithms.strings;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by mokarakaya on 30.10.2016.
 */
public class Pangram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.nextLine();
        String[] split = next.toLowerCase().split(" ");
        Set<Double> characterSet= new HashSet<>();
        for(String input:split){
            input.chars().asDoubleStream().forEach(character -> characterSet.add(character));
        }
        if(characterSet.size()==26){
            System.out.println("pangram");
        }else{
            System.out.println("not pangram");
        }
    }
}
