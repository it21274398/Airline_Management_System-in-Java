package vishw;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create and populate the graph
        Graph graph = new Graph();
        System.out.println("Enter graph edges (source destination distance):");
        System.out.println("Example input: A B 100");
        System.out.println("Type 'done' when finished.");
        while (true) {
            String edgeInput = scanner.nextLine();
            if (edgeInput.equals("done")) break;
            String[] edge = edgeInput.split(" ");
            graph.addEdge(edge[0], edge[1], Integer.parseInt(edge[2]));
        }

        // Create and populate the hash table
        HashTable hashTable = new HashTable(10);
        System.out.println("\nEnter hash table data (key value):");
        System.out.println("Example input: JFK John F. Kennedy International Airport");
        System.out.println("Type 'done' when finished.");
        while (true) {
            String dataInput = scanner.nextLine();
            if (dataInput.equals("done")) break;
            String[] data = dataInput.split(" ", 2);
            hashTable.insert(data[0], data[1]);
        }

        // Test data for Heap Sort
        List<Graph.Route> routes = new ArrayList<>();
        System.out.println("\nEnter routes (path distance):");
        System.out.println("Example input: A,B,D 200");
        System.out.println("Type 'done' when finished.");
        while (true) {
            String routeInput = scanner.nextLine();
            if (routeInput.equals("done")) break;
            String[] route = routeInput.split(" ", 2);
            routes.add(new Graph.Route("", Arrays.asList(route[0].split(",")), Integer.parseInt(route[1])));
        }

        // Perform BFS to find routes
        System.out.println("\nFinding routes using BFS:");
        System.out.print("Enter source node: ");
        String source = scanner.nextLine();
        System.out.print("Enter destination node: ");
        String destination = scanner.nextLine();
        System.out.print("Enter maximum depth: ");
        int maxDepth = Integer.parseInt(scanner.nextLine());
        List<Graph.Route> bfsRoutes = Heapify.bfs(graph, source, destination, maxDepth);
        Heapify.displayRoutes(bfsRoutes);

        // Sort routes by distance
        List<Graph.Route> sortedByDistance = Heapify.sortRoutes(bfsRoutes, "distance");
        System.out.println("\nRoutes sorted by distance:");
        Heapify.displayRoutes(sortedByDistance);

        // Sort routes by layovers
        List<Graph.Route> sortedByLayovers = Heapify.sortRoutes(bfsRoutes, "layovers");
        System.out.println("\nRoutes sorted by layovers:");
        Heapify.displayRoutes(sortedByLayovers);

        scanner.close();
    }
}
