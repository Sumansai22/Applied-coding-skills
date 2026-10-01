import java.util.*;

public class MultiCityDeliveryOptimizationSystem {
    static class Element {
        int value;
        int list;
        int index;

        Element(int value, int list, int index) {
            this.value = value;
            this.list = list;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int k = sc.nextInt();

        int[][] lists = new int[m][];

        PriorityQueue<Element> pq = new PriorityQueue<>(
            Comparator.comparingInt(e -> e.value)
        );

        for (int i = 0; i < m; i++) {
            int size = sc.nextInt();
            lists[i] = new int[size];

            for (int j = 0; j < size; j++)
                lists[i][j] = sc.nextInt();

            if (size > 0)
                pq.offer(new Element(lists[i][0], i, 0));
        }

        ArrayList<Integer> merged = new ArrayList<>();
        PriorityQueue<Integer> topK = new PriorityQueue<>();

        while (!pq.isEmpty()) {
            Element current = pq.poll();

            merged.add(current.value);
            topK.offer(current.value);

            if (topK.size() > k)
                topK.poll();

            int nextIndex = current.index + 1;

            if (nextIndex < lists[current.list].length) {
                pq.offer(new Element(
                    lists[current.list][nextIndex],
                    current.list,
                    nextIndex
                ));
            }
        }

        ArrayList<Integer> top = new ArrayList<>();

        while (!topK.isEmpty())
            top.add(topK.poll());

        Collections.reverse(top);

        System.out.println("Merged:");

        for (int i = 0; i < merged.size(); i++) {
            System.out.print(merged.get(i));

            if (i < merged.size() - 1)
                System.out.print(" ");
        }

        System.out.println();
        System.out.println("TopK:");

        for (int i = 0; i < top.size(); i++) {
            System.out.print(top.get(i));

            if (i < top.size() - 1)
                System.out.print(" ");
        }
    }
}
