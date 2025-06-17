class Solution {
    int n;
    public int longestDecomposition(String text) {
        this.n = text.length();
        StringBuilder sb = new StringBuilder(text);
        return helper(0,n-1,sb);
    }

    public int helper(int i, int j,StringBuilder sb){
        if(i==j) return 1;
        if(i>j) return 0;
        int ans = 0;
        StringBuilder stst = new StringBuilder("");
        StringBuilder endst = new StringBuilder("");
        for(int start = i;start<=j;start++){
            stst.append(sb.charAt(start));
            int end = n-start-1;
            endst.insert(0,sb.charAt(end));
           // System.out.println(stst+ " "+endst);
            if(stst.compareTo(endst)==0){
                //System.out.println(stst+ " "+endst);
                if(start>end) ans = 1+ helper(start+1,end-1,sb);
                else ans = 2 + helper(start+1,end-1,sb);
                break;
            } 
        }
        return ans;
    }
}