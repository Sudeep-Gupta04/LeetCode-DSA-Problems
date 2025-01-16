class Solution {
    public int expressiveWords(String s, String[] words) {
        ArrayList<Integer> al = new ArrayList<>();
        s = s+ "/";
        int c=0;
        al.add(-1);
        for(int i =0;i<s.length()-1;i++){
            if (s.charAt(i) == s.charAt(i + 1) && c == 0) {
                c = 1;
            } else if (s.charAt(i) != s.charAt(i + 1)) {
                c = 0;
                //al.add(start);
                al.add(i);
            }
        }
        c=0;
        int ans=0;
        int count =0;
        for(String st:words){
            st = st+"/";
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(-1);
            for(int i =0;i<st.length()-1;i++){
                if (st.charAt(i) == st.charAt(i + 1) && c == 0) {
                    c = 1;
                } else if (st.charAt(i) != st.charAt(i + 1)) {
                    c = 0;
                    temp.add(i);
                }
            }
            if(temp.size()!=al.size()){
                c=1;
                break;
            }
            for(int i=0;i<al.size()-1;i++){
                int ls = al.get(i+1)-al.get(i);
                char chls = s.charAt(al.get(i)+1);
                int length = temp.get(i+1) - temp.get(i);
                char chwords = st.charAt(temp.get(i)+1);
                if(chls!=chwords){
                    c=1;break;
                }
                if(ls<length){
                    c=1;break;
                }
                if(ls<=2){
                    if(ls!=length){
                        c=1;break;
                    }
                }
            }
            if(c==0) ans++;
        }
        return ans;
    }
}