class Solution {
public:
    int maxScoreSightseeingPair(vector<int>& values) {
        int mx=0;
        int ans=0;
        int n=values.size();
        for(int i=0;i<n;i++){
            ans=max(ans,mx+values[i]-i);
            mx=max(mx,values[i]+i);
        }
        return ans;
    }
};