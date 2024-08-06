class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
         Arrays.sort(hours);
        int ans = 0;
        int index = 0;
         for(int i = 0;i<hours.length;i++){
          if(hours[i]>=target){
              return (hours.length-i);
          }
          else {
              ans = 0;
          }
         }
        return ans;
    }
}