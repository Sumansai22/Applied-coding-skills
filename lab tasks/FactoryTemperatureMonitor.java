import java.util.*;

public class FactoryTemperatureMonitor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        int[] result = new int[n];

        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= a[i])
                stack.pop();

            if (!stack.isEmpty())
                result[i] = stack.peek();

            stack.push(a[i]);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(result[i]);

            if (i < n - 1)
                System.out.print(" ");
        }
    }
}
