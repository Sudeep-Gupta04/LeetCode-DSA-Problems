class Solution {
    int[][][] dp;
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        dp = new int[arr1.length][Math.max(arr2.length,arr1.length)+1][2];
        for(int[][]j:dp) for(int[] i:j) Arrays.fill(i,-1);
        ArrayList<Integer> al = new ArrayList<>(Arrays.stream(arr2).boxed().toList());
        Collections.sort(al);
        int ans = helper(0,-1,0,arr1,arr2,al);
        return (ans==1000000?-1:ans);
    }

    // 0 means original arrays 1 maenas arrLsit
    private int helper(int i, int prev,int parr,int[] arr1, int[] arr2,List<Integer> al) {
        if(i>=arr1.length) return 0;
        if(dp[i][prev+1][parr]!=-1) return dp[i][prev+1][parr];
        int p1 = 1000000;
        int p2 = 1000000;
        if(prev==-1){
            p1 = helper(i+1,0,0,arr1,arr2,al);

            if(al.get(0)<arr1[0]){
                p2 = 1+helper(i+1,0,1,arr1,arr2,al);
            }
        }else{
            if(parr==0){
                if(arr1[i]>arr1[prev]) p1 = helper(i+1,i,0,arr1,arr2,al);
            }
            else{
                if(arr1[i]> al.get(prev)) p1 = helper(i+1,i,0,arr1,arr2,al);;
            }

            int idx = Collections.binarySearch(al,((parr==0)?arr1[prev]:al.get(prev))+1);
            if(idx<0) idx = -(idx+1);
            if(idx<al.size()){
                p2 = 1 + helper(i+1,idx,1,arr1,arr2,al);

            }
        }

        return dp[i][prev+1][parr] = Math.min(p1,p2);
    }
}