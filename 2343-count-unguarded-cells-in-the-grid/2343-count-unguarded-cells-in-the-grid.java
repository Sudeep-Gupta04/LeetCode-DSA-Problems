class Solution {
       public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] vis = new char[m][n];
        for(int i =0;i<walls.length;i++){
            int iidx = walls[i][0];
            int jidx = walls[i][1];
            vis[iidx][jidx] = 'W';
        }
        for(int i =0;i<guards.length;i++){
            int iidx = guards[i][0];
            int jidx = guards[i][1];
            vis[iidx][jidx] = 'G';
        }

        for(int i =0;i<guards.length;i++){
            int gi = guards[i][0];
            int gj = guards[i][1];

            // up
            for(int k = gi-1;k>=0;k--){
                if(vis[k][gj]=='W' || vis[k][gj]=='G') break;
                vis[k][gj] = '_';
            }
            // down
            for(int k = gi+1;k<vis.length;k++){
                if(vis[k][gj]=='W' || vis[k][gj]=='G') break;
                vis[k][gj] = '_';
            }
            //rigth
            for(int k = gj+1;k<vis[0].length;k++){
                if(vis[gi][k]=='W' || vis[gi][k]=='G') break;
                vis[gi][k] = '_';
            }
            //left
            for(int k = gj-1;k>=0;k--){
                if(vis[gi][k]=='W' || vis[gi][k]=='G') break;
                vis[gi][k] = '_';
            }
        }
        int ans =0;
        for(int i =0;i<vis.length;i++){
            for(int j =0;j<vis[0].length;j++){
                if(vis[i][j]=='\u0000') ans++;
            }
        }
        return ans;
    }
}