class Solution {
        public int countServers(int[][] grid) {
        int ans =0;
        Queue<Pair> q= new ArrayDeque<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i= 0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) {
                    q.add(new Pair(i,j));
                    //vis[i][j] = true;
                }
            }
        }
        // while(!q.isEmpty()){
        //    // Pair p = q.remove();
        //     System.out.println(p.x+" "+ p.y);
        // }
        while(!q.isEmpty()){
            Pair p = q.remove();
            int x = p.x; int y = p.y;
            int cr =0;
            for(int i =0;i<grid.length;i++){
                if(grid[i][y]==1){
                    cr++;
                    vis[i][y] = true;
                }
            }
            int cc =0;
            for(int j =0;j<grid[0].length;j++){
                if(grid[x][j]==1) {
                    cc++;
                    vis[x][j] = true;
                }
            }
            if(cc<=1 && cr<=1) vis[x][y] = false;

            System.out.println(cc+" "+ cr);
        }
        for(int i =0;i<vis.length;i++){
            for(int j =0;j<vis[0].length;j++){
                if(vis[i][j]) ans++;
            }
        }
        return ans;
    }
}
class Pair{
    int x;int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

}