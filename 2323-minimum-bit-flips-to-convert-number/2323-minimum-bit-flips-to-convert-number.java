class Solution {
    public int minBitFlips(int start, int goal) {
        int x = start^goal;
        int q = Integer.toBinaryString(x).length();
        int i = 0;
        int c = 0;
        for(int j =0;j<q;j++){
            if((1 << i & x) == 1 << i)c++;
            i++;
        }
        return c;
    }
}
// for (int j = 0; j < q; j++) {
//             // Check if the bit at position 'i' is set
//             if ((1 << i & x) != 0) {
//                 c++; // Increment count if bit is 1
//             }
//             i++; // Move to the next bit
//         }