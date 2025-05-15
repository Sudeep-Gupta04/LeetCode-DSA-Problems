class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        HashSet<Integer> hs = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        hs.add(start);
        int c = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int num = q.remove();

                if (num == goal) return c;

                if (num >= 0 && num <= 1000) {
                    for (int i : nums) {
                        int p1 = num + i;
                        int p2 = num - i;
                        int p3 = num ^ i;

                        if (!hs.contains(p1)) {
                            if((p1>1000 || p1<0)&& p1!=goal){

                            }
                            else {
                                hs.add(p1);
                                q.add(p1);
                            }
                        }
                        if (!hs.contains(p2)) {
                            if((p2>1000 || p2<0)&& p2!=goal) {}
                            else {
                                hs.add(p2);
                                q.add(p2);
                            }
                        }
                        if (!hs.contains(p3)) {
                            if((p3>1000 || p3<0) && p3!=goal) {}
                            else{
                                hs.add(p3);
                                q.add(p3);
                            }
                        }
                    }
                }
            }
            c++;
        }

        return -1;
    }
}
