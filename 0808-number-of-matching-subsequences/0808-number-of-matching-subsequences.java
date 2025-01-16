class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, List<Integer>> m = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            m.computeIfAbsent(s.charAt(i), k -> new ArrayList<>()).add(i);
        }

        int count = 0;

        for (String w : words) {
            int lastIdx = -1;
            boolean isSubseq = true;

            for (char c : w.toCharArray()) {
                if (!m.containsKey(c)) {
                    isSubseq = false;
                    break;
                }

                List<Integer> idxList = m.get(c);
                int pos = binarySearch(idxList, lastIdx);
                
                if (pos == idxList.size()) {
                    isSubseq = false;
                    break;
                }
                
                lastIdx = idxList.get(pos);
            }

            if (isSubseq) {
                count++;
            }
        }

        return count;
    }

    private int binarySearch(List<Integer> idxList, int lastIdx) {
        int low = 0, high = idxList.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (idxList.get(mid) <= lastIdx) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
