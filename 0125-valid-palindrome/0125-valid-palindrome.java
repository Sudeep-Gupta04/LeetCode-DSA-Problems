class Solution {
     public boolean isPalindrome(String s) {
        String[] split = s.split(" ");
        // if(split.length==0){
        //     String[] arr = {s};
        //     split=arr;
        // }
       
        for(int i =0;i<split.length;i++){
            split[i]=split[i].toLowerCase();
            String remch ="";
            for(int j =0;j<split[i].length();j++){
                int ch = split[i].charAt(j)+0;
                 //System.out.println(ch);
                if((ch>=97 && ch<=122) || (ch>=48 && ch<=57)) remch+=(char)ch;
            }
            split[i]=remch;
        }
        System.out.println(Arrays.toString(split));
        StringBuilder sb = new StringBuilder("");
        for(int i =0;i<split.length;i++) sb.append(split[i]);
        String nor = sb.toString();
        return nor.equals(sb.reverse().toString());
    }
}