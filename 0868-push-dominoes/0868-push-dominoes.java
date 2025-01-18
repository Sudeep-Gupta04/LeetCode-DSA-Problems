class Solution {
   public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] l = new int[n];
        int[] r = new int[n];
        Arrays.fill(r,10000);
        Arrays.fill(l,10000);
        int c =0;
        int s =n-1;
        while(s>=0){
            if(dominoes.charAt(s)=='L'){
                c=1;
                l[s]=0;
            }
            else if(((dominoes.charAt(s)=='.')) && (c==1)){
                l[s]=l[s+1]+1;
            }
            else if(dominoes.charAt(s)=='R' && c==1){
                c=0;
            }
            s--;
        }
        c=0;
        System.out.println(Arrays.toString(l));
        int e =0;

        while(e<n){
            if(dominoes.charAt(e)=='R'){
                c=1;
                r[e]=0;
            }
            else if(((dominoes.charAt(e)=='R') ||(dominoes.charAt(e)=='.')) && (c==1)){
                r[e]=r[e-1]+1;
            }
            else if(dominoes.charAt(e)=='L' && c==1){
                c=0;
            }
            e++;
        }
        System.out.println(Arrays.toString(r));
        StringBuilder sb = new StringBuilder("");
        for(int i =0;i<n;i++){
            if(l[i]==r[i]) sb.append(".");
            else if(l[i]<r[i]) sb.append("L");
            else sb.append("R");
        }
        return sb.toString();

    }
}