class Solution {
    class Pair
    {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> p = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                int x1 = o1.x;
                int y1 = o1.y;
                int x2 = o2.x;
                int y2 = o2.y;
                double a1 = Math.sqrt(Math.pow(x1,2) + Math.pow(y1,2));
                double a2 = Math.sqrt(Math.pow(x2,2) + Math.pow(y2,2));
                if(a2>a1) return 1;
                else return -1;
            }
        });
        for(int i =0;i<points.length;i++){
            p.add(new Pair(points[i][0],points[i][1]));
            if(p.size()>k) p.remove();
        }
        int[][] ans = new int[p.size()][2];
        int i = p.size()-1;
        while(!p.isEmpty()){
            Pair ps = p.poll();
            ans[i][0]= ps.x;
            ans[i][1]= ps.y;
            i = i-1;
        }
        return ans;
    }
}