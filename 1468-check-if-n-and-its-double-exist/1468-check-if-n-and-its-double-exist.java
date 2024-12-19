class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i =0;i<arr.length;i++){
            if(hs.contains(2*arr[i])) return true;
            hs.add(arr[i]);
        }
        hs.clear();
        for(int i =arr.length-1;i>=0;i--){
            if(hs.contains(2*arr[i])) return true;
            hs.add(arr[i]);
        }
        return false;
    }
}