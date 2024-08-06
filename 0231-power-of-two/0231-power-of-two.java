class Solution {
    public boolean isPowerOfTwo(int n) {
        int count = 0;
        if (n<=0){
            return false;
        }
        if((n&(n-1))==0){
            return true;
        }
        return false;
    }
}