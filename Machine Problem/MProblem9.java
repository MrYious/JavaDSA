import java.util.*;

class Graph{
    HashMap<Integer,List<Integer>> map = new HashMap();

    public void addVertex(int s){
        map.put(s, new LinkedList<>());
    }

    public void addEdge(int x,int y){
        if (!map.containsKey(x))
            addVertex(x);

        if (!map.containsKey(y))
            addVertex(y);

        map.get(x).add(y);
        map.get(y).add(x);
    }

    public int count(){
        return map.keySet().size();
    }

    public List<Integer> getAdjacentValues(int i){
        return map.get(i);
    }

}

public class Program2 {
    public static void main(String[] args) {
        Graph g = new Graph();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[5];

        g.addEdge(0, 4);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);

        System.out.println("Traverse using Queue-Based BFS\n");
        System.out.println("Sequence: ");

        queue.add(0);
        visited[0] = true;

        int s;
        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            for (int n : g.getAdjacentValues(s)) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
