class Solution {
     public int minFlips(int a, int b, int c) {
        int num = a|b;
        int length = Math.max(Integer.toBinaryString(c).length(),Integer.toBinaryString(num).length());
        int bit =0;
        int ans =0;
        for(int i =0;i<length;i++){
            if((((1<<bit) & num) == 0) && (((1<<bit) & c) !=0)){
                ans++;
            }
            else if((((1<<bit) & num) !=0) && (((1<<bit) & c) ==0)){
                if((((1<<bit) & a) !=0) && (((1<<bit) & b) !=0)) ans +=2;
                else ans++;
            }
            bit++;
        }
        return ans;
    }
}