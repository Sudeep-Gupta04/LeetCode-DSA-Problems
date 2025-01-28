class Solution {
    public String baseNeg2(int n) {
        String ans = "";
        int t = 0, sum = 0;

        if(n==0)
            return "0";
            
        while (n != 0) 
        {
            int rem = n % (-2);
            n = n / (-2);
            System.out.println(rem+ " "+ n);
            if (rem < 0) 
            {
                n = n + 1;
                rem = rem + 2;
            }

            ans = (rem + "") + ans;

        }

        return ans;
    }
}