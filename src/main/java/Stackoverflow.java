import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by p.bell on 29.05.2016.
 */
public class Stackoverflow {


    public static void main(String argv[]) throws IOException {
        Map<String,String> map= new HashMap<String, String>();

        map.put("asd","asd");
        map.put("asd2","asd2");
        map.put("objectId","objectIDValue");
        map.put("asd4","asd4");
        map.put("asd5","asd5");
        Stackoverflow s= new Stackoverflow();
        s.printMap(map);

    }

    public  void printMap(Map mp) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue() + " " + mp.get("objectId"));
        }
        it.remove(); // avoids a ConcurrentModificationException
    }
}
