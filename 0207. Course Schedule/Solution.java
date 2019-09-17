class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // create graph from given dependencies(edges)
        Map<Integer, Set> graph = new HashMap<>();
        
        // create u:{} for each node u in graph G
        for(int u = 0; u < numCourses; u++) {
            graph.put(u, new HashSet<Integer>());
        }
        
        // add neighbours of each node u
        // u: {x, y, ...}
        for(int[] edge: prerequisites) {
            graph.get(edge[0]).add(edge[1]);   
        }
        
        // status: 
        // 0 : unvisited
        // 1 : processing (in call stack)
        // 2 : processed
        int[] status = new int[numCourses];
        boolean flag;

        // run dfs 
        for(int i = 0; i<numCourses; i++) {
            if(status[i]!=2) { // check not processed
                flag = dfsVisit(graph, status, i);
                if(!flag) {
                    return false;
                }
            }
        }
        
        // everything went well
        return true;
    }
    
    private static boolean dfsVisit(Map<Integer, Set> graph, int[] status, int u) {
        status[u] = 1;  // u is in call stack now
        boolean flag; 
        
        for(int v: (Set<Integer>)graph.get(u)) {
            // currently u is in call stack
            // if v which is a neighbour of u is in call stack
            // indicates a cycle, report this
            if(status[v] == 1) {
                return false;
            }
            // otherwise, check if not already processed
            if(status[v] != 2) {
                flag = dfsVisit(graph, status, v);
                if(!flag) {
                    return false;
                }
            }
        }
        status[u] = 2;  // mark visited
        return true;
    }
}
