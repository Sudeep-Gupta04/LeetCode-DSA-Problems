class Solution {
    public boolean gcdSort(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> mp = new HashMap<>();
        DSU dsu = new DSU(nums.length);
        for(int i =0;i<n;i++){
            List<Integer> l = factors(nums[i]);
            //System.out.println(l+" "+nums[i]);
            for(int j:l){
                if(mp.containsKey(j)){
                    int idx = mp.get(j);
                    dsu.union(idx,i);
                }else{
                    mp.put(j,i);
                }
            }
            //System.out.println(mp);
        }
        int[] arr = dsu.par;
        for(int i =0;i<n;i++){
            arr[i] = dsu.ultparent(i);
        }
        //System.out.println(Arrays.toString(arr));
        HashMap<Integer,PriorityQueue> range = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!range.containsKey(arr[i])) {
                range.put(arr[i], new PriorityQueue<>());
            }
            range.get(arr[i]).add(nums[i]);
        }

        int[] ans = new int[nums.length];
        for(int i =0;i< ans.length;i++){
            int par = arr[i];
            ans[i] = (int) range.get(par).remove();
            if(i!=0){
                if((ans[i] - ans[i-1]) < 0) return false;
            }
        }
        return true;
    }
    public List<Integer> factors(int num){
        List<Integer> ans = new ArrayList<>();
        for(int i =2;i*i<=num;i++){
            if(num % i==0){
                if(i*i==num) ans.add(i);
                else{
                    ans.add(i);
                    ans.add(num/i);
                }
            }
        }
        ans.add(num);
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