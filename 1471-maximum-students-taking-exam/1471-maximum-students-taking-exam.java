class Solution {
    public int maxStudents(char[][] seats){
        char[][] seating = seats;
        int m = seating.length;
        int n = seating[0].length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        permutation(0, hm, seating[0], 0, n, 0, 0);

        for(int i = 1; i < m; i++){
            HashMap<Integer,Integer> newhm = new HashMap<>();
            for(Map.Entry<Integer,Integer> j : hm.entrySet()){
                permutation(0, newhm, seating[i], 0, n, j.getKey(), j.getValue());
            }
            hm = newhm;
        }

        int ans = 0;
        for(Map.Entry<Integer,Integer> j : hm.entrySet()){
            ans = Math.max(ans, j.getValue());
        }
        return ans;
    }

    private void permutation(int i, HashMap<Integer, Integer> hm, char[] seating, int mask, int n, int prvk, int prvv) {
        if(i >= n){
            int total = Integer.bitCount(mask) + prvv;
            hm.put(mask, Math.max(hm.getOrDefault(mask, 0), total));
            return;
        }

        if(seating[i] == '#'){
            permutation(i + 1, hm, seating, mask, n, prvk, prvv);
            return;
        }

        permutation(i + 1, hm, seating, mask, n, prvk, prvv);

        boolean upleft = (i == 0 || (prvk & (1 << (i - 1))) == 0);
        boolean upright = (i ==n-1||(prvk &(1<<(i+1))) == 0);

        if((mask & (1 << i)) == 0 && upleft && upright){
            permutation(i + 2, hm, seating, mask | (1 << i), n, prvk, prvv);
        }
    }
}
