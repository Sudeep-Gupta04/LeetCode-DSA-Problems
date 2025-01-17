import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        Pairr[] arr = new Pairr[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pairr(difficulty[i], profit[i]);
        }

        Arrays.sort(arr, (a, b) -> a.dif == b.dif ? b.profit - a.profit : a.dif - b.dif);
        int[] max = new int[n];
        max[0] = arr[0].profit;
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(max[i - 1], arr[i].profit);
        }
        int ans = 0;
        for (int w : worker) {
            ans += valid(arr, max, w);
        }

        return ans;
    }

    public int valid(Pairr[] arr, int[] max, int w) {
        int s = 0, e = arr.length - 1, res = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid].dif <= w) {
                res = max[mid];
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return res;
    }
}

class Pairr {
    int dif;
    int profit;

    public Pairr(int dif, int profit) {
        this.dif = dif;
        this.profit = profit;
    }
}
