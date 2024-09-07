

// public class Solution {
//     List<List<Integer>> l = new ArrayList<>();
    
//     public List<List<Integer>> threeSum(int[] nums) {
        
//         Arrays.sort(nums);
        
//         for (int i = 0; i < nums.length - 2; i++) {
//             fillvia2sum(i, nums, -nums[i]);
//         }
        
//         HashSet<List<Integer>> hs = new HashSet<>();
//         for (List<Integer> triplet : l) {
//             hs.add(triplet);
//         }
//         l.clear();
//         l.addAll(hs);

//         return l;
//     }

//     private void fillvia2sum(int s, int[] nums, int target) {
//         HashMap<Integer, Integer> mp = new HashMap<>();
//         for (int i = s + 1; i < nums.length; i++) {
//             if (mp.containsKey(target - nums[i])) {
//                 List<Integer> tm = new ArrayList<>();
//                 tm.add(nums[s]);
//                 tm.add(nums[i]);
//                 tm.add(target - nums[i]);
//                 l.add(new ArrayList<>(tm));
//             }
//             mp.put(nums[i], i);
//         }
//     }
// }


public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> output = new ArrayList<>();
        
        for (int i = 0; i < n - 2; i++) {
            int low = i + 1, high = n - 1;
            
            while (low < high) {
                if (nums[i] + nums[low] + nums[high] < 0) {
                    low++;
                } else if (nums[i] + nums[low] + nums[high] > 0) {
                    high--;
                } else {
                    set.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                }
            }
        }
        
        output.addAll(set);
        return output;
    }
}

