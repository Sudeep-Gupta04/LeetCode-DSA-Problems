class Solution {
        public int[] rearrangeBarcodes(int[] barcodes) {
        int[] ans = new int[barcodes.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare((int)o2.value,(int)o1.value);
            }
        });
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i =0;i<barcodes.length;i++){
            hm.put(barcodes[i],hm.getOrDefault(barcodes[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> i: hm.entrySet()){
            pq.add(new Pair((int)i.getKey(),(int)i.getValue()));
        }
        for(int i =0;i<barcodes.length;i++){
            Pair<Integer,Integer> p = pq.remove();
            if(i!=0 && ans[i-1]==p.key){
                Pair<Integer,Integer> p2 = pq.remove();
                ans[i]=p2.key;
                if(p2.value>1)pq.add(new Pair((int)p2.key,((int)p2.value) - 1));
                if(p.value>1)pq.add(new Pair(p.key,p.value));
            }else{
                ans[i]=p.key;
                if(p.value>1)pq.add(new Pair(p.key,p.value - 1));
            }
        }
        return ans;
    }
}
class Pair<K extends Comparable<K>, V extends Comparable<V>> implements Comparable<Pair<K, V>> {
    public final K key;
    public final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Pair<K, V> other) {
        int keyComparison = this.key.compareTo(other.key);
        return (keyComparison != 0) ? keyComparison : this.value.compareTo(other.value);
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}