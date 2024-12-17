class Solution {
    public int findChampion(int n, int[][] edges) {
        int [] inorder = new int[n];
        for(int i =0;i<edges.length;i++){
            inorder[edges[i][1]]++;
        }
        int c =0;
        int ans =-1;
        for(int i =0;i<n;i++){
            if(inorder[i]==0){
                c++;
                ans=i;
            }
        }
        if(c==1) return ans;
        else return -1;
    }
}