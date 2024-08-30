class Solution {
public:
    void func(int mask,vector<int>a,vector<int>& nums,set<vector<int>>&ans){
        int n=nums.size();
        if(__builtin_popcount(mask)==n){
            ans.insert(a);
        }
        for(int i=0;i<n;i++){
            if(((1<<i)&mask)==0){
                vector<int>v=a;
                // v=ans;
                v.push_back(nums[i]);
                func(mask|(1<<i),v,nums,ans);
            }
        }
    }
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        set<vector<int>>ans;
        vector<int>a;
        func(0,a,nums,ans);
        vector<vector<int>>ans1;
        for(auto i : ans) ans1.push_back(i);
        return ans1;
    }
};