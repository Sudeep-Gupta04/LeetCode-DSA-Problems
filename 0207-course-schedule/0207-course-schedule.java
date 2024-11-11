class Solution {
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        int[] inoder = new int[adj.size()];
        for(int i =0;i< adj.size();i++){
            ArrayList<Integer> temp = adj.get(i);
            for(int j : temp){
                inoder[j]++;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i =0;i<inoder.length;i++){
            if(inoder[i]==0) q.add(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int num = q.remove();
            ans.add(num);
            for(int i: adj.get(num)){
                inoder[i]--;
                if(inoder[i]==0) q.add(i);
            }
        }
        return ans;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       
        for(int i =0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        ArrayList<Integer> ans =  topologicalSort(adj);
        if(numCourses!=ans.size()) return false;
        return true;
    }
}