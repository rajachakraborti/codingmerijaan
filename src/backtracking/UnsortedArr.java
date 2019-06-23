package backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UnsortedArr {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new UnsortedArr().check(new int[]{9,16,5,8,11,6,3,7,4,10}, 14)));
    }

    private int[] check(int[] ints, int j) {
        Map<Integer, Integer> m = new HashMap<>();

        for(int i : ints){
             m.put(i,j-i );
            if(m.get(j-i)!=null) {
                System.out.println(i + " :: " + (j - i));
                return new int[]{i, j-i};
            }

        }
        return null;
    }
}
