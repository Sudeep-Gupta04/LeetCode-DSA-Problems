class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        int k= groupSize;
        if(n%k!=0) return false;
        else{
            Arrays.sort(hand);
             HashMap<Integer,Integer> tm= new HashMap<>();
        for(int i =0;i<hand.length;i++){
            tm.put(hand[i],tm.getOrDefault(hand[i],0)+1);
        }
        for(int i =0;i<hand.length;i++){
            int num = hand[i];
            if(tm.containsKey(num)){
                for(int j =0;j<k;j++){
                    if(!tm.containsKey(num)) return false;
                    else{
                        if(tm.get(num)>1) tm.put(num,tm.get(num)-1);
                        else tm.remove(num);
                    }
                    num++;
                }
            }
        }
        if(!tm.isEmpty()) return false;
        return true;
            
        }
    }
}