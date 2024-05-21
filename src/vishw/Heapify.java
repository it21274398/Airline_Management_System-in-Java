package vishw;

import java.util.*;
import java.util.function.Function;

public class Heapify {

    public static List<Graph.Route> bfs(Graph graph, String start, String goal, int maxLayovers) {
        Queue<Graph.Route> queue = new LinkedList<>();
        queue.add(new Graph.Route(start, new ArrayList<>(Arrays.asList(start)), 0));
        List<Graph.Route> routes = new ArrayList<>();

        while (!queue.isEmpty()) {
            Graph.Route current = queue.poll();
            String currentNode = current.path.get(current.path.size() - 1);
            if (current.path.size() - 1 > maxLayovers) {
                continue;
            }

            for (Graph.Edge neighbor : graph.getNeighbors(currentNode)) {
                if (neighbor.destination.equals(goal)) {
                    routes.add(new Graph.Route(neighbor.destination, new ArrayList<>(current.path), current.distance + neighbor.distance));
                    routes.get(routes.size() - 1).path.add(neighbor.destination);
                } else {
                    Graph.Route newRoute = new Graph.Route(neighbor.destination, new ArrayList<>(current.path), current.distance + neighbor.distance);
                    newRoute.path.add(neighbor.destination);
                    queue.add(newRoute);
                }
            }
        }

        return routes;
    }

    public static void displayRoutes(List<Graph.Route> routes) {
        for (Graph.Route route : routes) {
            System.out.println("Route: " + String.join(" -> ", route.path) + ", Layovers: " + (route.path.size() - 2) + ", Distance: " + route.distance + " km");
        }
    }

    public static <T> void heapSort(List<T> arr, Function<T, Comparable> key) {
        int n = arr.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, key);
        }
        for (int i = n - 1; i > 0; i--) {
            T temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);
            heapify(arr, i, 0, key);
        }
    }

    private static <T> void heapify(List<T> arr, int n, int i, Function<T, Comparable> key) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && key.apply(arr.get(l)).compareTo(key.apply(arr.get(largest))) > 0) {
            largest = l;
        }
        if (r < n && key.apply(arr.get(r)).compareTo(key.apply(arr.get(largest))) > 0) {
            largest = r;
        }
        if (largest != i) {
            T swap = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, swap);
            heapify(arr, n, largest, key);
        }
    }

    public static List<Graph.Route> sortRoutes(List<Graph.Route> routes, String criterion) {
        Function<Graph.Route, Comparable> key;
        if (criterion.equals("distance")) {
            key = route -> route.distance;
        } else if (criterion.equals("layovers")) {
            key = route -> route.path.size() - 2;
        } else {
            return routes;
        }

        heapSort(routes, key);
        return routes;
    }
}
