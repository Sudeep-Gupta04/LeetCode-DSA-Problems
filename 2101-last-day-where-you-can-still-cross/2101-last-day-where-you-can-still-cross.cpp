class Solution {
public:
    int latestDayToCross(int row, int col, vector<vector<int>>& cells) {
        int n = cells.size();
        unordered_map<int, int> mp; // key = x * col + y

        for (int i = 0; i < n; ++i) {
            int key = (cells[i][0] - 1) * col + (cells[i][1] - 1);
            mp[key] = i;
        }

        int s = 0, e = n - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (isValid(mid, mp, row, col))
                s = mid + 1;
            else
                e = mid - 1;
        }
        return e + 1;
    }

    bool isValid(int mid, unordered_map<int, int>& mp, int row, int col) {
        vector<vector<bool>> vis(row, vector<bool>(col, false));
        queue<pair<int, int>> q;

        for (int i = 0; i < col; ++i) {
            int key = 0 * col + i;
            if (mp.count(key) && mp[key] <= mid) continue;
            q.push({0, i});
            vis[0][i] = true;
        }

        vector<int> dx = {-1, 0, 1, 0};
        vector<int> dy = {0, 1, 0, -1};

        while (!q.empty()) {
            auto [x, y] = q.front(); q.pop();

            for (int i = 0; i < 4; ++i) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < row && ny >= 0 && ny < col && !vis[nx][ny]) {
                    int key = nx * col + ny;
                    if (mp.count(key) && mp[key] <= mid) continue;
                    q.push({nx, ny});
                    vis[nx][ny] = true;
                }
            }
        }

        for (int i = 0; i < col; ++i) {
            if (vis[row - 1][i]) return true;
        }
        return false;
    }
};