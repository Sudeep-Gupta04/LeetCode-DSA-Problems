class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int s = 0;
        int e = numbers.length-1;
        int[] arr = new int[2];
        int count =0;
        while(s<e){
            if(numbers[s]+numbers[e]==target){
                arr[0]=s+1;
                arr[1]=e+1;
                return arr;
            }
            else if(numbers[s]+numbers[e]>target) e--;
            else s++;
        }
        return arr;
    }
}