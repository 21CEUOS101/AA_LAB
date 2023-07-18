import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Water_Flow{

    public static boolean bfs(int[][] graph,int target,int source,int[] parent)
    {
        
        boolean visited[] = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        parent[source] = -1;
        while(!q.isEmpty())
        {
            int k = q.peek();
            q.remove();

            for(int i=0;i<6;i++)
            {
                if(visited[i] == false && graph[k][i]>0)
                {
                    if(i == target)
                    {
                        visited[i] = true;
                        parent[i] = k;
                        return true;
                    }
                    q.add(i);
                    parent[i] = k;
                    visited[i] = true;
                }
            }
        }
        return false;

    }

    public static int ford(int[][] graph,int target,int source)
    {
        int[][] rgraph = new int[graph.length][graph[0].length];

        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph[0].length;j++)
            {
                rgraph[i][j] = graph[i][j];
            }
        }

        int parent[] = new int[6];

        int max_flow = 0;

        while(bfs(rgraph, target, source,parent))
        {
            
            int min_flow = Integer.MAX_VALUE;
            int v = target;
            while(v!=source)
            {
                int u = parent[v];
                min_flow = Math.min(min_flow, rgraph[u][v]);
                v = parent[v];
            }

            for(v=target;v!=source;v=parent[v])
            {
                int u = parent[v];
                rgraph[u][v] -= min_flow;
                rgraph[v][u] += min_flow;
            }
            max_flow += min_flow;
        }

        return max_flow;

    }

    public static void main(String[] args) {
        
        int graph[][] = new int[][]{

            {0,16,13,0,0,0},
            {0,0,10,12,0,0},
            {0,0,4,0,14,0},
            {0,0,9,0,0,20},
            {0,0,0,7,0,4},
            {0,0,0,0,0,0}
        };

        System.out.println(ford(graph,5,0));
    }


}