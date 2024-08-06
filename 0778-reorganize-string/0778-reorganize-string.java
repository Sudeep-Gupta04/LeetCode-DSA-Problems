class Solution {
    public static class Pairs implements Comparable<Pairs> {
        int value;
        char ch;

        Pairs(int value, char ch) {
            this.value = value;
            this.ch = ch;
        }

        @Override
        public int compareTo(Pairs other) {
            return Integer.compare(other.value, this.value); 
        }
    }
    public String reorganizeString(String s) {
        String str = s;
        HashMap<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        
        PriorityQueue<Pairs> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            pq.add(new Pairs(entry.getValue(), entry.getKey()));
        }
        int n = str.length();
         if (pq.peek().value > (str.length() + 1) / 2) return "";
         StringBuilder ans = new StringBuilder();
        Pairs prev = new Pairs(0, '#'); 
        
        while (!pq.isEmpty()) {
            Pairs current = pq.poll();
            ans.append(current.ch);

            
            if (prev.value > 0) {
                pq.add(prev);
            }

           
            current.value--;
            prev = current;
        }
        //if(prev.value>0) return "";
        return ans.toString();
    }
}