public class Pair implements Comparator<Pair> {
    int x;
    int w;

    public Pair(int x, int w) {
        this.x = x;   // fixed: was "this.w = y;" (typo)
        this.w = w;
    }

    @Override
    public int compare(Pair o1, Pair o2) {
        return o1.x - o2.x;
    }
    @Override
    public String toString() {
        return "(" + (x+1) + ", " + w + ")";
    }
}

class Solution {
    public int minScore(int n, int[][] roads) {

            ArrayList<ArrayList<Integer>> al = new ArrayList<>();
            HashSet<Integer> hs = new HashSet<>();
            for (int i = 0; i < n; i++) {
                al.add(new ArrayList<>());
            }
            for (int[] i : roads) {
                al.get(i[0] - 1).add(i[1]-1);
                al.get(i[1] - 1).add(i[0]-1);
            }
            boolean[] vis = new boolean[n];
            Queue<Integer> q = new ArrayDeque<>();
            q.add(0);
            vis[0] = true;
            while (!q.isEmpty()) {
                int nod = q.remove();
                hs.add(nod);
                for (int i : al.get(nod)) {
                    if (!vis[i]) {
                        vis[i] = true;
                        q.add(i);
                    }
                }
            }
            int ans = 100009;
            for(int i =0;i<roads.length;i++){
                if(hs.contains(roads[i][0]-1) && hs.contains(roads[i][1]-1)){
                    ans = Math.min(ans,roads[i][2]);
                }
            }

            return ans;
        }
}
