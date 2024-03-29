package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AllSubSetsofK {
    public static void main(String[] args) {
        List<List<Integer>> l  = new AllSubSetsofK().compute(5);
        l.stream().forEach(System.out::println);

    }

    private List<List<Integer>> compute(int n) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> range = IntStream.range(1, n+1).boxed().collect(Collectors.toList());
        compute(n,  new ArrayList<Integer>(), range, results);
        return results;
    }

    private void compute(int n,  List<Integer> prefixList,
                         List<Integer> originalList, List<List<Integer>> results) {
        results.add(new ArrayList(prefixList));

        for(int i = 0; i < originalList.size(); i++) {
            prefixList.add(originalList.get(i));
            compute(n , prefixList, originalList.subList(i+1, originalList.size()), results);
            prefixList.remove(prefixList.size() - 1);
        }
    }


}
