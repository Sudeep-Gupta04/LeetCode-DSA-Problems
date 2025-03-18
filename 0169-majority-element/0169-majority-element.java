class Solution {
    public int majorityElement(int[] nums) {
       int[] arr = nums; 
        if(arr.length==2){
            return arr[0]==arr[1]?arr[0]:-1;
        }
        Arrays.sort(arr);
        if(arr.length %2 !=0){
            int num = arr[arr.length/2];
            int c =0;
            for(int i =0;i<arr.length;i++){
                if(arr[i]==num)c++;
            }
            return c>(arr.length/2)?num:-1;
        }else{
            int num = arr[arr.length/2];
            int c =0;
            for(int i =0;i<arr.length;i++){
                if(arr[i]==num)c++;
            }
            return c>(arr.length/2)?num:-1;
        }
    }
}