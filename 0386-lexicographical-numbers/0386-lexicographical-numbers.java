class Solution {
     public List<Integer> lexicalOrder(int n){
        List<String> l = new ArrayList<>();
        
        for(int i =1;i<=n;i++){
            l.add(i +"");
        }
        Collections.sort(l, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        List<Integer> ans = new ArrayList<>();
        for(int i =0;i<l.size();i++){
            ans.add(Integer.parseInt(l.get(i)));
        }
        return ans;
    }
}