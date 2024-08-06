  class MedianFinder {
        private int count;
        private PriorityQueue<Integer> max;
        private PriorityQueue<Integer> min;
        public MedianFinder() {
            count = 0;
            min = new PriorityQueue<>();
            max = new PriorityQueue<>(Comparator.reverseOrder());
        }


        public void addNum(int num) {
            count++;
           if(min.isEmpty() && max.isEmpty()){
               max.add(num);
               return;
           } else if (count%2!=0) {
                   if(max.peek() <= num && num <= min.peek()) max.add(num);
                   else if(num <= max.peek()) max.add(num);
                   else{
                       max.add(min.remove());
                       min.add(num);
                   }
           }
           else {
               if(min.isEmpty()){
                   if(num>max.peek()) min.add(num);
                   else {
                       max.add(num);
                       Balanceout(max,min);
                       return;
                   }
               }else {
                    if (num <= max.peek() && num <= min.peek()) max.add(num);
                   else if(num>min.peek()) min.add(num);
                   else max.add(num);
                   Balanceout(max, min);


               }
           }
        }

        private void Balanceout(PriorityQueue<Integer> max, PriorityQueue<Integer> min) {
            if(max.size()==min.size()) return;
            else if(max.size()>min.size()){
                min.add(max.remove());
            }else {
                max.add(min.remove());
            }
        }

        public double findMedian() {

            if(count==1) return max.peek();
            else if(count%2==0){
                return (double) (min.peek()+max.peek())/2.0;
            }
            else {
                return max.peek();
            }
        }

    }