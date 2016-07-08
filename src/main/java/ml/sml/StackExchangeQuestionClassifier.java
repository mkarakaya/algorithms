package ml.sml;


import edu.stanford.nlp.classify.LinearClassifier;
import edu.stanford.nlp.classify.LinearClassifierFactory;
import edu.stanford.nlp.ling.BasicDatum;
import edu.stanford.nlp.ling.Datum;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 212457624 on 04.07.2016.
 */
public class StackExchangeQuestionClassifier {
    public static boolean VALIDATE=true;
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        List<Datum<String,String>> trainingData = new ArrayList<>();
        JSONParser parser = new JSONParser();
        URL resource = StackExchangeQuestionClassifier.class.getClassLoader().getResource("training.json");
        Scanner cin = new Scanner(new File(resource.getFile()));
        int cSize = Integer.parseInt(cin.nextLine().trim());
        List<BasicDatum> datums=new ArrayList<>();
        addTraining(trainingData, parser, cin, cSize, datums,false);

        resource = StackExchangeQuestionClassifier.class.getClassLoader().getResource("test.json");
        cin = new Scanner(new File(resource.getFile()));
        //cin = new Scanner(System.in);
        cSize = Integer.parseInt(cin.nextLine().trim());
        addTraining(trainingData, parser, cin, cSize, datums,true);

        LinearClassifierFactory<String,String> factory = new LinearClassifierFactory<>();
        factory.useConjugateGradientAscent();
        // Turn on per-iteration convergence updates
        factory.setVerbose(false);
        //Small amount of smoothing
        //factory.setSigma(10.0);
        LinearClassifier<String,String> classifier = factory.trainClassifier(trainingData);
        if(VALIDATE) {
            resource = StackExchangeQuestionClassifier.class.getClassLoader().getResource("validate.txt");
            cin = new Scanner(new File(resource.getFile()));
            double count=0;
            for (BasicDatum datum : datums) {
                String result=cin.nextLine();
                String predicted=classifier.classOf(datum);
                if(result.equals(predicted)){
                    count++;
                }
                System.out.println(result+":"+predicted);
            }
            System.out.println("%"+(count/datums.size())+":"+count+"/"+datums.size());
        }else{
            for (BasicDatum datum : datums) {
                System.out.println(classifier.classOf(datum));
            }
        }

    }

    private static void addTraining(List<Datum<String, String>> trainingData, JSONParser parser,
                                    Scanner cin, int cSize, List<BasicDatum> datums,boolean save) throws ParseException {
        for(int i=0;i<cSize;i++){
            JSONObject jsonObj = (JSONObject) parser.parse(cin.nextLine());
            List<String> features = new ArrayList<>();
            features.add("question="+jsonObj.get("question"));
            features.add("excerpt="+jsonObj.get("excerpt"));
            BasicDatum datum= new BasicDatum(features,jsonObj.get("topic"));
            if(save) {
                datums.add(datum);
            }
            trainingData.add(datum);
        }
    }
}
