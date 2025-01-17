class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int zor=0;
        for(int i =0;i<derived.length;i++) zor^=derived[i];
        return (zor==0);
    }
}