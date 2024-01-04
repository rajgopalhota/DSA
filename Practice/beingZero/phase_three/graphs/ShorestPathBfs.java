package beingZero.phase_three.graphs;

import java.util.*;
class ShortestPathBfs {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int nv = sc.nextInt(), ne = sc.nextInt();
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < nv; i++) {
            g.put(i, new ArrayList<>());
        }
        for (int i = 0; i < ne; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            if(!g.containsKey(u))
                g.put(u, new ArrayList<>());
            g.get(u).add(v);
            if(!g.containsKey(v))
                g.put(v, new ArrayList<>());
            g.get(v).add(u);
        }
       // printAdjList(g);
        Set<Integer> vis = new HashSet<>();
        int dist[]=new int[nv];
        Arrays.fill(dist,-1);
        int parent[]=new int[nv];
        Arrays.fill(parent,-1);
        bfs(g, 2, vis,dist,parent);
        LinkedList<Integer> list=new LinkedList<>();
        int x= 3;// this is the destination
        list.add(x);
        while(parent[x]!=-1)
        {
        	list.add(parent[x]);
        	x=parent[x];
        }
       // System.out.println(Arrays.toString(dist));
        Collections.reverse(list);
        System.out.println(list);
        
    }
        static void bfs(Map<Integer, List<Integer>> g, int s,  Set<Integer> vis,int[] dist,int[] parent){
        Queue<Integer> q = new LinkedList<>();

        q.add(s); vis.add(s);
        dist[s]=0;
        parent[s]=-1;

        while(!q.isEmpty()){
            int u = q.remove();
            System.out.print(u + " ");
            for(int v : g.get(u)){
                if(!vis.contains(v)){
                    q.add(v); vis.add(v);
                    dist[v]=1+dist[u];
                    parent[v]=u;
                }
            }
        }
    }
        static void printAdjList(Map<Integer, List<Integer>> g){
        for(int u : g.keySet()){
            System.out.print(u + " : ");
            for(int v : g.get(u)){
                System.out.print(v + " ");
            }
            System.out.println();
        }
        }
    }
