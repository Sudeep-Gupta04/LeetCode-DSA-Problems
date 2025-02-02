class Solution {
    public int videoStitching(int[][] clips, int time) {
        ArrayList<Pair> al = new ArrayList<>();
        int[] p = new int[2];
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < clips.length; i++) {
            if (clips[i][0] == 0) p[0] = 1;
            if (clips[i][1] >= time) p[1] = 1;
            for (int j = clips[i][0]; j <= clips[i][1]; j++) hs.add(j);
            al.add(new Pair(clips[i][0], clips[i][1]));
        }
        if(hs.size()<time+1) return -1;
        if (!(p[0] == 1 && p[1] == 1)) return -1;
        Collections.sort(al, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare((int)o1.key,(int) o2.key);
            }
        });

        int ans = 0;
        int end = 0, farthest = 0, i = 0;

        while (end < time) {
            while (i < al.size() && al.get(i).key <= end) {
                farthest = Math.max(farthest, al.get(i).value);
                i++;
            }
            if (end == farthest) return -1; // No progress made
            
            end = farthest;
            ans++;
        }

        return ans;
    }
}
class Pair {
    int key, value;
    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}