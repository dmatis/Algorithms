import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstTree {

    Vertex root;

    public BreadthFirstTree(Vertex root) {
        this.root = root;
    }

    public void traverse(Vertex start) {
        Queue<Vertex> nextVertices = new LinkedList<Vertex>();
        nextVertices.add(start);
        while (!nextVertices.isEmpty()) {
            Vertex currVertex = nextVertices.remove();
            currVertex.visit();

            Iterator<Vertex> iter = currVertex.adjVertices.iterator();
            while (iter.hasNext()) {
                //Add all adjacent vertices to Queue
                Vertex currAdjVertex = iter.next();
                if (!currAdjVertex.visited && !nextVertices.contains(currAdjVertex)) {
                    nextVertices.add(currAdjVertex);
                }
            }
        }
    }

    public static void main(String[] args) {

        Vertex a = new Vertex(1);
        Vertex b = new Vertex(2);
        Vertex c = new Vertex(3);
        Vertex d = new Vertex(4);
        Vertex e = new Vertex(5);
        Vertex f = new Vertex(6);
        Vertex g = new Vertex(7);
        Vertex h = new Vertex(8);

        a.addAdjacent(b);
        a.addAdjacent(g);
        a.addAdjacent(d);

        b.addAdjacent(e);
        b.addAdjacent(f);
        b.addAdjacent(a);

        c.addAdjacent(h);
        c.addAdjacent(f);

        d.addAdjacent(a);
        d.addAdjacent(f);

        e.addAdjacent(b);
        e.addAdjacent(g);

        f.addAdjacent(b);
        f.addAdjacent(c);
        f.addAdjacent(d);

        g.addAdjacent(a);
        g.addAdjacent(e);

        BreadthFirstTree tree = new BreadthFirstTree(a);
        tree.traverse(a);
    }
}




