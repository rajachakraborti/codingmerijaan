package graph;

import java.util.*;

public class TopologicalSortGraph {
    private int noOfVertices;
    private List<Integer> adj[];

    public TopologicalSortGraph(int num) {
        this.noOfVertices = num;
        adj = new LinkedList[num];

        for(int i = 0 ; i < num; i++)
            adj[i] = new LinkedList<>();

    }

    private void add(int x, int y){
        adj[x].add(y);
    }

    private  void topoLogicalSortHelper(int index, Stack<Integer> s, boolean[] visited) {
        visited[index] = true;

        adj[index].forEach(l -> {
            int i = l.intValue();
            if (!visited[i])
                topoLogicalSortHelper(i, s, visited);
        });


        s.push(index);
    }

    private  void topoLogicalSort(TopologicalSortGraph graph) {
        Stack<Integer> s = new Stack<>();
        boolean [] visited = new boolean[graph.adj.length];

        for(int i =0; i< graph.noOfVertices; i++) {
            if(!visited[i])
                topoLogicalSortHelper(i, s, visited);
        }

       // s.forEach(System.out::println);
        while (!s.empty())
            System.out.println(s.pop());
    }

    public static void main(String[] args) {
        TopologicalSortGraph graph = new TopologicalSortGraph(6);
        graph.add(5,2);
        graph.add(5,0);
        graph.add(4,0);
        graph.add(4,1);
        graph.add(2,3);
        graph.add(3,1);


        graph.topoLogicalSort(graph);
    }
}
