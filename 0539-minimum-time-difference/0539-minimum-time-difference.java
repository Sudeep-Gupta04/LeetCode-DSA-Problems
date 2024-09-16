class Solution {
  public static int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
               if(o1.substring(0,2).equals(o2.substring(0,2))){
                   return o1.substring(3).compareTo(o2.substring(3));
               }else return o1.substring(0,2).compareTo(o2.substring(0,2));
            }
        });
        timePoints.add(timePoints.get(0));
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < timePoints.size() - 1; i++){
            String one = timePoints.get(i);
            String two = timePoints.get(i + 1);
            int one_min = Integer.parseInt(one.substring(0,2)) * 60 + Integer.parseInt(one.substring(3));
            int two_min = Integer.parseInt(two.substring(0,2)) * 60 + Integer.parseInt(two.substring(3));
            int p1 = two_min - one_min;
            if (p1 < 0) p1 += 1440;
            ans = Math.min(ans, p1);
        }

        String end = timePoints.get(timePoints.size() - 2);
        int last_ans = 1440 - (Integer.parseInt(end.substring(0,2)) * 60 + Integer.parseInt(end.substring(3)));
        String one = timePoints.get(0);
        int one_min = Integer.parseInt(one.substring(0,2)) * 60 + Integer.parseInt(one.substring(3));
        return Math.min(ans, last_ans + one_min);
    }
}
