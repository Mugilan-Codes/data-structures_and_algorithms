package main.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class HasPath {
    static class Graph {
        HashMap<Object, LinkedList<Object>> adjList = new HashMap<>();

        public Graph(ArrayList<Object> vertices) {
            for (Object vertex: vertices) {
                LinkedList<Object> list = new LinkedList<>();
                adjList.put(vertex, list);
            }
        }

        public void addEdge(Object source, Object destination) {
            LinkedList<Object> list = adjList.get(source);
            list.addFirst(destination);
            adjList.put(source, list);
        }

        // breadth first
        public boolean hasPath(Object source, Object dest) {
            Queue<Object> queue = new LinkedList<>();
            queue.add(source);

            while (!queue.isEmpty()) {
                Object current = queue.remove();
                if (current == dest) {
                    return true;
                }

                LinkedList<Object> list = adjList.get(current);
                queue.addAll(list);
            }

            return false;
        }
    }

    // depth first
    public static boolean hasPath(Graph graph, Object source, Object dest) {
        if (source == dest) return true;

        for (Object item: graph.adjList.get(source)) {
            if (hasPath(graph, item, dest)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<Object> vertices = new ArrayList<>();
        vertices.add('f');
        vertices.add('g');
        vertices.add('h');
        vertices.add('i');
        vertices.add('j');
        vertices.add('k');

        Graph graph = new Graph(vertices);
        graph.addEdge('f', 'g');
        graph.addEdge('f', 'i');
        graph.addEdge('g', 'h');
        graph.addEdge('i', 'g');
        graph.addEdge('i', 'k');
        graph.addEdge('j', 'i');

        System.out.println(hasPath(graph, 'f', 'k'));
        System.out.println(hasPath(graph, 'f', 'j'));

        System.out.println(graph.hasPath('f', 'k'));
        System.out.println(graph.hasPath('f', 'j'));
    }
}
