class Solution {
    private boolean dfs(List<List<Integer>> graph , int src , int parent , boolean isVis[]){
        //base case
        if(isVis[src]){
            return false;
        }
        isVis[src] = true;
        for(int neighbor : graph.get(src)){
            if(neighbor == parent)continue;
            if(!dfs(graph , neighbor , src , isVis))return false;
        }
        return true;
    }
    public boolean validTree(int n, int[][] edges) {
        
        List<List<Integer>> graph = new LinkedList<>();
        for(int i = 0 ; i<n ; i++){
           graph.add(new ArrayList<>());
        }
        for(int edge[] : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean isVis[] = new boolean[n];
        if(!dfs(graph , 0 , -1 , isVis))return false;

        for(boolean isVisitedNode : isVis){
            if(!isVisitedNode)return false;
        }
        return true;

        //first convert the list to adjacencey form 
        // then run DFS, if you encounter the already visited node.
        // that is the tree else not
    }
}
