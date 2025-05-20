class Solution {
    boolean rowc = false;
    boolean colc = false;
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        ArrayList<ArrayList<Integer>> row = new ArrayList<>();
        ArrayList<ArrayList<Integer>> col = new ArrayList<>();
        boolean[] vis = new boolean[k+1];
        boolean[] path = new boolean[k+1];
        int[][] ans = new int[k][k];

        for(int i =0;i<=k;i++){
            row.add(new ArrayList<>());
            col.add(new ArrayList<>());
        }
        for(int[] i:rowConditions){
            row.get(i[0]).add(i[1]);
        }
        for(int [] i:colConditions){
            col.get(i[0]).add(i[1]);
        }

        Stack<Integer> rowst = new Stack<>();
        Stack<Integer> colst = new Stack<>();
        for(int i =1;i<=k;i++){
            if(!vis[i]) topological(i,row,rowst,vis,path);
        }
        Arrays.fill(vis,false);
        Arrays.fill(path,false);
        for(int i =1;i<=k;i++){
            if(!vis[i]) topological(i,col,colst,vis,path);
        }

        System.out.println(rowst);
        System.out.println(colst);
       // System.out.println(colst.pop()+" "+rowst.pop());
        if(rowc || colc) return new int[][]{};
        HashMap<Integer,Integer> mp = new HashMap<>();
        int i =0;
        while(!rowst.isEmpty()){
            int num = rowst.pop();
            ans[i][0] = num;
            mp.put(num,i);
            i++;
        }
        i = 0;
        while(!colst.isEmpty()){
            int num = colst.pop();
            int idx = mp.get(num);
            ans[idx][0] = 0;
            ans[idx][i] = num;
            i++;
        }
        return ans;
    }
    
    public void topological(int src, ArrayList<ArrayList<Integer>> graph, Stack<Integer> st,boolean vis[],boolean path[]){
        vis[src] = true;
        path[src] = true;
        for(int i:graph.get(src)){
            if(!vis[i]){
                topological(i,graph,st,vis,path);
            }else if(path[i]){
                rowc = true;
            }
        }
        st.add(src);
        path[src] = false;
    }

}