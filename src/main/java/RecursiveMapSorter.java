import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by p.bell on 31.01.2016.
 */
public class RecursiveMapSorter {

    public Map<Integer,Object> sortMap(Map<Integer,Object> mapl,Map<Integer,Object> mapr,String lr){
        Map<Integer,Object> result= new HashMap<Integer, Object>();
        if("r".equals(lr)){
            putAll(result,mapl);
            putAll(result,mapr);
        }else{
            putAll(result,mapr);
            putAll(result,mapl);
        }
        return result;
    }

    private void putAll(Map<Integer, Object> result, Map<Integer, Object> map) {
        Iterator<Integer> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            Integer key = iterator.next();
            if(map.get(key) instanceof Map){
                putAll(result, (Map<Integer, Object>) map.get(key));
            }else{
                result.put(key,map.get(key));
            }
        }
    }
}
