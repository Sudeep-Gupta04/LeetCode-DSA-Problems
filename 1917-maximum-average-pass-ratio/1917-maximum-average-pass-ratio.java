class Solution {
    class Pair implements Comparable<Pair> {
        Integer num;
        Integer den;

        public Pair(Integer num, Integer den) {
            this.num = num;
            this.den = den;
        }

        @Override
        public int compareTo(Pair other) {
            Pair p1 = this;
            Pair p2 = other;

            double df1 = ((double) (p1.num + 1) / (p1.den + 1)) - ((double) p1.num / p1.den);
            double df2 = ((double) (p2.num + 1) / (p2.den + 1)) - ((double) p2.num / p2.den);

            return Double.compare(df2, df1);
        }
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i =0;i<classes.length;i++){
            pq.add(new Pair(classes[i][0],classes[i][1]));
        }
        while(extraStudents-->0){
            Pair temp = pq.remove();
            pq.add(new Pair(temp.num+1,temp.den+1));
        }
        int size = pq.size();
        double ans = 0;
        while(!pq.isEmpty()){
            Pair temp = pq.remove();
            ans += ((double) temp.num / temp.den);
        }
        return (double) (ans/size);
    }
}