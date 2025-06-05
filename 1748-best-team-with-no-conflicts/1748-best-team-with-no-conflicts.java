class Solution {
    static int[][] dp;
    public static int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        dp = new int[n][n+1];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        TreeMap<Integer,List<Integer>> tm = new TreeMap<>();
        for(int i =0;i<ages.length;i++){
            if(!tm.containsKey(ages[i])) tm.put(ages[i],new ArrayList<>());
            tm.get(ages[i]).add(scores[i]);
        }
        int k =0;
        System.out.println(tm);
        for(Map.Entry<Integer,List<Integer>> i: tm.entrySet()){
            int age = i.getKey();
            List<Integer> l = tm.get(age);
            Collections.sort(l);
            for(int j =0;j<l.size();j++){
                ages[k] = age;
                scores[k++]=l.get(j);
            }
        }
        return helper(n-1,-1,ages,scores);

    }

    private static int helper(int i, int prev, int[] ages, int[] scores) {
        if(i<0) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int take = Integer.MIN_VALUE; int ntale = Integer.MIN_VALUE;
        if(prev==-1){
            take = scores[i] + helper(i-1,i,ages,scores);
        }
        if(prev!=-1){
            if(scores[i]<=scores[prev]) take = scores[i] + helper(i-1,i,ages,scores);
        }
        int ntake = helper(i-1,prev,ages,scores);
        return dp[i][prev+1] = Math.max(take,ntake);
    }
}