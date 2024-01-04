package beingZero.phase_three.graphs;

import java.util.*;

public class TopologicalDFS {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int numCourses1 = 4;
        int[][] prerequisites1 = { { 0, 1 }, { 2, 1 }, { 3, 2 } };
        solution.findOrder(numCourses1, prerequisites1);

    }

}

class Solution {
    public void findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++)
            map.put(i, new LinkedList<>());
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0], v = prerequisites[i][1];
            map.get(u).add(v);
        }

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stk = new Stack<>();

        for (int i : map.keySet()) {
            if (!visited.contains(i)) {
                dfs(map, i, visited, stk);
            }
        }

        int[] result = new int[numCourses];
        int index = numCourses - 1;

        while (!stk.isEmpty()) {
            System.out.print(stk.pop() + " ");
        }

    }

    public void dfs(Map<Integer, List<Integer>> map, int i, Set<Integer> visited, Stack<Integer> stk) {
        if (visited.contains(i)) {
            return;
        }

        visited.add(i);

        for (int k : map.get(i)) {
            dfs(map, k, visited, stk);
        }

        stk.push(i);
    }
}
