class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int min=1;
        int max=*max_element(piles.begin(),piles.end());
        int ans=-1;
        while(min<=max){
            long long mid=min+(max-min)/2;
            long long temp=0;
            for(auto i : piles){
                temp+=((i+mid-1)/mid);
            }
            if(temp<=h){
                ans=mid;
                max=mid-1;
            }
            else{
                min=mid+1;
            }
        }
        return ans;
    }
};