package com.example.helloworld.graph;

import com.example.helloworld.disjointSet.DisjointSet;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Chirag
 * @reference https://youtu.be/n_t0a_8H8VY
 * Time Complexity O(V)
 *
 */



    /*    ********************  Pseudo Code *********************
    // By Disjoint Set
        hasCycle(Graph graph){
            DisjointSet ds = new DisjointSet();
            for(vertex v: graph.getAllVertex()){
                ds.makeSet();

            }
            for(Edge edge: graph.getAllEdges){
                vertex rep1= ds.findSet(edge.v1());
                vertex rep2 = ds.findSet(edge.v2());

                if(rep1.equals(rep2)){
                    return true;
                }
                ds.union(edge().v1,edge.v2());
            }
            return false;
        }



     */
public class CycleUndirectedGraph<T> {

//    public boolean hasCycle(Graph graph){
//
//    }
public boolean hasCycleUsingDisjointSets(Graph<T> graph){
    DisjointSet disjointSet = new DisjointSet();

    for(Vertex<T> vertex : graph.getAllVertex()){
        disjointSet.makeSet(vertex.getId());
    }

    for(Edge<T> edge : graph.getAllEdges()){
        long parent1 = disjointSet.findSet(edge.getVertex1().getId());
        long parent2 = disjointSet.findSet(edge.getVertex2().getId());
        if(parent1 == parent2){
            return true;
        }
        disjointSet.union(edge.getVertex1().getId(), edge.getVertex2().getId());
    }
    return false;
}

    public boolean hasCycleDFSUtil(Vertex<T> vertex, Set<Vertex<T>> visited, Vertex<T> parent){
        visited.add(vertex);
        for(Vertex<T> adj : vertex.getAdjacentVertexes()){
            if(adj.equals(parent)){
                continue;
            }
            if(visited.contains(adj)){
                return true;
            }
            boolean hasCycle = hasCycleDFSUtil(adj,visited,vertex);
            if(hasCycle){
                return true;
            }
        }
        return false;
    }

    public boolean hasCycleDFS(Graph<T> graph){
        Set<Vertex<T>> visited = new HashSet<Vertex<T>>();
        for(Vertex<T> vertex : graph.getAllVertex()){
            if(visited.contains(vertex)){
                continue;
            }
            boolean flag = hasCycleDFSUtil(vertex, visited, null);
            if(flag){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        CycleUndirectedGraph<Integer> cycle = new CycleUndirectedGraph<Integer>();
        Graph<Integer> graph = new Graph<Integer>(false);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 1);
        boolean isCycle = cycle.hasCycleDFS(graph);
        System.out.println(isCycle);
        isCycle = cycle.hasCycleUsingDisjointSets(graph);
        System.out.print(isCycle);
    }
}
