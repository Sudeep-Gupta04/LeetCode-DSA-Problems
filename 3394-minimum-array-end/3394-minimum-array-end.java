class Solution {
    public long minEnd(int n, int x) {
        StringBuilder xr = new StringBuilder(Long.toBinaryString(x));
        StringBuilder nr = new StringBuilder(Long.toBinaryString(n - 1));
        int k = nr.length()-1;
        for(int i = xr.length()-1;i>=0;i--){
            if(xr.charAt(i)=='0'){
                if(nr.charAt(k)=='0') k--;
                else{
                    xr.setCharAt(i, '1');
                    k--;
                }
            }
            if(k==-1) break;
        }
        if(k!=-1){
            xr = new StringBuilder(nr.substring(0, k + 1) + xr);
        }
        return Long.valueOf(String.valueOf(xr),2);
    }
}