class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();
        for(int i =0;i< strs.length;i++){
            String st = strs[i];
            int[] freq = new int[26];
            for(int j =0;j<st.length();j++){
                char ch = st.charAt(j);
                freq[ch-97]++;
            }
            String code = "";
            for(int j=0;j<26;j++){
                code+=((char)(j+97)+""+freq[j]);
            }
            if(mp.containsKey(code)){
               List<String> l = mp.get(code);
               l.add(st);
               mp.put(code,l);
            }else{
                ArrayList<String> n  = new ArrayList<>();
                n.add(st);
                mp.put(code,n);
            }
        }
        for (Map.Entry<String, List<String>> entry : mp.entrySet()) {
            System.out.println("Key: " + entry.getKey().toString() + ", Value: " + entry.getValue());
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>> i: mp.entrySet()){
            ans.add((i.getValue()));
        }
        return ans;
    }
}