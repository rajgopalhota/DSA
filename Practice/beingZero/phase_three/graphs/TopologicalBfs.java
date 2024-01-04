package beingZero.phase_three.graphs;

import java.util.*;
class TopologicalBfs {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<numCourses;i++)
            map.put(i,new LinkedList<>());
        int inDegree[]=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++)
        {
            int u=prerequisites[i][0],v=prerequisites[i][1];
            map.get(u).add(v);
            inDegree[v]++;
        }
       return bfs(map,inDegree);
    }
    public  boolean bfs(Map<Integer,List<Integer>> map,int[] in)
    {
        int count=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<in.length;i++)
        {
            if(in[i]==0){
                q.add(i);
                in[i]=-1;
            }   
        }
        while(!q.isEmpty())
        {
            int p=q.poll();
            count++;
            for(int i:map.get(p))
            {
                if(in[i]!=-1)
                {
                    in[i]--;
                    if(in[i]==0)
                    {
                        q.add(i);
                        in[i]=-1;
                    }
                }
            }
        }
        if(count==map.size())
        {
            return true;
        }
        return false;

    }
}