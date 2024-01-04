package beingZero.phase_three.graphs;

import java.util.*;
public class WeightedAdjancencdeyMatrixPath {

    static int INF = Integer.MAX_VALUE;
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int nv = scan.nextInt();
        int ne = scan.nextInt();
        long mat[][] = new long[nv][nv];
        
        for (int i = 0; i < ne; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            int w = scan.nextInt();
            mat[u][v] = w;
            mat[v][u] = w; //Undirected
        }

        long[][] dist = new long[nv][nv];
        long[][] parent = new long[nv][nv];

        for (int i = 0; i < nv; i++) {
            for(int j = 0; j<nv; j++){
                parent[i][j] = -1;
                if(i==j) dist[i][j] = 0;
                else if(mat[i][j]!=0) {
                    dist[i][j] = mat[i][j];
                    parent[i][j] = i;
                }
                else dist[i][j] = INF; //Basically unreachable!
            }
            
        }

        // I know its not shortest path, but just a path 😅

        // FLOYD WARSHAL ALGO - All source All destination Shortest path; 👌

        for(int mid = 0; mid < nv; mid++){
            for(int start = 0; start < nv; start++){
                for(int end = 0; end < nv; end++){
                    if(dist[start][mid]+dist[mid][end]<dist[start][end]){
                        dist[start][end] = dist[start][mid]+dist[mid][end];
                        parent[start][end] = mid;
                    }
                }
            }
        }

        for (int i = 0; i < nv; i++) {
            for (int j = 0; j < nv; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < nv; i++) {
            for (int j = 0; j < nv; j++) {
                System.out.print(parent[i][j] + " ");
            }
            System.out.println();
        }

        scan.close();
    }
}


// https://www.baeldung.com/wp-content/uploads/sites/4/2021/12/weighted-example.jpg