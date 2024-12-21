class Solution {
    public int maxChunksToSorted(int[] arr) {
       int i = arr.length-1;
       int bki = arr.length-1;
       int c =0;
       
        while(i>=0){
          boolean check =false;
          while(i>=bki){
            if(arr[i]<bki){
                check = true;
                bki = arr[i];
                i--;
                break;
            }
            if(i==bki) {
                i--;
                bki--;
                break;
            }
            i--;
          }  
          if(check==false){
            c++;
          }
        }
        return c;
    }
}