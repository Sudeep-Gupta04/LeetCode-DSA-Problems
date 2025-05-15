class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int rn = redEdges.length;
        int bn = blueEdges.length;
        ArrayList<ArrayList<Integer>> red = new ArrayList<>();
        ArrayList<ArrayList<Integer>> blue = new ArrayList<>();
        for(int i =0;i< n;i++) red.add(new ArrayList<>());
        for(int i =0;i< n;i++) blue.add(new ArrayList<>());
        for(int i =0;i<rn;i++){
            red.get(redEdges[i][0]).add(redEdges[i][1]);
        }
        for(int i =0;i<bn;i++){
            blue.get(blueEdges[i][0]).add(blueEdges[i][1]);
        }
        boolean[] redvis = new boolean[n];
        boolean[] bluevis = new boolean[n];
        int[] ans = new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        Queue<Integer> redq = new ArrayDeque<>();
        Queue<Integer> blueq = new ArrayDeque<>();
        redq.add(0);
        blueq.add(0);
        bluevis[0] = true; redvis[0] = true;
        int c = 0;
        while(!(redq.isEmpty() && blueq.isEmpty())){
            //if(c==8) break;
           // System.out.println(Arrays.toString(redvis));
           // System.out.println(Arrays.toString(bluevis));
            int sizer = redq.size();
            int sizeb = blueq.size();
          //  System.out.println(redq);
         //   System.out.println(blueq);
            for(int i =0;i<sizer;i++){
                int ele = redq.remove();
                if(ans[ele]>c) ans[ele] = c;
                for(int nod:blue.get(ele)){
                    if(!(bluevis[nod])){
                        bluevis[nod] = true;
                        blueq.add(nod);
                    }
                }
            }
            for(int i =0;i<sizeb;i++){
                int ele = blueq.remove();
                if(ans[ele]>c) ans[ele] = c;
                for(int nod:red.get(ele)){
                    if(!(redvis[nod])){
                        redvis[nod] = true;
                        redq.add(nod);
                    }
                }
            }
            c++;
        }
        for(int i =0;i<n;i++){
            if(ans[i]==Integer.MAX_VALUE) ans[i] = -1;
        }
        return ans;
    }
}