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
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        URL resource = StackExchangeQuestionClassifier.class.getClassLoader().getResource("training.json");
        Scanner in = new Scanner(new File(resource.getFile()));
        //Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int count=0;
        List<Datum<String,String>> trainingData = new ArrayList<>();
        JSONParser parser = new JSONParser();
        while(count!=size) {
            String json = in.nextLine();
            if(!"".equals(json)) {
                try {
                    List<String> features = new ArrayList<>();
                    JSONObject jsonObj = (JSONObject) parser.parse(json);
                    features.add("question="+jsonObj.get("question"));
                    features.add("excerpt="+jsonObj.get("excerpt"));
                    trainingData.add(new BasicDatum(features,jsonObj.get("topic")));


                }catch (Exception e){
                    System.out.println(e.getMessage());
                }finally {
                    count++;
                }

            }
        }
        Scanner cin = new Scanner(System.in);
        int cSize = cin.nextInt();
        List<BasicDatum> datums=new ArrayList<>();
        for(int i=0;i<cSize;i++){
            JSONObject jsonObj = (JSONObject) parser.parse(cin.next());
            List<String> features = new ArrayList<>();
            features.add("question="+jsonObj.get("question"));
            features.add("excerpt="+jsonObj.get("excerpt"));
            BasicDatum datum= new BasicDatum(features,null);
            datums.add(datum);
            trainingData.add(datum);
        }

        LinearClassifierFactory<String,String> factory = new LinearClassifierFactory<>();
        factory.useConjugateGradientAscent();
        // Turn on per-iteration convergence updates
        factory.setVerbose(true);
        //Small amount of smoothing
        factory.setSigma(10.0);
        LinearClassifier<String,String> classifier = factory.trainClassifier(trainingData);
        for(BasicDatum datum:datums){
            System.out.println(classifier.classOf(datum));
        }


    }
}
