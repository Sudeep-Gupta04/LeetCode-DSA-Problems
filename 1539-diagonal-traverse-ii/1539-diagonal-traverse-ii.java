class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        TreeMap<Integer,List> mp = new TreeMap<>();
        int size =0;
        for(int i =0;i<nums.size();i++){
            for(int j =0;j<nums.get(i).size();j++){
                if(!mp.containsKey(i+j)){
                    ArrayList<Object> objects = new ArrayList<>();
                    objects.add(nums.get(i).get(j));
                    mp.put(i+j,objects);
                }else{
                    List temp = mp.get(i+j);
                    temp.add(nums.get(i).get(j));
                    mp.put(i+j,temp);
                }
                size++;
            }
        }
        int[] arr = new int[size];
        int k =0;
        for(Map.Entry entry: mp.entrySet()){
            List tem = (List) entry.getValue();
            for(int i=tem.size()-1;i>=0;i--){
                arr[k++]= (int) tem.get(i);
            }
        }
        return arr;
    }
}