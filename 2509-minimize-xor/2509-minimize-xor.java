class Solution {
   public int minimizeXor(int num1, int num2) {
        int setbit2 = Integer.bitCount(num2);
        int setbit1 = Integer.bitCount(num1);
        if(setbit1==setbit2) return num1;
        else if(setbit2>setbit1){
            int rem = setbit2- setbit1;
            int i = 0;
            while(rem>0){
                int x = 1<<i;
                if((num1 & x)==0) {
                    num1 = num1|x;   // on the off bit
                    rem--;
                }
                i++;
            }
            return num1;
        }
        else{
            int i =0;
            int rem = setbit1-setbit2;
            while (rem>0){
                int x = 1<<i;
                if((num1 & x)!=0) {  // off the on bit
                    num1 = num1 & (~x);
                    rem--;
                }
                i++;
            }
            return num1;
        }
    }
}