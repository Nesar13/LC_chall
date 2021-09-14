import java.util.*;

public class Lc269_AlienDictionary_H {
    // note that we are given an ordered list of strings where for example
    // wrt comes before wrf
    // first we want to build the relationships by building a graph
    // using a hashmap<char, hashset> where character will lexiographically
    // come before the value(s) in the hashset
    //we also keep track of the number of indegrees (which for a char with 0 means
    // it will come first)
    // we use it in our topological sort by using a stringbuilder
    // and a queue. we append to the queue chars from our hashmap key
    // with an indegree of 0 and add it to our stringbuilder solution
    // We traverse the values from the key and decrement it and if it's 0
    // we add to queue
    //
    public static String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        int[] inDegree = new int[26];
        buildGraph(words, graph, inDegree);

        String order = topologicalSort(graph, inDegree);
        return order.length() == graph.size() ? order : "";
    }

    private static void buildGraph(String[] words, Map<Character, Set<Character>> graph, int[] inDegree) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.put(c, new HashSet<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            String first = words[i - 1];
            String second = words[i];
            int length = Math.min(first.length(), second.length());

            for (int j = 0; j < length; j++) {
                char parent = first.charAt(j);
                char child = second.charAt(j);
                if (parent != child) {
                    if (!graph.get(parent).contains(child)) {
                        graph.get(parent).add(child);
                        inDegree[child - 'a']++;
                    }
                    // note that we break because there is no point in continuing
                    // if the letters are not the same
                    // so we can compare the next words
                    break;
                }
            }
        }
    }

    private static String topologicalSort(Map<Character, Set<Character>> graph, int[] inDegree) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : graph.keySet()) {
            if (inDegree[c - 'a'] == 0) {
                queue.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (char neighbor : graph.get(c)) {
                inDegree[neighbor - 'a']--;
                if (inDegree[neighbor - 'a'] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //[
        //  "wrt",
        //  "wrf",
        //  "er",
        //  "ett",
        //  "rftt"
        //]
        // answer: "wertf"
        String[] s= {"wrt", "wrf", "er", "ett", "rftt"};

        System.out.println(alienOrder(s));
    }

}
