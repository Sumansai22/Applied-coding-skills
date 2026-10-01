import java.util.*;

public class EventHallReservationManager {
    static class Event {
        int start;
        int end;

        Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Event[] events = new Event[n];

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            events[i] = new Event(start, end);
        }

        Arrays.sort(events, Comparator.comparingInt(e -> e.end));

        int count = 0;
        int lastEnd = Integer.MIN_VALUE;

        for (Event event : events) {
            if (event.start >= lastEnd) {
                count++;
                lastEnd = event.end;
            }
        }

        System.out.println("MaximumEvents = " + count);
    }
}
