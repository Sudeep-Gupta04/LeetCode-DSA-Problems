class Solution {
     public int trap(int[] height) {
        int n = height.length;
        int[] pre = new int[height.length];
        pre[0] = -1;
        int[] suf = new int[height.length];
        suf[n-1] = -1;
        int max = height[0];
        for(int i = 1;i<n;i++){
            if(height[i]>max)  pre[i] = -1;
            else pre[i] = max;
            
            if(height[i]>max){
                max = height[i];
            }
        }
        max = height[n-1];
        for(int i =n-2;i>=0;i--){
            if(height[i]>max) suf[i] = -1;
            else suf[i] = -1;
            
            suf[i]=max;
            if(height[i]>max) max = height[i];
        }
        int ans =0;
        for(int i =1;i<height.length-1;i++){
            int heigth = Math.min(pre[i],suf[i]) - height[i];
            if(heigth<0) ans+=0;
            else ans+=heigth;
        }
        return ans;
    }
}