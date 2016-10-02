package algorithms.graphTheory;

import algorithms.graphTheory.model.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by p.bell on 26.06.2016.
 * https://www.hackerrank.com/challenges/the-quickest-way-up
 */
public class QuickestWayUp {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("c:/temp/input01.txt"));
        int numberOfTests = in.nextInt();
        for (int i = 0; i < numberOfTests ; i++) {
            Map<Integer,Integer> laddersMap=new HashMap<>();
            readData(in, laddersMap);
            Map<Integer,Integer> snakesMap=new HashMap<>();
            readData(in, snakesMap);
            Map<Integer,Node>nodes=new HashMap<>();
            createGraph(laddersMap, snakesMap, nodes);
            Node root = nodes.get(1);
            bfs(nodes,root);
            Node finalNode = nodes.get(100);
            System.out.println(finalNode==null ? -1 :finalNode.level);
        }
    }

    private static void bfs(Map<Integer,Node>nodes,Node node) {
        Queue queue = new LinkedList();
        queue.add(node.index);
        node.level=0;
        while(!queue.isEmpty()) {
            node = getNode(nodes,(int)queue.remove());
            int[] neighbours = node.neighbours;
            for(int neighbour:neighbours){
                Node neigbourNode = getNode(nodes, neighbour);
                if(neigbourNode.level==-1) {
                    neigbourNode.level= node.level+1;
                    queue.add(neighbour);
                }
            }
        }
    }

    private static void readData(Scanner in,Map<Integer,Integer> laddersMap){
        int numberOfLadders=in.nextInt();
        for (int j = 0; j < numberOfLadders ; j++) {
            int ladderFrom=in.nextInt();
            int ladderTo=in.nextInt();
            laddersMap.put(ladderFrom,ladderTo);
        }
    }
    private static void createGraph(Map<Integer, Integer> laddersMap, Map<Integer, Integer> snakesMap, Map<Integer, Node> nodes) {
        for(int j=0;j<100;j++){
            if(!laddersMap.containsKey(j)&& !snakesMap.containsKey(j)){
                Node node = getNode(nodes, j);
                for(int k=0;k<6;k++){
                    Integer ladder = laddersMap.get(j + k+1);
                    Integer snake = snakesMap.get(j + k+1);
                    if(ladder!=null){
                        getNode(nodes,ladder);
                        node.neighbours[k]=ladder;
                    }else if(snake!=null){
                        getNode(nodes,snake);
                        node.neighbours[k]=snake;
                    }else{
                        getNode(nodes,j+k+1);
                        node.neighbours[k]=j+k+1;
                    }
                }

            }
        }
    }

    private static Node getNode(Map<Integer, Node> nodes, int j) {
        Node node=nodes.get(j);
        if(node==null) {
            node=new Node(j);
            nodes.put(j,node);
        }
        return node;
    }
}
