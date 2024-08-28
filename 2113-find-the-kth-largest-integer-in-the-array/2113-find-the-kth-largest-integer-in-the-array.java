class Solution {
     public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue <String> pq = new PriorityQueue<>((a,b)->{
            if(a.length()==b.length()){
                for(int i =0;i<a.length();i++){
                    if(Integer.parseInt(a.charAt(i)+"")!=Integer.parseInt(b.charAt(i)+"")){
                        return Integer.parseInt(a.charAt(i)+"")-Integer.parseInt(b.charAt(i)+"");
                    }
                }
                return a.length()-b.length();
            }else {
                return Integer.compare(a.length(), b.length());
            }
        });
        for(int i =0;i<nums.length;i++){
            String s = nums[i];

            pq.add(s);
            if(pq.size()>k) pq.remove();
        }
        return pq.remove();
    }
}