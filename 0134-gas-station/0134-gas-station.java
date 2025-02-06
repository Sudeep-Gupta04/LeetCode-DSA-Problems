class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] dif = new int[gas.length*2];
        int n = gas.length;
        int k =0;
        for(int i =0;i<gas.length;i++){
            dif[k++] = gas[i]-cost[i];
        }
        for(int i =0;i<gas.length;i++){
            dif[k++] = gas[i]-cost[i];
        }
        //dif[2*n] = -10000;
        System.out.println(Arrays.toString(dif));
        int s =0; int e =0; int sum =0;
        while(e<n*2){
            sum+=dif[e];
            if(sum>=0 && e-s+1==n){
                return s%n;
            }
            else if(sum<0){
                sum =0;
                s=e+1;
            }
            e++;
        }
        return -1;
    }
}