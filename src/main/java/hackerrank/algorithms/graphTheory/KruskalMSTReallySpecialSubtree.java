package hackerrank.algorithms.graphTheory;

import projectEuler.util.Edge;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by mokarakaya on 24.10.2016.
 */
public class KruskalMSTReallySpecialSubtree {
    public static void main(String[] args) throws FileNotFoundException {

        KruskalMSTReallySpecialSubtree t = new KruskalMSTReallySpecialSubtree();
        List<Edge> list= new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numberOfEdges= Integer.parseInt(scanner.nextLine().split(" ")[1]);
        for(int j=0;j<numberOfEdges;j++){
            String[] split = scanner.nextLine().split(" ");
            list.add(new Edge(Integer.parseInt(split[0])
                    ,Integer.parseInt(split[1])
                    ,Integer.parseInt(split[2])));
        }
        list.sort((edge1,edge2)->edge1.cost-edge2.cost);
        System.out.println(t.solution(list));
    }

    private int solution(List<Edge> list) {
        //keeps nodeId,graphId -> so, finding graph of the node is O(1)
        Map<Integer, Integer> nodes=new HashMap<>();
        //keeps graphId, graph
        Map<Integer, List<Edge>>graphs=new HashMap<>();
        for (Edge edge : list) {
            Integer firstGraphId = nodes.get(edge.nodes[0]);
            Integer secondGraphId = nodes.get(edge.nodes[1]);
            if(firstGraphId ==null && secondGraphId ==null){
                nodes.put(edge.nodes[0],edge.nodes[0]);
                nodes.put(edge.nodes[1],edge.nodes[0]);
                List<Edge> graphList=new ArrayList<>();
                graphList.add(edge);
                graphs.put(edge.nodes[0],graphList);
            }else if(firstGraphId ==null ){
                nodes.put(edge.nodes[0], secondGraphId);
                graphs.get(secondGraphId).add(edge);
            }else if(secondGraphId ==null){
                nodes.put(edge.nodes[1], firstGraphId);
                graphs.get(firstGraphId).add(edge);
            }else if(!firstGraphId.equals(secondGraphId)){
                merge(nodes,edge,graphs);
            }

        }

        //we have only one graph which is minimum spanning tree.
        int sum = graphs.get(graphs.keySet().iterator().next())
                .stream().mapToInt(edge -> edge.cost).sum();
        return sum;
    }

    private void merge(Map<Integer, Integer> nodes, Edge edge, Map<Integer, List<Edge>> graphs) {
        final Integer firstGraphId = nodes.get(edge.nodes[0]);
        final Integer secondGraphId = nodes.get(edge.nodes[1]);
        graphs.get(firstGraphId).addAll(graphs.get(secondGraphId));
        graphs.get(firstGraphId).add(edge);
        graphs.remove(secondGraphId);
        List<Integer> collect = nodes.entrySet().stream()
                .filter(map -> map.getValue().equals(secondGraphId))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        for(int key: collect){
            nodes.put(key, firstGraphId);
        }

    }
}
