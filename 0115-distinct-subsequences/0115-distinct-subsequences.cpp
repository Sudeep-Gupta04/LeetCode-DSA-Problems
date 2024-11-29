class Solution {
public:
    int numDistinct(string s, string t) {
        int m=s.size();
        int n=t.size();
        vector<vector<int>>dp(m+1,vector<int>(n+1,-1));
        // dp[i][j]-> i have matched till jth index of t
        auto rec=[&](int i,int j,auto &&rec)->int{
            if(j>=n){
                return 1;
            }
            if(i>=m) return 0;
            if(dp[i][j]!=-1) return dp[i][j];
            int ans=0;
            if(s[i]==t[j]){
                ans+=rec(i+1,j+1,rec);
                ans+=rec(i+1,j,rec);
            }
            else{
                ans+=rec(i+1,j,rec);
            }
            return dp[i][j]=ans;
        };
        return rec(0,0,rec);
    }
};