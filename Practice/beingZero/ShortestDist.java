package beingZero;

import java.util.*;

class Pos {
    int i, j, dist;

    public Pos(int i, int j, int d) {
        this.i = i;
        this.j = j;
        this.dist = d;
    }
}

class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int r = sc.nextInt(), c = sc.nextInt();
        int[][] m = new int[r][c];
        int si = sc.nextInt(), sj = sc.nextInt();

        bfs(m, si, sj);

        for (int i = 0; i < r; i++) { // Print adj matrix.
            for (int j = 0; j < c; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }

    }

    static int[] di = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dj = { 0, 1, 1, 1, 0, -1, -1, -1 };

    static void bfs(int[][] m, int si, int sj) {
        int r = m.length, c = m[0].length;
        Queue<Pos> q = new LinkedList<>(); // deque
        q.add(new Pos(si, sj, 1));
        m[si][sj] = -1; // -1 is visited
        while (!q.isEmpty()) {
            Pos f = q.remove();
            m[f.i][f.j] = f.dist;

            for (int x = 0; x < 8; x++) {
                int ni = f.i + di[x], nj = f.j + dj[x];
                if (ni >= 0 && nj >= 0 && ni < r && nj < c && m[ni][nj] == 0) {
                    q.add(new Pos(ni, nj, f.dist + 1));
                    m[ni][nj] = -1;
                }
            }
        }
    }
}