class Solution {
    // 1) I intially thought we can brute force it using a greedy approach 
    // where we can separate it into subsequences
    // but this would not work as there can be numbers that we miss 
    // 2) We cann use two hashmaps, one for storing frequency
    // and one to store the number of subsequences (e.g if we have a subsequence of 123, then we can put
    // (3,1) in our map as that indicates 4 can continue that subsequence) 
   //// [1,2,3,3,4,4,5,5]
     // map: 1 2 3 4 5
     //      1 1 2 2 2 

// subsequence: (key: num, value: number of subsequence that end with that num)
// 3,1...1 2 3 (the fourth is the number after, 
// so four can continue the subsequence, but in this case, another subsequence is started with 3)
// 5,1 ... (3,4,5) is another subsequence and so we put (5,1)

      public boolean isPossible(int[] nums) {
        Map<Integer, Integer> subsequences = new HashMap<>();
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
           
            //num already part of a valid subsequence.
            if (frequency.get(num) == 0) {
                continue;
            }
            // If a valid subsequence exists with the last element = num - 1.
            if (subsequences.getOrDefault(num - 1, 0) > 0) {
                subsequences.put(num - 1, subsequences.getOrDefault(num - 1, 0) - 1);
                subsequences.put(num, subsequences.getOrDefault(num, 0) + 1);
            } else if (frequency.getOrDefault(num + 1, 0) > 0 && 
                       frequency.getOrDefault(num + 2, 0) > 0) {
                // If we want to start a new subsequence, check if num + 1 and num + 2 exist.
                // Update the list of subsequences with the newly created subsequence
                subsequences.put(num + 2, subsequences.getOrDefault(num + 2, 0) + 1);
                frequency.put(num + 1, frequency.getOrDefault(num + 1, 0) - 1);
                frequency.put(num + 2, frequency.getOrDefault(num + 2, 0) - 1);
            } else {
                //No valid subsequence is possible with num
                return false;
            }
            frequency.put(num, frequency.get(num) - 1);
        }
        return true;
    }

}

