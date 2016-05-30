import java.util.Set;
import java.util.TreeSet;

public class Vertex implements Comparable<Vertex> {

    Integer value;
    boolean visited = false;
    Set<Vertex> adjVertices;

    public Vertex(int value) {
        this.value = value;
        adjVertices = new TreeSet<Vertex>();
    }

    public int visit() {
        visited = true;
        System.out.println("Vertex " + value + " visited");
        return value;
    }

    public void addAdjacent(Vertex v) {
        adjVertices.add(v);
    }

    public void removeAdjacent(Vertex v) {
        adjVertices.remove(v);
    }

    public int compareTo(Vertex v) {
        int vertexCompare = value.compareTo(v.value);
        return (vertexCompare != 0) ? vertexCompare : 0;
    }
}
