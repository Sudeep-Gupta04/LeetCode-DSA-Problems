class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> s = new ArrayList<>();
        for(int i =0;i<target.length;i++){
            if(i==0){
                int num = target[i]-1;
                for(int q =1;q<=num;q++){
                    s.add("Push");
                    s.add("Pop");
                }
                s.add("Push");
            } else{
                PopulateList(s,target[i],target[i-1]);
            }
            
        }
    return s;
    }

    private void PopulateList(List<String> s, int cur,int pre) {
        int diff = cur-pre-1;
        for(int q =1;q<=diff;q++){
            s.add("Push");
            s.add("Pop");
        }
        s.add("Push");
    }
}