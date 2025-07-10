class Solution {
    long ans = 0;
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int i = 0, j = costs.length - 1;

        while (i <= j && candidates-- > 0) {
            left.add(costs[i++]);
            if (i <= j) right.add(costs[j--]);
        }
        if (i > j) {
            mergepq(left, right, k);
            return ans;
        }

        while (k--> 0) {
            int lval = left.isEmpty() ? Integer.MAX_VALUE : left.peek();
            int rval = right.isEmpty() ? Integer.MAX_VALUE : right.peek();

            if (lval <= rval) {
                ans += left.remove();
                if (i <= j) left.add(costs[i++]);
            } else {
                ans += right.remove();
                if (i <= j) right.add(costs[j--]); 
            }

            if (i > j) {
                mergepq(left, right, k);
                return ans;
            }
        }
        return ans;
    }

    public void mergepq(PriorityQueue<Integer> left, PriorityQueue<Integer> right, int k) {
        while (!left.isEmpty()) right.add(left.remove());
        while (k-- > 0 && !right.isEmpty()) ans += right.remove();
    }
}
