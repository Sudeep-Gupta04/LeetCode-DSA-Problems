class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<bool>> vis(n, vector<bool>(m, false));
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    ans = dfs(i, j, vis, grid, n, m);
                }
            }
        }

        return ans;
    }

private:
    int dfs(int i, int j, vector<vector<bool>>& vis, vector<vector<int>>& grid, int n, int m) {
        vis[i][j] = true;
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};
        int ans = 4;

        for (int k = 0; k < 4; ++k) {
            int newx = i + dx[k];
            int newy = j + dy[k];

            if (newx >= 0 && newx < n && newy >= 0 && newy < m && grid[newx][newy] == 1) {
                if (vis[newx][newy]) {
                    ans--;
                } else {
                    ans += dfs(newx, newy, vis, grid, n, m) - 1;
                }
            }
        }

        return ans;
    }
};
