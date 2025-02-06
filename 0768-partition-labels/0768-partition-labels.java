import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        pair[] arr = new pair[26];

       
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (arr[ch - 'a'] != null) {
                arr[ch - 'a'].y = i; 
            } else {
                arr[ch - 'a'] = new pair(i, i);
            }
        }

        List<pair> intervals = new ArrayList<>();
        for (pair p : arr) {
            if (p != null) {
                intervals.add(p);
            }
        }
        intervals.sort(Comparator.comparingInt(p -> p.x));

        
        List<pair> merged = new ArrayList<>();
        int st = intervals.get(0).x;
        int end = intervals.get(0).y;

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).x > end) { 
                merged.add(new pair(st, end));
                st = intervals.get(i).x;
                end = intervals.get(i).y;
            } else { 
                end = Math.max(end, intervals.get(i).y);
            }
        }
        merged.add(new pair(st, end)); 
        for (pair p : merged) {
            ans.add(p.y - p.x + 1);
        }
        return ans;
    }
}

class pair {
    int x, y;

    pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
