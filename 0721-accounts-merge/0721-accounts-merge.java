class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n); // no need for n+1, size is n
        int[] arr = dsu.par;

        HashMap<String, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {

            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (!mp.containsKey(email)) {
                    mp.put(email, i);
                } else {
                    int idx = mp.get(email);
                    dsu.union(i, idx);
                }
            }
        }
        HashMap<Integer, List<String>> acc = new HashMap<>();
        HashMap<Integer, String> names = new HashMap<>(); 
        HashSet<String>[] emailGroups = new HashSet[n]; 
        for (int i = 0; i < n; i++) {
            int parent = dsu.ultparent(i);

            names.putIfAbsent(parent, accounts.get(i).get(0));

            if (emailGroups[parent] == null) {
                emailGroups[parent] = new HashSet<>();
            }

            for (int j = 1; j < accounts.get(i).size(); j++) {
                emailGroups[parent].add(accounts.get(i).get(j));
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (emailGroups[i] != null) {
                List<String> merged = new ArrayList<>();
                merged.add(names.get(i)); 
                List<String> sortedEmails = new ArrayList<>(emailGroups[i]);
                Collections.sort(sortedEmails);
                merged.addAll(sortedEmails);
                ans.add(merged);
            }
        }

        return ans;
    }
}


class DSU {
    int[] rank;
    int[] size;
    int[] par;

    DSU(int n) {
        rank = new int[n];
        size = new int[n];
        par = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = 1;
            par[i] = i;
        }
    }

    public int ultparent(int node) {
        if (node == par[node]) return node;
        return par[node] = ultparent(par[node]);
    }

    public void union(int node1, int node2) {
        int ultparent1 = ultparent(node1);
        int ultparent2 = ultparent(node2);
        if (ultparent1 != ultparent2) {
            if (rank[ultparent1] > rank[ultparent2]) {
                size[ultparent1] += size[ultparent2];
                par[ultparent2] = ultparent1;
            } else if (rank[ultparent1] < rank[ultparent2]) {
                size[ultparent2] += size[ultparent1];
                par[ultparent1] = ultparent2;
            } else {
                rank[ultparent1]++;
                size[ultparent1] += size[ultparent2];
                par[ultparent2] = ultparent1;
            }
        }
    }
}