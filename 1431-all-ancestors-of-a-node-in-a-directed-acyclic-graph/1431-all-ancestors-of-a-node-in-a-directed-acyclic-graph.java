class Solution {
        public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        HashMap<Integer,HashSet<Integer>> ances = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();
        
        int[] inorder = new int[n];
        for(int i =0;i<n;i++){
            ances.put(i,new HashSet<>());
            al.add(new ArrayList<>());
        }
        for(int[] i: edges){
            al.get(i[0]).add(i[1]);
            inorder[i[1]]++;
        }
        for(int i =0;i<n;i++) if(inorder[i]==0) q.add(i);

        while(!q.isEmpty()){
            int node = q.poll();
            for(int i:al.get(node)){
                HashSet<Integer> chl = ances.get(i);
                HashSet<Integer> par = ances.get(node);
                chl.add(node);
                chl.addAll(par);

                inorder[i]-=1;
                if(inorder[i]==0) q.add(i);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0;i<n;i++){
            List<Integer> a = new ArrayList<>(ances.get(i));
            Collections.sort(a);
            ans.add(a);
        }
        return ans;
    }
}