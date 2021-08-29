import java.util.*;

public class Lc759_EmployeeFreeTime_H {
    public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }


        @Override
        public String toString() {
            return
                     start +
                    ", " + end ;

        }
    }
// we sort the list by start time by adding to our priority queue
    // and then we iterate through our queue to check for any free time (meaning there's no overlap)
    // we have a running maxCurrEndTIme to keep track of the previous end time
    // if the current start time is greater than our max and it's not the first list
    // we can add it to our result
    // we update the currMaxEndTime by taking the max of (max, end)
    // O(nlogn) time for sorting and adding to our queue | O(n) space
    public static List < Interval > employeeFreeTime(List<List<Interval >> schedule) {
        PriorityQueue < Interval > que = new PriorityQueue < > (Comparator.comparingInt(a -> a.start));

        for (List < Interval > list: schedule) {
            for (Interval i: list) {
                que.add(i);
            }
        }

        List < Interval > res = new ArrayList < > ();
        int currMaxEndTime = -1;
        while (!que.isEmpty()) {
            Interval top = que.poll();
            if (currMaxEndTime != -1 && top.start > currMaxEndTime) {
                res.add(new Interval(currMaxEndTime, top.start));
            }
            currMaxEndTime = Math.max(currMaxEndTime, top.end);
        }

        return res;
    }
/*    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();

        if (schedule == null || schedule.size() == 0) {
            return res;
        }

        List<Interval> list = new ArrayList<>();

        for (List<Interval> time : schedule) {
            for (Interval interval : time) {
                list.add(interval);
            }
        }

        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start == i2.start ? i1.end - i2.end : i1.start - i2.start;
            }
        });

        PriorityQueue<Integer> endTime = new PriorityQueue<>(Collections.reverseOrder());
        endTime.add(list.get(0).end);

        for (int i = 1; i < list.size(); i++) {
            if (endTime.size() > 0 && endTime.peek() < list.get(i).start) {
                res.add(new Interval(endTime.peek(), list.get(i).start));
            }
            endTime.add(list.get(i).end);
        }
        return res;
    }*/

    public static void main(String[] args) {
//[[[1,2],[5,6]],[[1,3]],[[4,10]]]
        Interval one=new Interval(1,2) ;
        Interval two=new Interval(5,6) ;

        List<Interval> l=new ArrayList<>();
        l.add(one);
        l.add(two);

        List<Interval> l2= new ArrayList<>();
        l2.add(new Interval(1,3));

        List<Interval> l3= new ArrayList<>();
        l3.add(new Interval(4,10));


        List<List<Interval>> main=new ArrayList<>();
        main.add(l);
        main.add(l2);
        main.add(l3);


        System.out.println(employeeFreeTime(main));


    }
}
