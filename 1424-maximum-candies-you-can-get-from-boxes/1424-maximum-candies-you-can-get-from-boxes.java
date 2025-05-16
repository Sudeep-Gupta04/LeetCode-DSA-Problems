class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Queue<Integer> q = new ArrayDeque<>();
        HashSet<Integer> hs = new HashSet<>();
        for(int i:initialBoxes){
            q.add(i);
        }
        int c =0;
        int times = 1000000;
        while(!q.isEmpty()){
                //if(times<=0) break;
            int box = q.remove();
            if(status[box]==1){
            c += candies[box];
            candies[box] = 0;
                    // got new keys so for that keys open new boxes and add it to queue
            for(int i:keys[box]){
                if(status[i]==0){
                    status[i] = 1;
                    if(hs.contains(i)){
                        hs.remove(i);
                        q.add(i);
                    }
                }
            }
                    // got new boxes add to the queue
            for(int i:containedBoxes[box]){
                q.add(i);
            }
            }else{
                hs.add(box);
            }
               // times--;
        }
    return c;
    }
}