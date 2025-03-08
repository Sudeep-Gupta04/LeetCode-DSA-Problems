class Solution {
     public int numTilePossibilities(String tiles) {
        List<String> al = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();
        //return permutaion(tiles,0) - 1;
        permutaion(tiles,0,"",al);
        System.out.println(al);
        for(int i =0;i<al.size();i++){
            boolean[] arr = new boolean[al.get(i).length()];
            List<Character> temp = new ArrayList<>();
            compute(hs,al.get(i),arr,temp,0);
        }
        return hs.size();
    }
    public void compute(HashSet<String> hs, String st,boolean[] arr, List<Character> temp,int k){
        if(temp.size()==st.length()){
            String result = temp.stream()
                    .map(String::valueOf) // Convert Character to String
                    .collect(Collectors.joining());
            hs.add(result);
            return;
        }

        for(int i =0;i<st.length();i++){
            if(!arr[i]){
                arr[i] = true;
                temp.add(st.charAt(i));
                compute(hs,st,arr,temp,0);
                temp.remove(temp.size()-1);
                arr[i] = false;
            }
        }
        return;
    }

    public void permutaion(String st,int i,String com, List<String> al){
        if(i>=st.length()){
            if(com!="") al.add(com);
            return;
        }
        permutaion(st,i+1,com+st.charAt(i),al);
        permutaion(st,i+1,com,al);
        return;
    }
}