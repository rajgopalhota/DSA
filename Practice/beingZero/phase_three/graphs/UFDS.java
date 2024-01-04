/* Path Existence In Graph
MEDIUM
Description
You are given an undirected graph containing N nodes. Initially, there are no edges in the graph. You will be given Q queries in the following format :

1 u v - Add an edge between node u and node v

2 u v - Tell if there is a path between node u and node v

Prohibited Keywords
No prohibited keywords for this problem.
Input Format
First line contains two space separated integers N,Q denoting the number of nodes in the graph and the number of queries respectively.

The next Q lines each contain three space separated integers denoting the queries.

Output Format
For each query of type 2, output Yes if there is a path between the nodes and No otherwise.

Constraints
1 ≤ N ≤ 105

1 ≤ Q ≤ 2*105

1 ≤ u,v ≤ N

Example
Input 1
3 4
1 1 2
2 1 3
1 2 3
2 1 3
 
Output 1
No
Yes
*/

package beingZero.phase_three.graphs;

import java.util.*;

class UFDS{
    int ygt[];
    int kl;
    public UFDS(int n){
        this.kl = n;
        ygt = new int[kl];
        for(int i = 0; i<kl; i++)
            ygt[i] = i;
    }

    void merge(int x, int y){
        int lx = find(x), ly = find(y);
        if(lx == ly) return;
        ygt[ly] = lx;
        // We have to make it optimal
    }

    int find(int x){
        if(x == ygt[x]) return x;
        // find(p[x]); not optimal
        return ygt[x] = find(ygt[x]);
    }
}

class Raja{
    
    static String solvedLogic(UFDS obj, int u, int v){
        return (obj.find(u) == obj.find(v)) ? "Yes" : "No";
    }
    
    static void solvedLogic(UFDS obj, int u, int v, int gb){
        obj.merge(u, v);
    }
    
}

class Main {
    public static void main(String[] args) {
        try(Scanner rj = new Scanner(System.in)){
            int nv = rj.nextInt();
            int q = rj.nextInt();
            UFDS obj = new UFDS(nv+1);

            while(q-->0){
                int op = rj.nextInt();
    
                if(op == 1){
                    Raja.solvedLogic(obj, rj.nextInt(), rj.nextInt(), -1);
                }
                else if(op == 2){
                    System.out.println(Raja.solvedLogic(obj, rj.nextInt(), rj.nextInt()));
                }
            }
        }
    }
}