class Solution {
 
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder("");
            
        PriorityQueue<ele> pq = new PriorityQueue<>(new Comparator<ele>() {
            @Override
            public int compare(ele o1, ele o2) {
                return o2.freq-o1.freq;   // max heap
            }
        });
        
        if(a!=0) pq.add(new ele('a',a));
        if(b!=0) pq.add(new ele('b',b));
        if(c!=0) pq.add(new ele('c',c));
        
        while (pq.size()>=2){
            ele e = pq.remove();


            char ch = e.ch;
            if(!sb.isEmpty() && sb.charAt(sb.length()-1)==e.ch){
                ele e2 = pq.remove();
                sb.append(e2.ch);
                e2.freq--;
                if(e2.freq!=0) pq.add(e2);
                pq.add(e);
                
            }else{
                if(e.freq > 2){
                    e.freq -= 2;
                    sb.append(ch).append(ch);
                    pq.add(e);
                }else{ // frequency less tahn 2;
                    int freq = e.freq;
                    for(int i =0;i<freq;i++) sb.append(ch);
                }
            }
        }
        ele e = pq.remove();
        for(int i =0;i<Math.min(2,e.freq);i++) sb.append(e.ch);
        return sb.toString();
    }
}
class ele{
        char ch;int freq;
        ele(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }