
class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });
            String ans = "";
        for(int i =arr.length-1;i>=0;i--){
                ans+= arr[i];
            }
        if(ans.charAt(0)=='0') return "0";
        return ans;
        }
}
