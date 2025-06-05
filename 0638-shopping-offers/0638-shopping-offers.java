class Solution {
    static HashMap<String,Integer> dp;
    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        dp = new HashMap<>();
        int n = price.size();
        String str = "";
        for(int i =0;i<needs.size();i++){
            str += (char)(needs.get(i)+97);
        }
        return helper(0,str,special,price,needs,n);
    }

    private static int helper(int i, String str, List<List<Integer>> offer, List<Integer> price, List<Integer> needs, int n) {
        if(i>=offer.size()){
            int cost = 0;
            for(int j =0;j<str.length();j++){
                int num = str.charAt(j) - 97;
                cost += (num*price.get(j));
            }
            return cost;
        }
        String key = i+","+str;
        if(dp.containsKey(key)) return dp.get(key);
        int ntake = helper(i+1,str,offer,price,needs,n);
        int take = Integer.MAX_VALUE;
        boolean t = true;
        String newStrig = "";
        for(int j =0;j<n;j++){
            int left= str.charAt(j)-97;
            int takoffer = offer.get(i).get(j);
            if(left>=takoffer){
                char newch = (char) (left-takoffer+97);
                newStrig += (newch+"");
            }else{
                t = false;
                break;
            }
        }
        if(t) take = offer.get(i).get(n) + helper(i,newStrig,offer,price,needs,n);
        int ans = Math.min(take,ntake);
        dp.put(key,ans);
        return ans;
    }
}
