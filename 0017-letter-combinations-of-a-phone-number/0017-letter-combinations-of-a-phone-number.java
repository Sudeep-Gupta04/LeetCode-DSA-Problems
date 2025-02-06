class Solution {
      public List<String> letterCombinations(String digits) {
        HashMap<Integer,List<Character>> hm = new HashMap<>();
        
        hm.put(2,List.of('a','b','c'));
        hm.put(3,List.of('d','e','f'));
        hm.put(4,List.of('g','h','i'));
        hm.put(5,List.of('j','k','l'));
        hm.put(6,List.of('m','n','o'));
        hm.put(7,List.of('p','q','r','s'));
        hm.put(8,List.of('t','u','v'));
        hm.put(9,List.of('w','x','y','z'));
        List<String> ans = new ArrayList<>();
        if(digits.length()==0) return ans;
        compute(0,digits,hm,"",ans);
        return ans;
    }
    public void compute(int idx,String digits,HashMap<Integer,List<Character>> hm,String temp, List<String> ans){
        if(idx>=digits.length()){
            ans.add(temp);
            return;
        }
        
        int num = Integer.parseInt(digits.charAt(idx)+"");
        List<Character> l = hm.get(num);
        for(char ch:l){
            compute(idx+1,digits,hm,temp+ch,ans);
        }
    }
}