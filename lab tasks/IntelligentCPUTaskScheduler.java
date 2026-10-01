import java.util.*;

public class IntelligentCPUTaskScheduler {
    static class Task {
        char name;
        int count;
        int readyTime;

        Task(char name, int count, int readyTime) {
            this.name = name;
            this.count = count;
            this.readyTime = readyTime;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        HashMap<Character, Integer> frequency = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char c = sc.next().charAt(0);
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Task> pq = new PriorityQueue<>(
            (a, b) -> b.count - a.count
        );

        for (Map.Entry<Character, Integer> entry : frequency.entrySet())
            pq.offer(new Task(entry.getKey(), entry.getValue(), 0));

        Queue<Task> cooldown = new LinkedList<>();

        int time = 0;
        int completed = 0;

        while (completed < n) {
            while (!cooldown.isEmpty() && cooldown.peek().readyTime <= time)
                pq.offer(cooldown.poll());

            if (!pq.isEmpty()) {
                Task task = pq.poll();
                task.count--;
                completed++;

                if (task.count > 0) {
                    task.readyTime = time + k + 1;
                    cooldown.offer(task);
                }

                time++;
            } else {
                time = cooldown.peek().readyTime;
            }
        }

        System.out.println(time);
    }
}
