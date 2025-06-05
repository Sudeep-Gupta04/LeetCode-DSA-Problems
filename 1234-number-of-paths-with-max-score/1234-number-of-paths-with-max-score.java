class Solution {
    int cost[][];
    int path[][];
    int mod = (int)1e9+7;
    int tar ;
    public int[] pathsWithMaxScore(List<String> board) {
         int n = board.size();
        int m = board.get(0).length();
        cost = new int[n][m];
        path = new int[n][m];
        String newr = board.get(n-1).substring(0,m-1) + "0";
        board.set(n-1,newr);
        String newr1 = "0" + board.get(0).substring(1,m);
        board.set(n-1,newr);
        board.set(0,newr1);
        for(int[] i:cost) Arrays.fill(i,-1);
        for(int[] i:path) Arrays.fill(i,0);
        helperdp(0,0,board,n,m);
        if(cost[n-1][m-1]<0) return new int[]{0,0};
        else  return new int[]{cost[0][0],path[0][0]};
    }

    private int helperdp(int i, int j, List<String> board, int n, int m) {
        if(i==n-1 && j==m-1) {
            cost[i][j] = 0;
            path[i][j] = 1;
            return 0;
        }
        if(i>=n || j>= m || board.get(i).charAt(j)=='X') return Integer.MIN_VALUE;
        if(cost[i][j]!=-1) return cost[i][j];
        int[] x = {0,1,1};
        int fixec = board.get(i).charAt(j)-'0';
        int p1 = fixec + helperdp(i+1,j,board,n,m);
        if(cost[i][j]<p1 && i+1<n){
            cost[i][j] = p1;
            path[i][j] = path[i+1][j];
        }else if(cost[i][j]==p1 && i+1<n){
            path[i][j] = (path[i][j] + path[i+1][j])%mod;
        }
        int p2 = fixec + helperdp(i,j+1,board,n,m);
        if(cost[i][j]<p2 && j+1<m){
            cost[i][j] = p2;
            path[i][j] = path[i][j+1];
        }
        else if(cost[i][j]==p2 && j+1<m){
            path[i][j] = (path[i][j] + path[i][j+1])%mod;
        }

        int p3 = fixec + helperdp(i+1,j+1,board,n,m);
        if(cost[i][j]<p3 && i+1<n && j+1<m){
            cost[i][j] = p3;
            path[i][j] = path[i+1][j+1];
        }
        else if(cost[i][j]==p3 && i+1<n && j+1<m){
            path[i][j] = (path[i][j] + path[i+1][j+1])%mod;
        }
        return cost[i][j];
    }
}
//  2 3
//2 X 2
//1 2 0