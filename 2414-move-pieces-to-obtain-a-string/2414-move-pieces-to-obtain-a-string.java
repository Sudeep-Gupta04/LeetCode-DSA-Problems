class Solution {
    public boolean canChange(String start, String target) {
        if(start.length()!=target.length()) return false;
        int ls =0;int rs =0;int sps =0;
        int lt =0;int rt =0;int spt =0;
        StringBuffer st1 = new StringBuffer("");
        StringBuffer st2 = new StringBuffer("");
        for(int i =0;i<start.length();i++){
            if(start.charAt(i)=='L')ls++;
            else if (start.charAt(i)=='R')rs++;
            else sps++;

            if(target.charAt(i)=='L')lt++;
            else if (target.charAt(i)=='R')rt++;
            else spt++;

            if(start.charAt(i)!='_')st1.append(start.charAt(i));
            if(target.charAt(i)!='_') st2.append(target.charAt(i));
        }
        if((ls!=lt) || (rs!=rt) ||(sps!=spt)) return false;
         if(!st2.toString().equals(st1.toString())) return false;

        int p1 = 0;int p2 =0;
        while((p1<start.length()) && (p2<target.length())){
            while(p1<start.length() && start.charAt(p1)=='_')p1++;
            while(p2<target.length() && target.charAt(p2)=='_')p2++;
            if(p1<start.length() &&  start.charAt(p1)=='L'){
                if(p1<p2) return false;
            }else if(p2<target.length() &&  target.charAt(p2)=='R'){
                if(p2<p1) return false;
            }
            p1++;p2++;
        }
        return true;
    }
}