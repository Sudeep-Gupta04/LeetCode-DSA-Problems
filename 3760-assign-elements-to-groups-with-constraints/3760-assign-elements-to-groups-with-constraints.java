class Solution {
     public  int[] assignElements(int[] groups, int[] elements) {
        int[] ans = new int[groups.length];
        Arrays.fill(ans,-1);
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i =0;i<elements.length;i++){
            if(!hm.containsKey(elements[i])){
                hm.put(elements[i],i);
            }
        }
        for(int j =0;j<groups.length;j++){
            int idx = 100000;
            for (int i = 1; i <= Math.sqrt(groups[j]); i++) {
                if (groups[j] % i == 0) {
                    if(hm.containsKey(i)){
                        idx = Math.min(idx, hm.get(i));
                    }
                    int otherFactor = groups[j] / i;
                    if (hm.containsKey(otherFactor)) {
                        idx = Math.min(idx, hm.get(otherFactor));
                    } 
                }
            }
            if(idx!=100000) ans[j] = idx;
        }
        return ans;
     }
}