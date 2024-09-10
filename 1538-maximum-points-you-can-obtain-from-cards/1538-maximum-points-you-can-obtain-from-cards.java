class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum =0;
        int i;
        for(i =0;i<k;i++){
            sum +=cardPoints[i];
        }
        int q = cardPoints.length - 1;
        if(k==cardPoints.length) return sum;

        int ans = sum;
        int temp = 0;
        int points = 0;
        for(int j =i-1;j>=0;j--){
            temp +=cardPoints[q--];
            points +=cardPoints[j];
            ans = Math.max(ans,sum+temp-points);
        }
        return ans;
    }
}