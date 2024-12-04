class Solution {
public:
    bool canMakeSubsequence(string a, string b) {
        int m=a.size();
        int n=b.size();
        int i=0,j=0;
        int ans=0;
        while(i<m and j<n){
            if(a[i]==b[j]||(b[j]-a[i]==1||(a[i]=='z' and b[j]=='a'))){
                i++,j++;
                ans++;
            }
            else{
                i++;
            }
            // cout<<i<<" "<<j<<" "<<ans<<endl;
        }
        return ans==n;
    }
};