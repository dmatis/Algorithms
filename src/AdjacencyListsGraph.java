import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AdjacencyListsGraph {

    private Map<Integer, List<Integer>> adjacencyList;

    public AdjacencyListsGraph(int numVertices) {
        adjacencyList = new HashMap<Integer, List<Integer>>();
        for (int i = 1; i <= numVertices; i++) {
            adjacencyList.put(i, new LinkedList<Integer>());
        }
    }

    public void setEdge(int source, int dest) {
        if (source > adjacencyList.size() || dest > adjacencyList.size())
        {
            System.out.println("Invalid vertex entered");
            return;
        }
        List<Integer> sourcelist = adjacencyList.get(source);
        sourcelist.add(dest);
        List<Integer> destlist = adjacencyList.get(dest);
        destlist.add(source);
    }

    public List<Integer> getEdge(int source) {
        if (source > adjacencyList.size()) {
            System.out.println("Invalid vertex entered");
            return null;
        }
        return adjacencyList.get(source);
    }
}
