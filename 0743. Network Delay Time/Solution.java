/**
 * We process the graph starting from node 0 in bfs manner,
 * intializing time with -inf, each node would push to it’s outgoing neighbors
 * and each node maintains the minimal time required to get the msg.
 */

class Edge {
    int u, v, t;
    Edge(int u, int v, int t) {
        this.u = u;
        this.v = v;
        this.t = t;
    }

    @Override
    public String toString() {
        return "[" + this.v + ", " + this.t + "] ";
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        return computeTimes(getGraph(times, N), N, K);
    }

    private static Map<Integer, List<Edge>> getGraph(int[][] times, int n) {

        // create graph
        Map<Integer, List<Edge>> graph = new HashMap<>();

        // create list of edges
        List<Edge> edges = new LinkedList<>();
        for(int[] e : times) {
            edges.add(new Edge(e[0], e[1], e[2]));
        }

        for (int i = 1; i <= n; i++) {
            graph.put(i, new LinkedList<>());
        }

        for (Edge e : edges) {
            (graph.get(e.u)).add(e);
        }

        return graph;
    }

    /**
     * The function of our interest
     * @param graph input graph
     * @param n total number of nodes
     * @return time by which all nodes gets the message
     */
    private static int computeTimes(Map<Integer, List<Edge>> graph, int n, int src) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] bestTimes = new int[n+1];   // to hold best time of each node, could apply more OOP
        int maxTime = Integer.MIN_VALUE;

        // initialize
        for(int i = 1; i <= n; i++) {
            bestTimes[i] = Integer.MAX_VALUE;
        }

        // insert source in queue
        queue.add(src);
        bestTimes[src] = 0;

        while (queue.size() > 0) {
            int node = queue.poll();

            // push algorithm
            for(Edge e: graph.get(node)) {
                // if v gets msg earlier using link u-v, use it
                if (bestTimes[e.v] > bestTimes[e.u] + e.t) {
                    bestTimes[e.v] = bestTimes[e.u] + e.t;
                    queue.add(e.v);
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            if(bestTimes[i] == Integer.MAX_VALUE) {
                // unreachable
                return -1;
            }
            maxTime = Integer.max(maxTime, bestTimes[i]);
        }

        return maxTime;
    }
}
