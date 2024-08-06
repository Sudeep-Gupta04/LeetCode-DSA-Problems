class Solution {
    class Pair
    {
        int x;
        int y;

        public Pair(int a, int b)
        {
            x = a;
            y = b;
        }
    }

    public int findLongestChain(int[][] pairs) {
         Pair[] p = new Pair[pairs.length];
        for(int i = 0;i<pairs.length;i++){
            p[i] = new Pair(pairs[i][0],pairs[i][1]);
        }
        Arrays.sort(p, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return Integer.compare(p1.y, p2.y); 
            }
        });
        int maxi = 1;
        int val = p[0].y;
        for(int i =1;i<p.length;i++){
            if(p[i].x>val){
                maxi++;
                val = p[i].y;
            }
        }
        return maxi;
    }
}