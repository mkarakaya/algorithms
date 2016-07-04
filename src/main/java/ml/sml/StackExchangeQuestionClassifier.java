package ml.sml;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by 212457624 on 04.07.2016.
 */
public class StackExchangeQuestionClassifier {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        URL resource = StackExchangeQuestionClassifier.class.getClassLoader().getResource("training.json");
        Scanner in = new Scanner(new File(resource.getFile()));
        //Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int count=0;
        JSONParser parser = new JSONParser();
        while(count!=size) {
            String json = in.nextLine();
            if(!"".equals(json)) {
                try {
                    JSONObject jsonObj = (JSONObject) parser.parse(json);
                    System.out.println(jsonObj.get("question"));
                    if (jsonObj.get("question").equals("Step down switching regulator heating up with light loads")) {
                        System.out.println("here");
                    }
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }finally {
                    count++;
                }

            }
        }
    }
}
