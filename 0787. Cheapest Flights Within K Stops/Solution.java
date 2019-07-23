/*
 * There are n cities connected by m flights. 
 * Each fight starts from city u and arrives at v with a price w.
 * Now given all the cities and flights, together with starting city src and the destination dst, 
 * your task is to find the cheapest price from src to dst with up to k stops. 
 * If there is no such route, output -1.
 */

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        return computeBestPrices(getGraph(flights, n), n, src, dst, K);
    }
  
    private static int computeBestPrices(Map<Integer, List<Edge>> graph, int n, int s, int d, int K) {  
        // holds present best prices
        int[] bestPrices = new int[n];
        Arrays.fill(bestPrices, Integer.MAX_VALUE);  
        LinkedList<Integer> q = new LinkedList<>();
        
        bestPrices[s] = 0;
        q.add(s);
        int k = 0;
        while(!q.isEmpty() && k <= K) {
            int size = q.size();
            // we don't want the values obtains for some vertex at this iteration
            // affect values for some other vertex, so we store optimised value in temp
            int[] tempPrices = Arrays.copyOf(bestPrices, n);
            for(int i = 0; i < size; i++) {
                int node = q.poll();
                for(Edge e: graph.get(node)) {
                    // relax if u-v is better choice
                    if (tempPrices[e.v] > bestPrices[e.u] + e.c) {
                        tempPrices[e.v] = bestPrices[e.u] + e.c;
                        q.add(e.v);
                    }
                }
            }
            // once we have processed for this iteration, we update prices
            bestPrices = tempPrices;
            k++;            
        }
        // no route possible
        if(bestPrices[d] == Integer.MAX_VALUE) {
            return -1;
        }
        return bestPrices[d];
    }
    
    // graph api
    private static Map<Integer, List<Edge>> getGraph(int[][] flights, int n) {
        // create graph
        Map<Integer, List<Edge>> graph = new HashMap<>();
        // create list of edges
        List<Edge> edges = new LinkedList<>();
        for(int[] e : flights) {
            edges.add(new Edge(e[0], e[1], e[2]));
        }
        // init
        for (int i = 0; i < n; i++) {
            graph.put(i, new LinkedList<>());
        }
        // populate
        for (Edge e : edges) {
            (graph.get(e.u)).add(e);
        }
        return graph;
    }
    
    // print
    private static void printGraph(Map<Integer, List<Edge>> graph) {
        for(int u: graph.keySet()) {
            System.out.print(u + ": ");
            for(Edge e: graph.get(u)) {
                System.out.print(e);
            }
            System.out.println();
        }
    }
    
    // print array
    private static void printArray(int[] arr) {
        for(int a: arr) {
            System.out.print(a + ", ");
        }
        System.out.println();
    }
}

// edge api
class Edge {
    int u, v, c;
    Edge(int u, int v, int c) {
        this.u = u;
        this.v = v;
        this.c = c;
    }
    
    @Override
    public String toString() {
        return "[" + this.v + ", $" + this.c + "], ";
    }
}
