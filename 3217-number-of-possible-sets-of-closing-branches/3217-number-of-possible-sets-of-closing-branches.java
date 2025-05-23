class Solution {
        public int numberOfSets(int n, int maxDistance, int[][] roads) {
        HashMap<List,Integer> hm = new HashMap<>();
        for(int i =0;i<roads.length;i++){
            List<Integer> l = new ArrayList<>(Arrays.asList(roads[i][0],roads[i][1]));
            List<Integer> lr = new ArrayList<>(Arrays.asList(roads[i][1],roads[i][0]));
            int cost = roads[i][2];
            if(!hm.containsKey(l)  && !hm.containsKey(lr)){
                hm.put(l,cost);
                hm.put(lr,cost);
            }else{
                if(hm.get(l)>cost) {
                    hm.put(l, cost);
                    hm.put(lr, cost);
                }
            }
        }
        int[][] newroad = new int [hm.size()][2];
        int z =0;
        for(Map.Entry<List,Integer> i:hm.entrySet()){
            newroad[z++] = new int[]{(int) i.getKey().get(0),(int) i.getKey().get(1),i.getValue()};
        }
        roads = newroad;
        HashSet<Integer> hs = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();
        hs.add(0);
        q.add(0);
        int c = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int j =0;j<size;j++){
                int num = q.remove();
                if(isValid(num,maxDistance,roads,n)) {
                    c++;
                }
                for(int i=0;i<n;i++){
                    if((num & (1<<i))==0  && !hs.contains(num|(1<<i))){
                        hs.add(num|(1<<i));
                        q.add(num|(1<<i));
                    }
                }
            }
        }
        return c;
    }

    private boolean isValid(int num, int maxDistance, int[][] roads,int n) {
        int[][] dis = new int[n][n];
        
        for(int i =0;i<n;i++){
            Arrays.fill(dis[i],(int)1e9);
            dis[i][i] = 0;
        }
        for(int i=0;i< roads.length;i++){
            int x = roads[i][0];
            int y = roads[i][1];
            int cost = roads[i][2];
            if(((num & (1<<x))!=0) && ((num & (1<<y))!=0)){
                dis[x][y] = cost;
                dis[y][x] = cost;
            }
        }
        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                for(int k=0;k<n;k++){
                    dis[j][k] = Math.min(dis[j][k],dis[j][i] + dis[i][k]);
                }
            }
        }
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dis[i][j]>maxDistance && (num & (1<<i))!=0 && (num & (1<<j))!=0) return false;
            }
        }
        return true;
    }
}