package beingZero.phase_three.graphs;

import java.util.*;

// The distance array will contains distances from the given source to all the vetices. if unreachable then its -1

public class DistancesFromSinglePoint {
    public static void main(String args[]) {

        try (Scanner sc = new Scanner(System.in)) {
            int nv = sc.nextInt();
            int ne = sc.nextInt();
            Map<Integer, List<Integer>> g = new HashMap<>();
            for (int i = 0; i < nv; i++) {
                g.put(i, new ArrayList<>());
            }
            for (int i = 0; i < ne; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                g.get(u).add(v);
                g.get(v).add(u);
            }
            int[] dist = new int[nv];
            Arrays.fill(dist, -1);
            bfs(g, 0, dist);
        }
    }

    public static void bfs(Map<Integer, List<Integer>> g, int source, int[] dist) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        queue.add(source);
        vis.add(source);
        dist[source] = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for (int i : g.get(u)) {
                if (!vis.contains(i)) {
                    queue.add(i);
                    vis.add(i);
                    dist[i] = 1 + dist[u];
                }
            }

        }
    }
}
