class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]-o2[0]==0){
                    return o2[1]-o1[1];
                }
                return o1[0]-o2[0];
            }
        });
       // for(int[] i:envelopes) System.out.println(Arrays.toString(i));
        int c =1; int minw = envelopes[0][0]; int minh = envelopes[0][1];
        List<Integer> al = new ArrayList<>();
        al.add(envelopes[0][1]);
        for(int i=1;i<n;i++){
            if(envelopes[i][1]>al.getLast()) al.add(envelopes[i][1]);
            else {
                int idx = Collections.binarySearch(al,envelopes[i][1]);
                if(idx<0) idx = -(idx+1);
               // System.out.println(idx);
                al.set(idx,envelopes[i][1]);
            }
        }
        //System.out.println(al);
        return al.size();
    }
}