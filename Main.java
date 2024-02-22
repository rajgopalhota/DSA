import java.util.ArrayList;
import java.util.Arrays;

class Raja{

    private final int LG = 20;
    private int[] lvl, pref;
    private int[][] P;
    private ArrayList<Integer>[] l;

    void initGraph(int N, int p[]) {
        lvl = new int[N + 1];
        pref = new int[N + 1];
        P = new int[N + 1][LG + 1];
        l = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++)
            l[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            l[p[i]].add(i);
            l[i].add(p[i]);
        }
    }

    void preprocessLCA(int N) {
        Arrays.fill(P[0], -1);

        dfs(0, -1);

        for (int i = 1; i <= LG; i++) {
            for (int j = 0; j < N; j++) {
                if (P[j][i - 1] != -1) {
                    int x = P[j][i - 1];
                    P[j][i] = P[x][i - 1];
                }
            }
        }
    }

    void dfs(int node, int par) {
        if (par != -1) {
            lvl[node] = 1 + lvl[par];
            P[node][0] = par;
        }

        for (int kid : l[node]) {
            if (kid == par)
                continue;
            dfs(kid, node);
        }
    }

    void updatePreferences(int M, int source[], int destination[]) {
        for (int i = 0; i < M; i++) {
            int u = source[i];
            int v = destination[i];
            int lc = lca(u, v);

            pref[u]++;
            pref[v]++;
            pref[lc] -= 2;
        }
        dfs2(0, -1);
    }

    int lca(int u, int v) {
        if (lvl[u] < lvl[v]) {
            int t = u;
            u = v;
            v = t;
        }

        for (int i = LG; i >= 0; i--) {
            if (lvl[u] - (1 << i) >= lvl[v])
                u = P[u][i];
        }

        if (u == v)
            return u;

        for (int i = LG; i >= 0; i--) {
            if (P[u][i] != -1 && P[u][i] != P[v][i]) {
                u = P[u][i];
                v = P[v][i];
            }
        }
        return P[u][0];
    }

    void dfs2(int node, int par) {
        for (int kid : l[node]) {
            if (kid == par)
                continue;
            dfs2(kid, node);
            pref[node] += pref[kid];
        }
    }

    void sortArrays(int N, int[] w, int[] pref) {
        Arrays.sort(w, 1, N);
        Arrays.sort(pref, 1, N);
    }

    long calculateMinimum(int N, int[] w) {
        long ans = 0;
        for (int i = 1; i < N; i++) {
            ans += (1L * w[i]) * (1L * pref[N - i]);
        }
        return ans;
    }

    public long rajaLog(int N, int M, int p[], int w[], int source[], int destination[]) {
        
        initGraph(N, p);
        preprocessLCA(N);

        updatePreferences(M, source, destination);

        sortArrays(N, w, pref);

        return calculateMinimum(N, w);

    }

}


class Solution {

    public long findMin(int N, int M, int p[], int w[], int source[], int destination[]) {
        
        return new Raja().rajaLog(N, M, p, w, source, destination);

    }

    
}
