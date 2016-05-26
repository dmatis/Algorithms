import java.util.Set;
import java.util.TreeSet;

public class Vertex implements Comparable<Vertex> {

    int value;
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

    @Override
    public int compareTo(Vertex o) {
        return (this.value == o.value) ? 0 : 1;
    }
}
