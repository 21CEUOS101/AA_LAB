import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

class Pair{
    Integer v;
    Integer weight;

    Pair(Integer a , Integer b)
    {
        this.v = a;
        this.weight = b;
    }
}

class Graph{
    HashMap<Integer,ArrayList<Pair>> map = new HashMap<>();

    ArrayList<Integer> set = new ArrayList<>();
    Graph(int n){
        for(int i=0;i<n;i++){
            map.put(i, new ArrayList<Pair>());
        }
    }
    public void addEdge(int u,int v,int w)
    {
        map.get(u).add(new Pair(v,w));
        map.get(v).add(new Pair(u,w));

        set.add(u,u);
        set.add(v,v);
    }

    public void join(int u,int v)
    {
        set.set(v,set.get(u));
    }

    public int isComplete()
    {
        int count = 0;

        for(int i=0;i<set.size();i++)
        {
            if(set.get(i) == i)
            {
                count++;
            }
        }

        return count;
    }

    public int kargeralgo()
    {
        while(isComplete() > 2)
        {
            int r = new Random().nextInt(0,map.size());
            int r2 = new Random().nextInt(0,map.get(r).size());

            map.get(set.get(r)).addAll(map.get(set.get(r2)));
            
            join(r, r2);
            map.remove(r2);
        }
        
        int sum = 0;
        // Iterator it = map.entrySet().iterator();

        // while(it.hasNext())
        // {
        //     ArrayList l = it.next();

        //     for(Pair p : l)
        //     {
        //         sum += p.weight;
        //     }
        // }

        for(ArrayList<Pair> l : map.values())
        {
            for(Pair p : l)
            {
                sum += p.weight;
            }
        }

        return sum;
    }
}

public class Karger{

    
    public static void main(String[] args) {

        Graph g = new Graph(4);

        g.addEdge(0, 1, 2);
        g.addEdge(1, 2, 3);
        g.addEdge(2, 3, 2);
        g.addEdge(3, 0, 3);
        g.addEdge(1, 3, 3);

        System.out.print(g.kargeralgo());
    }
}