package beingZero.graphs;

import java.util.*;

class Pos {
    int i, j;

    public Pos(int i, int j) {
        this.i = i;
        this.j = j;
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

    // // Four directions
    // static int[] di = { -1, 0, 1, 0 };
    // static int[] dj = { 0, 1, 0, -1 }; // N - E - S - W
 
    // Eight directions
    static int[] di = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dj = { 0, 1, 1, 1, 0, -1, -1, -1 }; // N, NE - E, SE - S, SW - W, NW

    static void bfs(int[][] m, int si, int sj) {
        int r = m.length, c = m[0].length;
        Queue<Pos> q = new LinkedList<>(); // deque
        q.add(new Pos(si, sj));
        m[si][sj] = -1; // -1 is visited
        int counter = 1;
        while (!q.isEmpty()) {
            Pos f = q.remove();
            m[f.i][f.j] = counter++;

            for (int x = 0; x < di.length; x++) {
                int ni = f.i + di[x], nj = f.j + dj[x];
                if (ni >= 0 && nj >= 0 && ni < r && nj < c && m[ni][nj] == 0) {
                    q.add(new Pos(ni, nj));
                    m[ni][nj] = -1;
                }
            }
        }
    }
}