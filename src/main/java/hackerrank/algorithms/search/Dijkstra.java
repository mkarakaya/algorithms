package hackerrank.algorithms.search;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by p.bell on 19.02.2016.
 */
public class Dijkstra {

    public  int[]getShortestPaths(boolean[][]edges,int startNode){
        int[] distances=new int[edges.length];
        boolean[] processed=new boolean[edges.length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startNode]=0;
        walk(edges, startNode, distances, processed);
        return distances;
    }

    private void walk(boolean[][] edges, int startNode, int[] distances, boolean[] processed) {
        LinkedList<Integer> willWalk= new LinkedList<Integer>();
        for (int i=0;i<edges.length;i++){
            if(startNode!=i&&edges[startNode][i]  ){
                int newDistance=distances[startNode]+1;
                if(distances[i]>newDistance){
                    distances[i]=newDistance;
                }
                if(!processed[i]) {
                    willWalk.add(i);
                }
            }
        }
        processed[startNode]=true;
        while(!willWalk.isEmpty()){
            walk(edges,willWalk.pop(),distances,processed);
        }
    }
}
