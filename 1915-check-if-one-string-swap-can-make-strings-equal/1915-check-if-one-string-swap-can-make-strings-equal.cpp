class Solution {
public:
    bool areAlmostEqual(string s1, string s2) {
        vector<int>ind;
        int n=s1.size();
        for(int i=0;i<n;i++){
            if(ind.size()>2) return false;
            if(s1[i]!=s2[i]) ind.push_back(i);
        }
        if(ind.empty()) return true;
        if(ind.size()>2 or ind.size()==1) return false;
        swap(s1[ind[0]],s1[ind[1]]);
        if(s1==s2) return true;
        swap(s1[ind[0]],s1[ind[1]]);
        swap(s2[ind[0]],s2[ind[1]]);
        return (s1==s2);
    }
};