class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length; int m = strs[0].length();
        int c = 0;
        for(int j =0;j<m;j++){
            char ch = 'a';
            for(int i = 0;i<n;i++){
                if(strs[i].charAt(j)<ch){
                    c++;
                    break;
                }
                else ch = strs[i].charAt(j);
            }
        }
        return c;
    }
}