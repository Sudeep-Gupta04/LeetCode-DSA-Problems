class Solution {
     public int findCircleNum(int[][] isConnected) {
        int count =0;
        boolean[][] visit = new boolean[isConnected.length][isConnected[0].length];
        for(int i =0;i<isConnected.length;i++){
            for(int j =0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1 && !visit[i][j]){
                    bfs(i,j,visit,isConnected);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(int i, int j, boolean[][] visit, int[][] isConnected) {
        Queue<Integer> q = new ArrayDeque<>();
        if(i==j) {
            q.add(i);
            visit[i][j]= true;
        }
        else {
            q.add(i);q.add(j);
            visit[i][j] = true;
            visit[j][i] = true;
        }
        while(!q.isEmpty()){
            int num = q.poll();
            for(int k = 0;k<isConnected[0].length;k++){
                if(!visit[num][k] && isConnected[num][k]==1){
                    if(num!=k) {
                        visit[k][num] = true;
                        visit[num][k] = true;
                        q.add(k);
                    }else{
                        visit[k][num] = true;
                        q.add(num);
                    }
                }
            }
        }
    }
}