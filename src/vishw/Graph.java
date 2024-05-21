package vishw;
import java.util.*;

public class Graph {
    private Map<String, List<Edge>> adjList;

    public Graph() {
        this.adjList = new HashMap<>();
    }

    public void addEdge(String src, String dest, int distance) {
        this.adjList.putIfAbsent(src, new ArrayList<>());
        this.adjList.get(src).add(new Edge(dest, distance));
    }

    public List<Edge> getNeighbors(String node) {
        return this.adjList.getOrDefault(node, new ArrayList<>());
    }

    public static class Edge {
        public String destination;
        public int distance;

        public Edge(String destination, int distance) {
            this.destination = destination;
            this.distance = distance;
        }
    }

    public static class Route {
        public String current;
        public List<String> path;
        public int distance;

        public Route(String current, List<String> path, int distance) {
            this.current = current;
            this.path = path;
            this.distance = distance;
        }
    }
}
