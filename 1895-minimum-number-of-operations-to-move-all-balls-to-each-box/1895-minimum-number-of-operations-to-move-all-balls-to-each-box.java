class Solution {
        public int[] minOperations(String boxes) {
        if(boxes.length()==1) return new int[]{0};
        int[] prev = new int[boxes.length()];
        int[] forw = new int[boxes.length()];
        int c =0;
        for(int i =0;i<boxes.length();i++){
            prev[i] = c;
            if(boxes.charAt(i)=='1') c++;
        }
        c =0;
        for(int i= boxes.length()-1;i>=0;i--){
            forw[i]=c;
            if(boxes.charAt(i)=='1') c++;
        }
        int[] ans = new int[boxes.length()];
        int a = 0;
        for(int i =1;i<boxes.length();i++){
            if(boxes.charAt(i)=='1'){
                a+=i;
            }
        }
        ans[0] = a;
        a =0;
        for(int i= boxes.length()-2;i>=0;i--){
            if(boxes.charAt(i)=='1'){
                a += (boxes.length()-1-i);
            }
        }
        ans[boxes.length()-1] = a;
        for(int i =1;i<boxes.length()-1;i++){
            if(boxes.charAt(i)=='1'){
                ans[i] = ans[i-1]+prev[i]-forw[i] - 1;
            }else{
                ans[i]= ans[i-1]+prev[i]-forw[i];
            }
        }
        return ans;
    }
}