import junit.framework.TestCase;
import search.Dijkstra;

/**
 * Created by p.bell on 19.02.2016.
 */
public class DijkstraTest extends TestCase {

    public void test(){
        System.out.println();
        Dijkstra dijkstra= new Dijkstra();
        int numberOfNodes=3;
        boolean[][]edges=new boolean[numberOfNodes][numberOfNodes];
        edges[1][2]=true;
        edges[2][1]=true;
        int startNode=2;
        int[] shortestPaths = dijkstra.getShortestPaths(edges, startNode);
        int[] expected=new int[]{Integer.MAX_VALUE,1,0};
        assertEquals(expected.length,shortestPaths.length);
        for(int i=0;i<shortestPaths.length;i++){
            assertEquals(expected[i],shortestPaths[i]);

        }
    }

    public void testOther(){
        Dijkstra dijkstra= new Dijkstra();
        int numberOfNodes=5;
        boolean[][]edges=new boolean[numberOfNodes][numberOfNodes];
        edges[0][1]=true;
        edges[1][0]=true;

        edges[0][2]=true;
        edges[2][0]=true;

        edges[1][3]=true;
        edges[3][1]=true;

        edges[2][4]=true;
        edges[4][2]=true;

        edges[3][4]=true;
        edges[4][3]=true;
        int startNode=0;
        int[] shortestPaths = dijkstra.getShortestPaths(edges, startNode);
        int[] expected=new int[]{0,1,1,2,2};
        assertEquals(expected.length,shortestPaths.length);
        for(int i=0;i<shortestPaths.length;i++){
            assertEquals(expected[i],shortestPaths[i]);

        }
    }
}

