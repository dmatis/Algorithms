public class TreeTraversal {

    public static void preorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        root.printNodeValue();
        preorderTraversal(root.lchild);
        preorderTraversal(root.rchild);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.lchild = node2;
        node1.rchild = node3;

        preorderTraversal(node1);
    }
}
