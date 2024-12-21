class Pair implements Comparable<Pair> {
        char ch;
        Integer val;

        public Pair(char ch, Integer val) {
            this.ch = ch;
            this.val = val;
        }

        @Override
        public int compareTo(Pair other) {
            int charComparison = Character.compare(this.ch, other.ch);
            if (charComparison != 0) {
                return charComparison;
            }
            return this.val.compareTo(other.val);
        }
    }

class Solution {
     public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int[] val = new int[26];
        for(int i=0;i<s.length();i++){
           int idx = s.charAt(i) - 97;
           val[idx] = val[idx]+1;
        }
        for(int i =0;i<val.length;i++){
            if(val[i]!=0){
                pq.add(new Pair((char)(i+97),val[i]));
            }
        }
        StringBuilder ans = new StringBuilder("");
        while(pq.size()!=1){
            Pair temp = pq.remove();
            if(ans.isEmpty() || ans.charAt(ans.length()-1)!=temp.ch){
                
                for(int i =0;i<Math.min(repeatLimit,temp.val);i++){
                    ans.append(temp.ch);
                }
                temp.val -= repeatLimit;
                if(temp.val>0) pq.add(new Pair(temp.ch,temp.val));
                
            }else {
                Pair second = pq.remove();
                pq.add(temp);
                ans.append(second.ch);
                second.val = second.val-1;
                if(second.val>0) pq.add(new Pair(second.ch,second.val));
            }
           
        }
        Pair p = pq.remove();
        for(int i =0;i<Math.min(repeatLimit,p.val);i++){
            ans.append(p.ch);
        }
        return ans.toString();
    }
}