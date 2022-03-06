import java.util.*;

class Graph{
    HashMap<Integer,List<Integer>> map = new HashMap();

    public void addVertex(int s){
        map.put(s, new LinkedList<Integer>());
    }

    public void addEdge(int x,int y){
        if (!map.containsKey(x))
            addVertex(x);

        if (!map.containsKey(y))
            addVertex(y);

        map.get(x).add(y);
        map.get(y).add(x);
    }

    public List<Integer> getAdjacentValues(int i){
        return map.get(i);
    }

}

public class Program2 {
    static boolean[] visited = new boolean[5];
    public static void main(String[] args) {

        Graph g = new Graph();

        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.println("Traverse using DFS\n");
        System.out.println("All components: ");

        traverseDFS(0, g);
    }

    //Recursive DFS Traversal
    private static void traverseDFS(int key, Graph g) {
        int v;
        if(!visited[key]){
            visited[key] = true;

            for (Integer integer : g.getAdjacentValues(key)) {
                v = integer;
                System.out.print("(" + key + ", " + v + ") ");
                traverseDFS(v, g);
            }
        }
    }

}
