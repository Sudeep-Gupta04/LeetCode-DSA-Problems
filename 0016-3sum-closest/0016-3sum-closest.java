class Solution {
    int ans = Integer.MAX_VALUE;
    List<Integer> l = new ArrayList<>();
    
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            solvevia2sum(nums, target - nums[i], i);
        }
        l.add(target);
        Collections.sort(l);
        
        int idx = l.indexOf(target);
        
        int idxlb = Math.max(idx - 1, 0);
        int idxub = Math.min(idx + 1, l.size() - 1);

        if (idx == 0) return l.get(idxub);
        if (idx == l.size() - 1) return l.get(idxlb);
        if (target - l.get(idxlb) > l.get(idxub) - target) return l.get(idxub);
        else return l.get(idxlb);
    }

     public  void solvevia2sum(int[] nums,int target,int start){
        int s = start+1;
        int e = nums.length-1;
        int tl = Integer.MIN_VALUE;int tu = Integer.MAX_VALUE;
        while(s<e){
            int temp = nums[s] + nums[e];
            if(temp>target){
                tu = Math.min(tu,temp);
                e--;
            }else {
                tl = Math.max(tl,temp);
                s++;
            }
        }
        if(tl==Integer.MIN_VALUE){
            l.add(tu+nums[start]);
        }
        else if(tu==Integer.MAX_VALUE){
            l.add(tl+nums[start]);
        }
        else if((target-tl)>(tu-target)){
            int t = tu+nums[start];
            l.add(t);
        }else {
            int t = tl+nums[start];
            l.add(t);
        }
    }
}
