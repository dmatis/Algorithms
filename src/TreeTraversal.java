public class TreeTraversal {

    public static void preorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        root.printNodeValue();
        preorderTraversal(root.lchild);
        preorderTraversal(root.rchild);
    }

    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.lchild);
        root.printNodeValue();
        inorderTraversal(root.rchild);
    }

    public static void postorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.lchild);
        postorderTraversal(root.rchild);
        root.printNodeValue();
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.lchild = node2;
        node1.rchild = node3;
        node2.lchild = node4;
        node2.rchild = node5;
        node3.lchild = node6;
        node3.rchild = node7;

        BinaryTreePrinter.printNode(node1);

        System.out.println("----PreOrder Traversal----");
        preorderTraversal(node1);
        System.out.println("----InOrder Traversal----");
        inorderTraversal(node1);
        System.out.println("----PostOrder Traversal----");
        postorderTraversal(node1);
    }
}
