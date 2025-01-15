class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int steps = finddis(target,0,0);
        System.out.println(steps);
        for(int i = 0;i< ghosts.length;i++){
            int x = ghosts[i][0];
            int y = ghosts[i][1];
            int reach = finddis(target,x,y);
            System.out.println(reach);
            if(reach <= steps){
                return false;
            }
        }
        return true;
    }
    public int finddis(int[] target,int x ,int y){
        if(target[0]==x || target[1]==y){
            if(target[0]==x) return Math.max(target[1],y) - Math.min(target[1],y);
            else return Math.max(target[0],x) - Math.min(target[0],x);
        }else{
            return Math.max(target[0],x) - Math.min(target[0],x) + Math.max(target[1],y) - Math.min(target[1],y);
        }
    }
}