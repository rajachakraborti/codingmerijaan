package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new IncreasingSubsequence().compute(new int[] {10, 22, 9, 33, 21, 50, 41, 60})));
        //System.out.println(new IncreasingSubsequence().compute(new int[] {0,8,4,12,2,10,6,14,1,9}));
    }

    private int[] compute(int [] x) {
        int [] maxLengthArr = new int[x.length];
        List<List<Integer>> results = new ArrayList<>();
        Arrays.fill(maxLengthArr, 1);

        for(int i = 0; i < x.length; i++) {
            results.add(new ArrayList<Integer>());
            for (int j = 0; j < i; j++) {
                if(x[i] > x[j]){
                    maxLengthArr[i] = Math.max(maxLengthArr[i], maxLengthArr[j]+1);
                }
            }
        }

        List<Integer> integerList = IntStream.of(maxLengthArr).boxed().collect(Collectors.toList());
        System.out.println(Collections.max(integerList));
        int index = new ArrayList<>(integerList).indexOf(Collections.max(integerList));
        return results.get(index).stream().mapToInt(i -> i).toArray();
    }
}


/**

 0 8 4 12 2 10 6 14 1 9
 1 1 1 1  1 1  1  1 1 1
 1 2 2 3  2 3  2  4 2 2
 **/