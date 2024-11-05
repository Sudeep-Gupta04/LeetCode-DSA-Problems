class Solution {
    public int minChanges(String s) {
        int sum =0;
        int inc =0;
        int dec =0;
        int itod=0,dtoi =0;
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                sum++;
                inc++;
            }else {
                sum--;
                dec++;
            }
            
            if(sum%2==0 && sum!=0) {
                if(sum<0) sum+=2;
                else{
                    sum-=2;
                }
                if(s.charAt(i)=='1'){
                   inc-=2; 
                }else{
                    dec-=2;
                }
            }
            
        }
        return Math.max(inc,dec);
    }
}