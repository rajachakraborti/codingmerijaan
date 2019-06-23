package backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindSum {
    public static void main(String[] args) {
        int [] ar = new int []{2,3,7,8,10};
        System.out.println(new FindSum().check(ar, 11, ar.length));
    }

    private boolean check(int[] ints, int target, int i ) {
        if(target == 0 ) return true;
        if(target > 0 && ints.length > 0) {
            int newTarget = target - ints[ints.length - 1 ];

            if(newTarget >= 0 && ints.length > 0 )
                return check(Arrays.copyOfRange(ints, 0 , i - 1), newTarget, i -1 );

            if(newTarget < 0 && ints.length > 0)
                return  check(Arrays.copyOfRange(ints, 0 , i - 1), target, i - 2);

        }
       return false;
    }
}


/*

1 2 3 4 5    11
  11 - 5 = 6 new target array = 1 2 3 4
  6 - 4 = 2  new target array = 1 2 3
  2 - 3 = -1  skip this
  2 - 2 = 0
 */