package graphTheory;

import graphTheory.model.BFSNode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by p.bell on 26.06.2016.
 * https://www.hackerrank.com/challenges/bfsshortreach
 */
public class BreadthFirstSearchShortestReach {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("c:/temp/input01.txt"));
        int numberOfTests = in.nextInt();
        for (int i = 0; i < numberOfTests ; i++) {
            Map<Integer,BFSNode>nodes=new HashMap<>();
            int numberOfNodes=in.nextInt();
            for (int j = 1; j <= numberOfNodes; j++) {
                nodes.put(j,new BFSNode(j));
            }
            int numberOfEdges=in.nextInt();
            for (int j = 0; j < numberOfEdges; j++) {
                int x=in.nextInt();
                int y=in.nextInt();
                nodes.get(x).neighbours.add(y);
                nodes.get(y).neighbours.add(x);
            }
            int startNode=in.nextInt();
            bfs(nodes, nodes.get(startNode));
            String output="";
            for(Integer index: nodes.keySet()){
                if(index!=startNode){
                    int level = nodes.get(index).level;
                    output+=level == -1 ? level : level * 6;
                    output+=" ";
                }
            }
            output=output.trim();
            System.out.print(output);
            System.out.print("\n");
        }
    }

    private static void bfs(Map<Integer,BFSNode>nodes,BFSNode node) {
        Queue queue = new LinkedList();
        queue.add(node.index);
        node.level=0;
        while(!queue.isEmpty()) {
            node = nodes.get((int)queue.remove());
            List<Integer> neighbours = node.neighbours;
            for(int neighbour:neighbours){
                BFSNode neigbourNode = nodes.get(neighbour);
                if(neigbourNode.level==-1 || neigbourNode.level>node.level+1) {
                    neigbourNode.level= node.level+1;
                    queue.add(neighbour);
                }
            }
        }
    }



}
