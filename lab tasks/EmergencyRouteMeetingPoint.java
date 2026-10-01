import java.util.*;

public class EmergencyRouteMeetingPoint {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static Node buildTree(int[] a) {
        if (a.length == 0 || a[0] == -1)
            return null;

        Node root = new Node(a[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (i < a.length) {
            Node current = queue.poll();

            if (i < a.length && a[i] != -1) {
                current.left = new Node(a[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < a.length && a[i] != -1) {
                current.right = new Node(a[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    static Node lca(Node root, int a, int b) {
        if (root == null || root.data == a || root.data == b)
            return root;

        Node left = lca(root.left, a, b);
        Node right = lca(root.right, a, b);

        if (left != null && right != null)
            return root;

        return left != null ? left : right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int node1 = sc.nextInt();
        int node2 = sc.nextInt();

        Node root = buildTree(a);
        Node result = lca(root, node1, node2);

        System.out.println("LCA = " + result.data);
    }
}
