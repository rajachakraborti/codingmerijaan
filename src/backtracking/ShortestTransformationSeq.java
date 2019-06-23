package backtracking;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShortestTransformationSeq {
    public static void main(String[] args) {
        String start = "hit", target = "cog";
        Set<String> dict = Stream.of("hot", "dot", "dog", "lot", "log").collect(Collectors.toSet());
        int l = new ShortestTransformationSeq().compute(start, target, dict, 0);
        System.out.println(l);
    }

    private int compute(String start, String target, Set<String> dict, int len) {
        if (start == null || target == null || dict == null || dict.size() < 1) return 0;
        else {
            Queue<String> q = new LinkedList<>();
            q.add(start);
            dict.remove(start);

            while (!q.isEmpty()) {
                int count = q.size();

                for (int i = 0; i < count; i++) {
                    String c = q.poll();

                    for (int j = 0; j < c.length(); j++) {
                        for (char x = 'a'; x <= 'z'; x++) {
                            if (x == c.charAt(j)) continue;

                            char[] t = c.toCharArray();
                            t[j] = x;
                            if(Arrays.equals(t, target.toCharArray())) return len++;
                            String t1 = new String(t);
                            if(dict.contains(t1)) {
                                q.add(t1);
                                dict.remove(t1);
                            }


                        }
                    }

                }
                len++;
            }

            return 0;
        }
    }


}
