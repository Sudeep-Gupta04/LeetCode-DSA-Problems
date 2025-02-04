import java.util.*;

class TimeMap {
    HashMap<String, ArrayList<Integer>> mpkey;
    HashMap<Integer, String> mpvalue;
    ArrayList<Integer> al;
    int i; // Remove static, make instance-based

    public TimeMap() {
        mpkey = new HashMap<>();
        mpvalue = new HashMap<>();
        al = new ArrayList<>();
        i = 0; // Initialize instance variable
    }

    public void set(String key, String value, int timestamp) {
        if (!mpkey.containsKey(key)) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(i);
            mpkey.put(key, temp);
        } else {
            mpkey.get(key).add(i);
        }

        mpvalue.put(i, value);
        al.add(timestamp);
        i++;
    }

    public String get(String key, int timestamp) {
        if (!mpkey.containsKey(key)) return "";

        ArrayList<Integer> index = mpkey.get(key);
        int s = 0, e = index.size() - 1;
        int ansIdx = -1;

        while (s <= e) {
            int mid = (s + e) / 2;
            int alidx = index.get(mid);
            if (al.get(alidx) <= timestamp) { 
                ansIdx = alidx;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return ansIdx == -1 ? "" : mpvalue.get(ansIdx);
    }
}
