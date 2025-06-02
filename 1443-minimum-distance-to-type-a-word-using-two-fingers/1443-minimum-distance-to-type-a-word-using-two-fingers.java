class Solution {
    HashMap<Character,int[]> hm;
    int[][][][][] dp;
    public int minimumDistance(String word) {
        hm = new HashMap<>();
        dp= new int[word.length()][5][6][5][6];
        for(int i =0;i<word.length();i++){
            for(int j =0;j<5;j++){
                for(int k =0;k<6;k++){
                    for(int l =0;l<5;l++) {
                        Arrays.fill(dp[i][j][k][l],-1);
                    }
                }
            }
        }
        int k = 65;
        for(int i =0;i<5;i++){
            for(int j =0;j<6;j++){
                if(k<91){
                    hm.put((char) k,new int[]{i,j});
                    k++;
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                for (int f2i = i; f2i < 5; f2i++) {
                    for (int f2j = 0; f2j < 6; f2j++) {
                        if (i == f2i && f2j <= j) continue;
                        ans = Math.min(ans, helper(i, j, f2i, f2j, 0, word));
                    }
                }
            }
        }
        return  ans;
    }

    private int helper(int f1i, int f1j, int f2i, int f2j, int i, String word) {
        if(i>=word.length()) return 0;
        if(dp[i][f1i][f1j][f2i][f2j]!=-1) return dp[i][f1i][f1j][f2i][f2j];
        int[] cod= hm.get(word.charAt(i));
        // moving f1
        int ansf1 = ditance(word.charAt(i),new int[]{f1i,f1j}) + helper(cod[0],cod[1],f2i,f2j,i+1,word);
        // moving f2
        int ansf2 = ditance(word.charAt(i),new int[]{f2i,f2j}) + helper(f1i,f1j,cod[0],cod[1],i+1,word);
        return dp[i][f1i][f1j][f2i][f2j] = Math.min(ansf1,ansf2);
    }

    private int ditance(char c, int[] f) {
        int[] cood = hm.get(c);
        return Math.abs(cood[0]-f[0]) + Math.abs(cood[1]-f[1]);
    }

}