import java.util.*;

public class Lc759_EmployeeFreeTime_H {
    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
  }
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
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
    }

    public static void main(String[] args) {

    }
}
