import java.util.Comparator;
import java.util.PriorityQueue;

public class Lc295_FindMedianFromDataStream_H {


    // this is an algoexpert question (h.17 continuous median)
// since we know that insertion  in heaps is log n and we can kind of have it ordered,
// we can use two heaps, a minheap and a maxheap to contain two sides of data.
// the maxheap will have the left lower side and min heap will be the greater right side
// if the heaps differ in size by 2 we have to rebalance it by removing the greater sized heap
// O(log n) time | O(n) space



    PriorityQueue<Integer> smaller;
    PriorityQueue<Integer> larger;

    /** initialize your data structure here. had to make it void */
    public void MedianFinder()
    {
        // max Heap
        smaller = new PriorityQueue<>(Comparator.reverseOrder());

        // min heap
        larger = new PriorityQueue<>();
    }

    public void addNum(int num)
    {
        if (larger.isEmpty() || num > larger.peek())
            larger.add(num);
        else
            smaller.add(num);

// we must rebalance if our size difference is greater than two
        if (smaller.size() > larger.size() + 1)
        {
            larger.add(smaller.poll());
        }
        else if (larger.size() > smaller.size() + 1)
        {


            smaller.add(larger.poll());

        }
    }

    public double findMedian()
    {
        if ((smaller.size() + larger.size()) % 2 == 0)
        {
            double sum = smaller.peek() + larger.peek();
            double m =  sum / 2.0;
            return m;
        }
        else if (smaller.size() < larger.size())
            return larger.peek();
        else
            return smaller.peek();
    }

}
