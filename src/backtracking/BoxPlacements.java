package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class BoxPlacements {
    public static void main(String[] args) {
        List<Integer> inventory = new ArrayList<>();
        // inventory.add(Arrays.stream(new int[]{4, 3, 2}).boxed().collect(Collectors.toList()));
        //inventory.add(Arrays.asList(3, 2, 1));


         new BoxPlacements().check(inventory);
    }

    private void check(List<Integer> inventory) {
        List<List<Integer>> results = new ArrayList<>();
      //  inventory();
    }
}


class Box {
    private int l;
    private int w;
    private int b;

    public Box(int l, int w, int b) {
        this.l = l;
        this.w = w;
        this.b = b;
    }
}