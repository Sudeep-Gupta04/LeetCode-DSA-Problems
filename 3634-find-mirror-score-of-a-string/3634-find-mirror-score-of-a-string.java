
class Solution {
    public long calculateScore(String s) {
        HashMap<Character, ArrayList<Integer>> hm = new HashMap<>();
        long score = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char real = s.charAt(i);
            int ch = s.charAt(i);
            char rev;
            if(ch<=109) rev = (char)(122-(ch-97));
			else rev = (char)(97+(122-ch));

            if (!hm.containsKey(rev)) {
                if (!hm.containsKey(real)) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    hm.put(real, temp);
                } else {
                    ArrayList<Integer> t2 = hm.get(real);
                    t2.add(i);
                    hm.put(real, t2);
                }
            } else {
                ArrayList<Integer> t2 = hm.get(rev);
				if(t2.size()>1) {
					score +=   (i - (t2.get(t2.size()-1)));
					t2.remove(t2.size()-1);
					hm.put(rev,t2);
				}else{
					score += (i - (t2.get(t2.size()-1)));
					t2.remove(t2.size()-1);
					hm.remove(rev);
				}
            }
        }
        return score;
    }
}
