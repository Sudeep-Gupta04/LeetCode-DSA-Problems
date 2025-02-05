class Solution {
    public int leastInterval(char[] tasks, int n) {
       PriorityQueue<pair> pq = new PriorityQueue<>(new Comparator<pair>() {
           @Override
           public int compare(pair o1, pair o2) {
               return Integer.compare(o2.freq,o1.freq);
           }
       });
       HashMap<Character,Integer> hm = new HashMap<>();
       for(int i =0;i<tasks.length;i++) hm.put(tasks[i],hm.getOrDefault(tasks[i],0)+1);
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            pq.add(new pair(entry.getKey(), entry.getValue()));
        }
        int ans =0;
        while(!pq.isEmpty()){
            Queue<pair> q = new ArrayDeque<>();
            int temp = n+1;
            while (!pq.isEmpty() && temp!=0){
                pair p = pq.remove();
                q.add(p);
                temp--;
            }
            int la = temp;
            int c =0;
            ans+=temp;
            while(!q.isEmpty()){
                pair p = q.remove();
                if(p.freq>1){
                     c=1;
                    p.freq -= 1;
                    pq.add(p);
                }
            }
            if(c==0) ans-=la;
        }
        return ans+tasks.length;
    }
}
class pair {
    char ch;
    int freq;
    pair(char ch, int freq){
        this.ch = ch;
        this.freq=freq;
    }
}