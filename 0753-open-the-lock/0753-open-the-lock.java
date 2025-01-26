class Solution {
     public int openLock(String[] deadends, String target) {
        HashSet<String> taken = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();
        for(int i =0;i<deadends.length;i++){
            taken.add(deadends[i]);
        }
        if(taken.contains(target) || taken.contains("0000")) return -1;
        q.add("0000");
        taken.add("0000");
        int lv = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.remove();
                if (s.equals(target)) return lv;

                for (int j = 0; j < 4; j++) {
                    int num = Integer.parseInt(s.charAt(j)+"");
                    num = (num+1)%10;
                    String news = s.substring(0,j)+num+s.substring(j+1);
                    if(!taken.contains(news)){
                        q.add(news);
                        taken.add(news);
                    }
                    num = Integer.parseInt(s.charAt(j)+"");
                    if(num==0) num = 9;
                    else  num = num - 1;
                    news= s.substring(0,j)+num+s.substring(j+1);
                    if(!taken.contains(news)){
                        taken.add(news);
                        q.add(news);
                    }
                }
            }
            lv++;
        }
        return -1;
    }
}