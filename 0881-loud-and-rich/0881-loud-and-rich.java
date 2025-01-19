class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        int n = quiet.length;
        int[] ans = new int[n];
        int[] indegree = new int[n];
        
        for (int i = 0; i < n; i++) {
            ans[i] = i;
            al.add(new ArrayList<>());
        }
        
        for (int i = 0; i < richer.length; i++) {
            al.get(richer[i][0]).add(richer[i][1]);
            indegree[richer[i][1]]++;
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        while (!q.isEmpty()) {
            int node = q.remove();
            for (int i : al.get(node)) {
                indegree[i]--;
                if (quiet[ans[node]] < quiet[ans[i]]) {
                    ans[i] = ans[node];
                }
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (quiet[ans[i]] > quiet[i]) {
                ans[i] = i;
            }
        }
        
        return ans;
    }
}
