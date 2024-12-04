class Solution {
public:
    int maxScore(int n, int k, vector<vector<int>>& stayScore, vector<vector<int>>& travelScore) {
        //STATE
        //dp[i][j]=maximum possible points using i days and being at the jth city

        //final subproblem 
        //dp[k][0...n]
        vector<vector<int>>dp(k+1,vector<int>(n+1,-1));
        auto rec=[&](int i,int j,auto &&rec)->int{
            if(i==k) return 0;
            if(dp[i][j]!=-1) return dp[i][j];
            int stay=stayScore[i][j]+rec(i+1,j,rec);
            int travel=0;
            for(int k=0;k<n;k++){
                travel=max(travel,travelScore[j][k]+rec(i+1,k,rec));
            }
            return dp[i][j]=max(stay,travel);
        };
        int ans=0;
        //starting city
        for(int i=0;i<n;i++){
            // fill(dp.begin(), dp.end(), vector<int>(n, -1));
            ans=max(ans,rec(0,i,rec));
        }
        return ans;
    }
};