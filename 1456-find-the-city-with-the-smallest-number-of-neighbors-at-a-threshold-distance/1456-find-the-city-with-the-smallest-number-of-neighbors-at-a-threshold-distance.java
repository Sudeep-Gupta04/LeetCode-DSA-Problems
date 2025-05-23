class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dis = new int[n][n];
        for(int i =0;i<n;i++) Arrays.fill(dis[i],(int)1e9);
        for(int i =0;i<edges.length;i++){
            dis[edges[i][0]][edges[i][1]] = edges[i][2];
            dis[edges[i][1]][edges[i][0]] = edges[i][2];
        } 
        for(int i =0;i<n;i++) dis[i][i] = 0;

        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                for(int k =0;k<n;k++){
                    dis[j][k] = Math.min(dis[j][k],dis[j][i]+dis[i][k]);
                }
            }
        }
        int pa = n;
        int city = 0;
        for(int i =0;i<n;i++){
            int cnt = 0;
            for(int j =0;j<n;j++){
                if(dis[i][j]<=distanceThreshold)  cnt++;
            }
            if(cnt<=pa){
                pa = cnt;
                city = i;
            }

        }
        return city;
    }
}