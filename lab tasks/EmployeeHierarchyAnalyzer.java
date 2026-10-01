import java.util.*;

public class EmployeeHierarchyAnalyzer {
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

    static int height(Node root) {
        if (root == null)
            return -1;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    static int levels(Node root) {
        if (root == null)
            return 0;

        return 1 + Math.max(levels(root.left), levels(root.right));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        Node root = buildTree(a);

        System.out.println("Height = " + height(root));
        System.out.println("Levels = " + levels(root));
    }
}
