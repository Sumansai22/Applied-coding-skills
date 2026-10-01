import java.util.*;

public class MuseumTreasureRoutePlanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        if (n == 1) {
            System.out.println(a[0]);
            return;
        }

        int[] dp = new int[n];

        dp[0] = a[0];
        dp[1] = Math.max(a[0], a[1]);

        for (int i = 2; i < n; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + a[i]);

        System.out.println(dp[n - 1]);
    }
}
