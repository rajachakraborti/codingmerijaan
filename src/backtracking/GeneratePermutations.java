package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.swap;

public class GeneratePermutations {
    public static void main(String[] args) {
       List<List<Integer>>  l = new GeneratePermutations()
               .generate(Arrays.stream(new int[]{2,2,0,3}).boxed().collect(Collectors.toList()));
        l.stream().forEach(System.out::println);
        System.out.println(l.stream().distinct().count());
    }

    private List<List<Integer>> generate(List<Integer> collect) {
        List<List<Integer>> results = new ArrayList<>();
        generate(0,collect, results);
        return results;
    }

    private void generate(int n, List<Integer> collect,  List<List<Integer>> results) {
        if(n == collect.size()){
            results.add(new ArrayList<>(collect));
            return;
        }

        for(int i = n ; i < collect.size(); i++) {
            Collections.swap(collect, i, n);
            generate(n+1, collect, results);
            Collections.swap(collect, i , n);
        }

    }


}

/*
 1 2 3 4  -> n = 0
 2 1 3 4  -> n = 1
 3 1 2 4  -> n = 2
                        results = 4 1 2 3
 3 2 1 4   -> n = 3

 */
