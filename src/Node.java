
public class Node {

    int value;
    Node lchild;
    Node rchild;

    public Node(int value) {
        this.value = value;
        this.lchild = null;
        this.rchild = null;
    }

    public void printNodeValue() {
        System.out.println(this.value);
    }
}
