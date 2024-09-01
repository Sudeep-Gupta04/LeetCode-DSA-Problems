class Solution {
public:
    long long minDamage(int power, vector<int>& damage, vector<int>& health) {
        int n = damage.size();
        vector<int> moves(n);

        // Calculate the number of moves required to defeat each enemy
        for(int i = 0; i < n; i++) {
            moves[i] = (health[i] + power - 1) / power;  // Ceiling of health[i] / power
        }

        // Pair (damage/moves, index) and sort in descending order
        vector<pair<double, int>> vp(n);
        for(int i = 0; i < n; i++) {
            vp[i] = {double(damage[i]) / double(moves[i]), i};
        }
        sort(vp.begin(), vp.end(), greater<pair<double, int>>());

        // Calculate the minimum damage Bob will suffer
        long long ans = 0;
        int s = accumulate(damage.begin(), damage.end(), 0);
        for(int i = 0; i < n; i++) {
            auto p = vp[i];
            int ind = p.second;
            ans += static_cast<long long>(s) * moves[ind];
            s -= damage[ind];
        }

        return ans;
    }
};
