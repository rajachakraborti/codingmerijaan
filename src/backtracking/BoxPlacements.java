package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class BoxPlacements {
    public static void main(String[] args) {
        Box x1 = new Box(2, 1, 4);
        Box x2 = new Box(3, 2, 5);
        // Box x3 = new Box(5, 2, 4);
        List<Box> l = new ArrayList<>();
        l.add(x1);
        l.add(x2);

        List<Box> collect = l.stream().map(x -> rotateBox(x)).collect(ArrayList::new, List::addAll, List::addAll);
        List<Box> allBoxBaseAreas = collect.stream().sorted(Collections.reverseOrder(Comparator.comparingInt(x -> x.b * x.l))).collect(Collectors.toList());

        List<Integer> heightSortedBoxes = allBoxBaseAreas.stream().map(box -> box.h).collect(Collectors.toList());

        List<Integer> result = IntStream.range(0, allBoxBaseAreas.size()).boxed().collect(Collectors.toList());

        for(int i = 1; i < heightSortedBoxes.size(); i++){
            for(int j = 0; j < i ; j++) {
                if(allBoxBaseAreas.get(i).l < allBoxBaseAreas.get(j).l
                    && allBoxBaseAreas.get(i).b < allBoxBaseAreas.get(j).b ){

                    if(allBoxBaseAreas.get(i).h + heightSortedBoxes.get(j) > heightSortedBoxes.get(i)) {
                        heightSortedBoxes.set(i, allBoxBaseAreas.get(i).h + heightSortedBoxes.get(j));

                        result.set(i,j);
                    }
                }
            }
        }

        System.out.println(Collections.max(heightSortedBoxes));


    }

    private static List<Box> rotateBox(Box x) {
        List<Box> rBox = new ArrayList<>(3);

        rBox.add(new Box( Math.min(x.h,x.b),x.l, Math.max(x.h,x.b)));
        rBox.add(new Box( Math.min(x.l,x.b),x.h, Math.max(x.l,x.b)));
        rBox.add(new Box( Math.min(x.h,x.l),x.b, Math.max(x.h,x.l)));

        return rBox;

    }
}


class Box {
     int l;
     int h;
     int b;

    public Box(int l, int h, int b) {
        this.l = l;
        this.h = h;
        this.b = b;
    }
}