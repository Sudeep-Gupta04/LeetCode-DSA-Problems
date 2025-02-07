class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;
        int x = 0; int y =0; int z =0;
        for(int i =0;i<n;i++){
            if(triplets[i][0]>target[0] || triplets[i][1]>target[1] || triplets[i][2]>target[2]){
                continue;
            }
            else{
                x = Math.max(triplets[i][0],x);
                y = Math.max(triplets[i][1],y);
                z = Math.max(triplets[i][2],z); 
            }
        }
        if(x==target[0] && y==target[1] && z==target[2]) return true;;
        return false;
    }    
}
class tri {
    int x, y, z;
    tri(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
