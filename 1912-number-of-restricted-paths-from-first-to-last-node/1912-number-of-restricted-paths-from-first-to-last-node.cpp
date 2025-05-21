class Solution {
public:
    int countRestrictedPaths(int n, vector<vector<int>>& edges) {
        int mod = 1e9 + 7;

        // Graph representation: adjacency list with {neighbor, weight}
        vector<vector<pair<int, int>>> al(n + 1);
        for (auto& edge : edges) {
            al[edge[0]].emplace_back(edge[1], edge[2]);
            al[edge[1]].emplace_back(edge[0], edge[2]);
        }

        // Dijkstra from node n
        vector<int> dis(n + 1, INT_MAX);
        dis[n] = 0;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> pq;
        pq.push({0, n});

        while (!pq.empty()) {
            auto [d, node] = pq.top(); pq.pop();
            if (d > dis[node]) continue;

            for (auto& [nbr, wt] : al[node]) {
                if (dis[nbr] > dis[node] + wt) {
                    dis[nbr] = dis[node] + wt;
                    pq.push({dis[nbr], nbr});
                }
            }
        }

        // Count restricted paths using a max-heap
        vector<int> cnt(n + 1, 0);
        cnt[1] = 1;
        priority_queue<pair<int, int>> q; // max-heap based on dis
        q.push({dis[1], 1});
        unordered_set<string> visited;

        while (!q.empty()) {
            auto [d, node] = q.top(); q.pop();
            string key = to_string(d) + "," + to_string(node);
            if (visited.count(key)) continue;
            visited.insert(key);

            for (auto& [nbr, wt] : al[node]) {
                if (dis[nbr] < dis[node]) {
                    cnt[nbr] = (cnt[nbr] + cnt[node]) % mod;
                    q.push({dis[nbr], nbr});
                }
            }
        }

        return cnt[n];
    }
};
