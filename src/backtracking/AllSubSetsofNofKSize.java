package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AllSubSetsofNofKSize {
    public static void main(String[] args) {
        List<List<Integer>> l  = new AllSubSetsofNofKSize().compute(5, 3);
        l.stream().forEach(System.out::println);

    }

    private List<List<Integer>> compute(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> range = IntStream.range(1, n+1).boxed().collect(Collectors.toList());
        compute(n, k , new ArrayList<Integer>(), range, results);
        return results;
    }

    private void compute(int n, int k, List<Integer> prefixList,
                         List<Integer> originalList, List<List<Integer>> results) {
        if(k == prefixList.size())
        {
            results.add(new ArrayList(prefixList));
            return;
        }
        for(int i = 0; i < originalList.size(); i++) {
            prefixList.add(originalList.get(i));
            compute(n, k , prefixList, originalList.subList(i+1, originalList.size()), results);
            prefixList.remove(prefixList.size() - 1);
        }
    }


}
