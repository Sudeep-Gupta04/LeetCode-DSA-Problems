class Solution {
public:
    int minOperations(vector<int>& v) {
        int n=v.size();
        int ans=0;
        for(int i=0;i<n-2;i++){
            if(v[i]==0){
                v[i]^=1;
                v[i+1]^=1;
                v[i+2]^=1;
                // if(v[i+1]==1) v[i+1]^=1;
                // else if(v[i+1]==0) v[i+1]^=1;
                // if(v[i+2]==1) v[i+2]^=1;
                // else if(v[i+2]==0) v[i+2]^=1;
                ans++;
            }
        }
        bool chk= false;

        for(int i=0;i<n;i++){
            if(v[i]==0){
                chk=true;
                break;
            }
        }
    if(chk) return -1;
    else return ans;

    }
};