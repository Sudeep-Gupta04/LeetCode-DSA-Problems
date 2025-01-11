class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i =0;i<s.length();i++){
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        int l =0;
        int c = 0;
        for(Map.Entry<Character,Integer> i: hm.entrySet()){
            char ch = i.getKey();
            int val = i.getValue();
            if(val%2==0) l+=val;
            else {
                if(c==0){
                    c = 1;
                    l+=val;
                }else l+=(val -1);  
            }
        }
        // if(l==1){
        //     return k==n;  
        // }
        //System.out.println(l);
        l = n - l +1;
        if(k>n || k<l) return false;
        else return true;

    }
}