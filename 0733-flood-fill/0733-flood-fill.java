class Solution {
     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] vis = new int[image.length][image[0].length];
        for(int i =0;i<image.length;i++){
            for(int j =0;j<image[0].length;j++){
                vis[i][j] = image[i][j];
            };
        }
        dfs(image,vis,sr,sc,color);
        return vis;
    }

    private void dfs(int[][] image, int[][] vis, int i, int j, int color) {
        vis[i][j] = color;
        int [] row = {-1,0,1,0};
        int [] col = {0,1,0,-1};
        for(int num =0;num<row.length;num++){
            int x = i+row[num];
            int y = j+col[num];
            if(x>=image.length || x<0 || y>=image[0].length || y<0) continue;
            else {
                if(image[i][j]==image[x][y] && vis[x][y]!=color){
                    dfs(image,vis,x,y,color);
                }
            }
        }
    }
}