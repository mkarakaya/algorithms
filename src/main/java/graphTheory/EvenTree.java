package graphTheory;

import graphTheory.model.BFSNode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by p.bell on 26.06.2016.
 * https://www.hackerrank.com/challenges/even-tree
 */
public class EvenTree {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("c:/temp/input01.txt"));
        Map<Integer,BFSNode>nodes=new HashMap<>();
        int numberOfNodes=in.nextInt();
        for (int j = 1; j <= numberOfNodes; j++) {
            nodes.put(j, new BFSNode(j));
        }
        int numberOfEdges=in.nextInt();
        for (int j = 0; j < numberOfEdges; j++) {
            int x=in.nextInt();
            int y=in.nextInt();
            if(x<y){
                nodes.get(x).neighbours.add(y);
            }else{
                nodes.get(y).neighbours.add(x);
            }


        }
        int result=bfs(nodes, nodes.get(1));
        System.out.print(result);

    }

    private static int bfs(Map<Integer,BFSNode>nodes,BFSNode node) {
        Queue queue = new LinkedList();
        queue.add(node.index);
        int remove=0;
        while(!queue.isEmpty()) {
            node = nodes.get((int)queue.remove());
            List<Integer> neighbours = node.neighbours;
            for(int neighbour:neighbours){
                BFSNode neigbourNode = nodes.get(neighbour);
                if(neigbourNode.level!=1) {
                    queue.add(neighbour);
                    neigbourNode.level= 1;
                    int numberOfChildren = getNumberOfChildren(nodes, neigbourNode);
                    if (numberOfChildren % 2 == 1) {
                        remove++;
                    }
                }
            }
        }
        return remove;
    }

    private static int getNumberOfChildren(Map<Integer, BFSNode> nodes, BFSNode node) {
        int[]visited=new int[nodes.size()+1];
        Queue queue = new LinkedList();
        queue.add(node.index);
        visited[node.level]=1;
        int numberOfChildren=0;
        while(!queue.isEmpty()) {
            node = nodes.get((int)queue.remove());
            List<Integer> neighbours = node.neighbours;
            for(int neighbour:neighbours){
                if(visited[neighbour]!=1) {
                    queue.add(neighbour);
                    visited[neighbour] = 1;
                    numberOfChildren++;
                }
            }
        }
        return numberOfChildren;
    }


}
