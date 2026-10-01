import java.util.*;

public class ForestFireSpreadSimulator {
    static class Cell {
        int r;
        int c;

        Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] grid = new int[r][c];
        Queue<Cell> queue = new LinkedList<>();

        int trees = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = sc.nextInt();

                if (grid[i][j] == 2)
                    queue.offer(new Cell(i, j));
                else if (grid[i][j] == 1)
                    trees++;
            }
        }

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        int minutes = 0;

        while (!queue.isEmpty() && trees > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Cell current = queue.poll();

                for (int[] d : directions) {
                    int nr = current.r + d[0];
                    int nc = current.c + d[1];

                    if (nr >= 0 && nr < r && nc >= 0 && nc < c &&
                        grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                        trees--;

                        queue.offer(new Cell(nr, nc));
                    }
                }
            }

            minutes++;
        }

        if (trees == 0)
            System.out.println("Minutes = " + minutes);
        else
            System.out.println("Minutes = -1");
    }
}
