class Solution {
     public int flipgame(int[] fronts, int[] backs) {
        TreeSet<Integer> hs = new TreeSet<>();
        HashSet<Integer> not = new HashSet<>();
        for(int i =0;i<fronts.length;i++){
            if(fronts[i]==backs[i]) not.add(fronts[i]);
        }
        for(int i =0;i<fronts.length;i++){
            if(fronts[i]!=backs[i]) {
                if(!not.contains(fronts[i])) hs.add(fronts[i]);
                if(!not.contains(backs[i]))hs.add(backs[i]);
            }
        }
        if(hs.size()==0) return 0;
        return hs.getFirst();
    }
}