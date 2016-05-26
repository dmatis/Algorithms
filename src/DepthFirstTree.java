import java.util.Iterator;
import java.util.Stack;

public class DepthFirstTree {
    Vertex root;

    public DepthFirstTree(Vertex root) {
        this.root = root;
    }

    public void traverse(Vertex start) {
        Stack<Vertex> verticesToVisit = new Stack<Vertex>();
        verticesToVisit.push(start);

        while (!verticesToVisit.empty()) {
            Vertex currVertex = verticesToVisit.peek();
            if (!currVertex.visited) {
                currVertex.visit();
            }

            Iterator<Vertex> iter = currVertex.adjVertices.iterator();
            if (!iter.hasNext()) {
                verticesToVisit.pop();
            } else {
                while (iter.hasNext()) {
                    Vertex v = iter.next();
                    if (!v.visited) {
                        verticesToVisit.push(v);
                        break;
                    }
                    //No more remaining unvisited adjVertices
                    if (!iter.hasNext()) {
                        verticesToVisit.pop();
                    }
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
        a.addAdjacent(d);
        a.addAdjacent(g);

        b.addAdjacent(e);
        b.addAdjacent(a);
        b.addAdjacent(f);

        c.addAdjacent(f);
        c.addAdjacent(h);

        d.addAdjacent(a);
        d.addAdjacent(f);

        e.addAdjacent(b);
        e.addAdjacent(g);

        f.addAdjacent(b);
        f.addAdjacent(c);
        f.addAdjacent(d);

        g.addAdjacent(a);
        g.addAdjacent(e);

        DepthFirstTree tree = new DepthFirstTree(a);
        tree.traverse(a);
    }
}


