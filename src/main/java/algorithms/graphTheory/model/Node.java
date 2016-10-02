package algorithms.graphTheory.model;

/**
 * Created by p.bell on 02.02.2016.
 */
public class Node {
    public Node(int index){
        this.index=index;
        this.neighbours=new int[6];
        level=-1;
    }
    public int index;
    public int[] neighbours;
    public int level;
}
