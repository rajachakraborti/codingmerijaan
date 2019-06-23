package dynamicprogramming;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaxSumContiguousSubarray {
    public static void main(String[] args) {
        System.out.println(new MaxSumContiguousSubarray().compute(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    private int compute(int[] ints) {
        Map<Integer, Pair> m= new HashMap<>();
        int [] v = new int[ints.length];
        v[0] = ints[0];
        m.put(v[0], new Pair(0, 0));

        for(int i = 1; i <ints.length; i++) {
         v[i] = Math.max(v[i-1]+ ints[i], ints[i]);
         m.put(v[i], new Pair(m.getOrDefault(i-1,  new Pair(0, 0)).getKey(), i));
        }
        m.entrySet().forEach(x -> System.out.println(x.getKey() +" :: "+ x.getValue()));
        return Collections.max( IntStream.of(v).boxed().collect(Collectors.toList()));
    }

}
