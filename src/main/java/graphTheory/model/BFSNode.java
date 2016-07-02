package graphTheory.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by p.bell on 02.02.2016.
 */
public class BFSNode {
    public BFSNode(int index){
        this.index=index;
        this.neighbours=new ArrayList<>();
        level=-1;
    }
    public int index;
    public List<Integer> neighbours;
    public int level;
}
