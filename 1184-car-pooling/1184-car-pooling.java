class Solution {
   public boolean carPooling(int[][] trips, int capacity) {
		TreeMap<Integer,Integer> tm = new TreeMap<>();
		for(int i =0;i<trips.length;i++){
			if(!tm.containsKey(trips[i][1])) tm.put(trips[i][1],trips[i][0]);
			else{
				tm.put(trips[i][1],tm.get(trips[i][1])+trips[i][0]);
			}
			if(!tm.containsKey(trips[i][2])) tm.put(trips[i][2],-1 * trips[i][0]);
			else {
				tm.put(trips[i][2],tm.get(trips[i][2])-(trips[i][0]));
			}
			
		}
//		[2,1,5],[3,3,7]
//		1 - 5  3 - 3  5 - -2  7 - -3
		int s =0;
		for(Map.Entry<Integer,Integer> i: tm.entrySet()){
			s+=i.getValue();
			if(s>capacity) return false;
		}
		return true;
	}
}