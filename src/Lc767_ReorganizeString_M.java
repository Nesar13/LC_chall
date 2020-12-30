import java.util.*;

public class Lc767_ReorganizeString_M {

    // create freq table with hashmap and order it in a max heap using an int array
    // as a generic
    // using stringbuilder to append to it from highest freq to lowest
    public static String reorganizeString(String S) {
        // Create map of each char to its count
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            // Impossible to form a solution
            if (count > (S.length() + 1) / 2) return "";
            map.put(c, count);
        }
        // Greedy: fetch char of max count as next char in the result.
        // Use PriorityQueue to store pairs of (char, count) and sort by count DESC.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (char c : map.keySet()) {
            pq.add(new int[] {c, map.get(c)});
        }
        // Build the result.
        // note that we add the array back to the pq if the freq is greater than 0
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            System.out.println(Arrays.toString(first));
            // the last statement is a check to see if the character is already appended at the
            // the end
            if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char) first[0]);
                if (--first[1] > 0) {
                    pq.add(first);
                }
            } else {
                int[] second = pq.poll();
                sb.append((char) second[0]);
                if (--second[1] > 0) {
                    pq.add(second);
                }
                pq.add(first);
            }
        }
        return sb.toString();
    }
    public String reorganizeString2(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) > (S.length() + 1) / 2) return "";
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for(char c : map.keySet()) pq.offer(c);

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            char cur = pq.poll();
            if(sb.length() == 0 || cur != sb.charAt(sb.length() - 1)) {
                sb.append(cur);
                int f1 = map.get(cur);
                if(--f1 > 0) {
                    pq.offer(cur);
                    map.put(cur, f1);
                }
            }else {
                char cur2 = pq.poll();
                sb.append(cur2);
                int f2 = map.get(cur2);
                if(--f2 > 0) {
                    pq.offer(cur2);
                    map.put(cur2, f2);
                }
                pq.offer(cur);
            }
        }
        return sb.toString();
    }
    // This uses arrays to keep track of frequency
    // it increments by 100 for each of the same char
    // Using Arrays.sort to sort the array - the most freq element will be at the end
    // parse the array and use a hopper skip indexes to place the char in a new array so they
    // are not adjacent
    // 88%
    public static String reorganizeString3(String S) {
        int N = S.length();
        int[] arr = new int[26];
        for (char c: S.toCharArray()) arr[c-'a'] += 100;
        for (int i = 0; i < 26; ++i) arr[i] += i;
        //Encoded arr[i] = 100*(actual count) + (i)
        Arrays.sort(arr);

        char[] ans = new char[N];
        int hop = 1;
        for (int value: arr) {
            int freq = value / 100;
            char ch = (char) ('a' + (value % 100));
            if (freq > (N+1) / 2) return "";
            for (int i = 0; i < freq; ++i) {
                if (hop >= N) hop = 0;
                ans[hop] = ch;
                hop += 2;
            }
        }
// String.valueOf puts the char array into a single string
        return String.valueOf(ans);
    }


    public static void main(String[] args) {

       /* char[] arr= new char[3];
        arr[0]='c';
        arr[1]='b';

        arr[2]='d';
//String.valuof() converts char array to one string
        System.out.println(String.valueOf(arr));*/


//        Input:
//        "vvvlo"
//        Output:
//        "volvv"
//        Expected:
//        "vlvov"
String s="aab";
String s2="vvvlo";
StringBuilder sb=new StringBuilder();


        System.out.println(reorganizeString(s2));
    }
}
