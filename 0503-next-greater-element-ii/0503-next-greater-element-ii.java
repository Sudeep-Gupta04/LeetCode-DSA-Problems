class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] arr = new int[nums.length*2];
        int[] comp = new int[nums.length*2];
        int[]  ans = new int[nums.length];
        //int i =0;
        for (int i = 0; i < nums.length; i++) {
    arr[i] = nums[i]; // Fill the first half
}
for (int i = 0; i < nums.length; i++) {
    arr[i + nums.length] = nums[i]; // Fill the second half
}
int i =0;
        System.out.println(Arrays.toString(arr));
        Stack<Integer> st = new Stack<>();
        for( i=nums.length*2-1;i>=0;i--){
            while(!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();
            }
            if(st.isEmpty()) comp[i] = -1;
            else comp[i] = st.peek();
            st.push(arr[i]);
        }
        System.out.println(Arrays.toString(comp));
        for( i =0;i<nums.length;i++){
            ans[i]=comp[i];
        }
        return ans;
    }
}
// 1 2 3 4 3 1 2 3 4 3
// 2 3 4 4 4 2 3 4 . 4   

// 1 2 1 1 2 1
// 2   2 2   