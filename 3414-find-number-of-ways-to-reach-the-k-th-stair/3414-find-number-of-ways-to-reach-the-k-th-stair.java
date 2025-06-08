class Solution {
    HashMap<String ,Integer> hm;
    public int waysToReachStair(int k) {
        hm = new HashMap<>();
        return helper(1,0,0,k);
    }

    public int helper(int i,int backjmp,int fordjmp,int k){
        if(k+2<i) return 0;
        String key = i+" "+backjmp+" "+fordjmp;
        if(hm.containsKey(key)) return hm.get(key);

        // backjump  if not at 0 and backjum!=1
        int bj=0;
        if(i!=0 && backjmp!=1){
            bj = helper(i-1,1,fordjmp,k);
        }
        // forwardjump

        int fj = 0;
        int jumpposi = (int) (i + Math.pow(2,fordjmp));
        fj =  helper(jumpposi,0,fordjmp+1,k);
        int tways =0;
        if(i==k) tways = 1 + fj+bj;
        else tways = fj+bj;
        hm.put(key,tways);
        return tways;
    }
}