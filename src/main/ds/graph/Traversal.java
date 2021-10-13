package main.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Traversal {
    public static void main(String[] args) {
        ArrayList<Object> vertices = new ArrayList<>();
        vertices.add('a');
        vertices.add('b');
        vertices.add('c');
        vertices.add('d');
        vertices.add('e');
        vertices.add('f');

        Graph graph = new Graph(vertices);
        graph.addEdge('a', 'b');
        graph.addEdge('a', 'c');
        graph.addEdge('b', 'd');
        graph.addEdge('c', 'e');
        graph.addEdge('d', 'f');

        graph.printGraph();

        System.out.println("Depth First Traversal");
        graph.depthFirstPrint('a');
        System.out.println("Breadth First Traversal");
        graph.breadthFirstPrint('a');
    }

    static class Graph {
        HashMap<Object, LinkedList<Object>> adjacencyList = new HashMap<>();
        HashMap<Object, Integer> vertexIndices = new HashMap<>();
        int index = -1;

        public Graph(ArrayList<Object> vertices) {
            for (Object vertex : vertices) {
                LinkedList<Object> adjList = new LinkedList<>();
                adjacencyList.put(vertex, adjList);
                vertexIndices.put(vertex, ++index);
            }
        }

        public void addEdge(Object sourceNode, Object destinationNode) {
            LinkedList<Object> adjList;
            adjList = adjacencyList.get(sourceNode);
            adjList.addFirst(destinationNode);
            adjacencyList.put(sourceNode, adjList);
        }

        public void printGraph() {
            Set<Object> set = adjacencyList.keySet(); // get the vertices

            for (Object vertex : set) {
                System.out.print("Vertex " + vertex + " is connected to: ");
                LinkedList<Object> list = adjacencyList.get(vertex);
                for (Object o : list) {
                    System.out.print(o + " ");
                }
                System.out.println();
            }
        }

        public void depthFirstPrint(Object sourceNode) {
            Stack<Object> dfStack = new Stack<>();
            dfStack.push(sourceNode);

            while (dfStack.size() > 0) {
                Object current = dfStack.pop();
                System.out.print(current + " ");

                LinkedList<Object> list = adjacencyList.get(current);
                for (Object o : list) {
                    dfStack.push(o);
                }
            }
            System.out.println();
        }

        public void breadthFirstPrint(Object sourceNode) {
            Queue<Object> bfQueue = new LinkedList<>();
            bfQueue.add(sourceNode);

            while (!bfQueue.isEmpty()) {
                Object current = bfQueue.remove();
                System.out.print(current + " ");

                LinkedList<Object> list = adjacencyList.get(current);
                bfQueue.addAll(list);
            }
            System.out.println();
        }
    }
}
