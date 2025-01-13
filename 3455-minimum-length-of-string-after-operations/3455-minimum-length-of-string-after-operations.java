class Solution {
    public int minimumLength(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        int ans = 0;
        for(Map.Entry i:hm.entrySet()){
            int val = (int) i.getValue();
            System.out.println(i);
            if(val <= 2) ans+=val;
            else{
                if(val%2==0) ans+=2;
                else ans+=1;
            }
        }
        return ans;
    }
}