class Solution {
public:
    int countCompleteComponents(int n, vector<vector<int>>& edges) {
        vector<vector<int>>adj(n);
        for(auto i : edges) adj[i[0]].push_back(i[1]),adj[i[1]].push_back(i[0]);
        vector<int>visited(n,0),visited2(n,0);
        auto dfs=[&](int node,auto &&dfs)->int{
            int edges=adj[node].size();
            visited[node]=1;
            for(auto j : adj[node]){
                if(!visited[j])edges+=dfs(j,dfs);
            }    
            return edges;
        };
        auto dfs2=[&](int node,auto &&dfs2)->int{
            int nds=1;
            visited2[node]=1;
            for(auto j : adj[node]){
                if(!visited2[j])nds+=dfs2(j,dfs2);
            }    
            return nds;
        };

        int ans=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                int edges=dfs(i,dfs)/2;
                int nodes=dfs2(i,dfs2);
                //nodes C 2 = edges
                if((nodes*(nodes-1))/2==edges) ans++;
            }
        }

        return ans;
    }
};