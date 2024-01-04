package beingZero.phase_three.graphs;

import java.util.*;

public class AdjBFSList {
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
            bfs(g, 0);
        }
    }

    public static void bfs(Map<Integer, List<Integer>> g, int source) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        queue.add(source);
        vis.add(source);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for (int i : g.get(u)) {
                if (!vis.contains(i)) {
                    queue.add(i);
                    vis.add(i);
                }
            }

        }
    }
}