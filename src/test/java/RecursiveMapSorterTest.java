import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by p.bell on 31.01.2016.
 */
public class RecursiveMapSorterTest extends TestCase {

    public void testApp(){

        Map<Integer,Object> mapr=new HashMap<Integer, Object>();
        mapr.put(1,"1r");
        mapr.put(2,"2r");

        Map<Integer,Object> mapr2=new HashMap<Integer, Object>();
        mapr2.put(4,"4r");
        mapr2.put(5,"5r");


        Map<Integer,Object> mapr3=new HashMap<Integer, Object>();
        mapr3.put(6,"6r");
        mapr3.put(7,"7r");
        mapr2.put(1,mapr3);
        mapr.put(3,mapr2);

        Map<Integer,Object> mapl=new HashMap<Integer, Object>();
        mapl.put(1,"1l");
        mapl.put(2,"2l");
        mapl.put(3,"3l");
        mapl.put(5,"5l");
        Map<Integer,Object> mapl2=new HashMap<Integer, Object>();
        mapl2.put(6,"6l");
        mapl.put(6,mapl2);

        RecursiveMapSorter sorter= new RecursiveMapSorter();
        Map<Integer, Object> result = sorter.sortMap(mapl, mapr, "r");
        Iterator<Integer> iterator = result.keySet().iterator();
        while(iterator.hasNext()){
            int key=iterator.next();
            System.out.println(key+":"+result.get(key));
        }

        assert(true);
    }
}
