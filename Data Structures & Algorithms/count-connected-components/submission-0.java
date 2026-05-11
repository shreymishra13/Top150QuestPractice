class Solution {
    public int countComponents(int n, int[][] edges) {

        // first form the adjacency List
        List<List<Integer>> graph = new LinkedList<>();
        for(int i = 0 ; i<n ;i++){
            graph.add(new ArrayList<>());
        }

        for(int edge[] : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            
        }

        // then start the dfs from each node 0 -> n-1
        boolean isVis[] = new boolean[n];
        int countOfConnectedComp = 0;
        for(int src = 0 ;src < n ;src++){
            // if the start node is not visited, increase the count 
            if(!isVis[src]){
                countOfConnectedComp++;
                 // and start the dfs from that node
                dfs(graph , src , isVis);
            }
        }
        return countOfConnectedComp;


        
       
    }
    private void dfs(List<List<Integer>> graph , int src , boolean [] isVis){
        if(isVis[src])return;

        isVis[src] = true;
        //visit all its neighbor
        for(int neighbor : graph.get(src)){
            if(!isVis[neighbor]){
                dfs(graph , neighbor , isVis);
            }
        }
    }
}
