import java.util.*;

public class SmartCoursePlannerAndDependencyAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        int[] indegree = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
            indegree[v]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        ArrayList<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            int current = queue.poll();
            order.add(current);

            for (int next : graph.get(current)) {
                indegree[next]--;

                if (indegree[next] == 0)
                    queue.offer(next);
            }
        }

        if (order.size() != n) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println("Course Order:");

            for (int i = 0; i < order.size(); i++) {
                System.out.print(order.get(i));

                if (i < order.size() - 1)
                    System.out.print(" ");
            }
        }
    }
}
