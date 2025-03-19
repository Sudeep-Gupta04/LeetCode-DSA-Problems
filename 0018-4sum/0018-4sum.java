import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        Arrays.sort(arr);
        HashSet<String> dubli = new HashSet<>();
        List<List<Integer>> al = new ArrayList<>();

        for (int i = 0; i <= arr.length - 4; i++) {
            for (int j = i + 1; j <= arr.length - 3; j++) {
                long tr = (long) target - arr[i] - arr[j]; // Use long to prevent overflow
                HashSet<Long> hm = new HashSet<>(); // Use HashSet<Long> instead of HashSet<Integer>

                for (int k = j + 1; k < arr.length; k++) {
                    if (hm.contains(tr - arr[k])) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        String st = arr[i] + "," + arr[j] + "," + (tr - arr[k]) + "," + arr[k];

                        if (!dubli.contains(st)) {
                            temp.add(arr[i]);
                            temp.add(arr[j]);
                            temp.add((int) (tr - arr[k])); // Safe cast
                            temp.add(arr[k]);
                            al.add(temp);
                        }
                        dubli.add(st);
                    }
                    hm.add((long) arr[k]); 
                }
            }
        }
        return al;
    }
}
