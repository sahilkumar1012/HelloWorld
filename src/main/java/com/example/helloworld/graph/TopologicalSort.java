package com.example.helloworld.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Chirag
 * @param <T>
 *
 */

/*   ************* Pseudo Code *******************
        topologicalSort(Graph graph){
        Set visited = new HashSet<>();
        Stack ans = new Stack<>();
        for(Vertex vertex: graph.getAllVertex()){
            if(!visited.contains(vertex)){

                dfsSort(vertex,ans);
                }
        }
       }
       dfsSort(Vertex current,ans){
        visited.add(current);
            for(Vertex neighbour: current.getAllNeighbours){
                if(!visited.contains(neighbour))
                    dfsSort(neighbour);
            }
            ans.push(current);
       }
 */
public class TopologicalSort <T>{
    public Deque<Vertex<T>> topSort(Graph<T> graph) {
        Deque<Vertex<T>> stack = new ArrayDeque<>();
        Set<Vertex<T>> visited = new HashSet<>();
        for (Vertex<T> vertex : graph.getAllVertex()) {
            if (visited.contains(vertex)) {
                continue;
            }
            topSortUtil(vertex,stack,visited);
        }
        return stack;
    }

    private void topSortUtil(Vertex<T> vertex, Deque<Vertex<T>> stack,
                             Set<Vertex<T>> visited) {
        visited.add(vertex);
        for(Vertex<T> childVertex : vertex.getAdjacentVertexes()){
            if(visited.contains(childVertex)){
                continue;
            }
            topSortUtil(childVertex,stack,visited);
        }
        stack.offerFirst(vertex);
    }

    public static void main(String args[]){
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 8);
        graph.addEdge(8, 11);

        TopologicalSort<Integer> sort = new TopologicalSort<Integer>();
        Deque<Vertex<Integer>> result = sort.topSort(graph);
        while(!result.isEmpty()){
            System.out.println(result.poll());
        }
    }
}
