package com.example.helloworld.graph;

import java.util.HashSet;
import java.util.Set;

public class CycleDirectedGraph {

    public boolean hasCycle(Graph<Integer> graph){
        Set<Vertex<Integer>> whiteSet = new HashSet<>();
        Set<Vertex<Integer>> graySet = new HashSet<>();
        Set<Vertex<Integer>> blackSet = new HashSet<>();

        for (Vertex<Integer> vertex: graph.getAllVertex()){
            whiteSet.add(vertex);
        }

        while (whiteSet.size()>0){
            Vertex<Integer> current = whiteSet.iterator().next();
            if (dfs(current,whiteSet,graySet,blackSet));
        }


        return true;
    }

    private boolean dfs(Vertex<Integer> current, Set<Vertex<Integer>> whiteSet, Set<Vertex<Integer>> graySet, Set<Vertex<Integer>> blackSet) {
        moveVertex(current,whiteSet,graySet);

        for(Vertex<Integer> neighbor:current.getAdjacentVertexes()){
            if(blackSet.contains(neighbor)){
                continue;
            }
            if (graySet.contains(neighbor)){
                return true;
            }
            if (dfs(neighbor,whiteSet,graySet,blackSet)){
                return true;
            }
        }
        moveVertex(current,graySet,blackSet);
        return false;
    }

    private void moveVertex(Vertex<Integer> current, Set<Vertex<Integer>> sourceSet, Set<Vertex<Integer>> destinationSet) {
        sourceSet.remove(current);
        destinationSet.add(current);
    }

    public static void main(String args[]){
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 4);
        CycleDirectedGraph cdg = new CycleDirectedGraph();
        System.out.println(cdg.hasCycle(graph));
    }

}
