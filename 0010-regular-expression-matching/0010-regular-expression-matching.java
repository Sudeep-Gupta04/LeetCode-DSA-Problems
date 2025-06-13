class Solution {
    HashMap<String,Boolean> hm;
    public boolean isMatch(String s, String p) {
        hm = new HashMap<>();
        int n = s.length();
        int m = p.length();
        return helper(s,p,0,0,n,m);
    }
    // pattern j,m and org i,n;

    private boolean helper(String s, String p, int i, int j, int n , int m) {
        String key = i+","+j;
        if(i==s.length() && j==p.length()) return true;
        if(i>s.length() || j>=p.length()) return false;

        if(hm.containsKey(key)) return hm.get(key);
        boolean ans1 = false;boolean ans2 = false;boolean ans3 = false;boolean ans4 = false;boolean ans5 = false;
        if(j+1<m){
            if(p.charAt(j+1)=='*'){
                if(p.charAt(j)=='.'){
                    ans1 = helper(s,p,i+1,j,n,m) ||  helper(s,p,i,j+2,n,m);
                }else if(p.charAt(j)>=97  && p.charAt(j)<=122){
                    if(i<n && j<m && s.charAt(i)==p.charAt(j)){
                        ans2 = helper(s,p,i,j+2,n,m) || helper(s,p,i+1,j,n,m);  // ntake , take
                    }else{
                        ans3 = helper(s,p,i,j+2,n,m); //ntake
                    }
                }
            }
            else if(i<n && j<m){
                if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.') ans4 = helper(s,p,i+1,j+1,n,m);
            }
        }else if(i<n && j<m){
            if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.') ans5 = helper(s,p,i+1,j+1,n,m);
        }
        hm.put(key,(ans1||ans2||ans3||ans4||ans5));
        return ans1||ans2||ans3||ans4||ans5;
    }
}