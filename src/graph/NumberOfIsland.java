package graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIsland {
    public static void main(String[] args) {
        int mat[][] =  {{1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 1},
                        {1, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 1}
        };

        int x = new NumberOfIsland().countThem(mat);
        System.out.println(x);
    }

    private int countThem(int[][] mat) {
        List<Integer> sz = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1)
                    sz.add(dfsHelper(mat, i, j));
            }
        }
        return sz.size();
    }

    private int dfsHelper(int[][] mat, int i, int j) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[i].length ) {
            return 0;
        }

        if (mat[i][j] == 0) return 0;

        mat[i][j] = 0;

        int sz = 1;
        for (int r = i - 1; r <= i + 1; r++) {
            for (int c = j - 1; c <= j + 1; c++) {
                if (r != i || j != c)
                    sz += dfsHelper(mat, r, c);
            }
        }
        return sz;
    }
}
