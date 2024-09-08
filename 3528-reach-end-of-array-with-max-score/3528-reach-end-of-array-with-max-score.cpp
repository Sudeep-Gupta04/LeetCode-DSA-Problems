class Solution {
public:
    long long findMaximumScore(vector<int>& nums) {
        long long maxx=0,ans=0;
        for(auto i : nums){
            ans+=maxx;
            maxx=max(maxx,i*1LL);
        }
        return ans;
    }
};