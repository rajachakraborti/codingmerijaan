package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueensProblem {

    public static void main(String[] args) {
        List<List<Integer>> l = new NQueensProblem().solveNQueens(4);
        //System.out.println(Arrays.deepToString(l.stream().map(x -> x.toArray(new Integer[x.size()])).collect(Collectors.toList()).toArray(new Integer[l.size()])));
        // column wise spread
        l.forEach(System.out::println);
    }

    private List<List<Integer>> solveNQueens(int i) {
        List<List<Integer>> result = new ArrayList<>();
        solveNQueens(i, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void solveNQueens(int i, int row, List<Integer> colHolderofMatrix, List<List<Integer>> result) {
        if(colHolderofMatrix.size() == i){
            result.add(new ArrayList<>(colHolderofMatrix));
        }

        for(int col = 0; col < i; col++){
            colHolderofMatrix.add(col);
            if(isValid(colHolderofMatrix))
                solveNQueens(i, row+1, colHolderofMatrix, result);
            colHolderofMatrix.remove(colHolderofMatrix.size() - 1);
        }
    }

    private boolean isValid(List<Integer> colHolderofMatrix) {
        int rowId = colHolderofMatrix.size() - 1;

        for(int i = 0; i < rowId; i++){
            int diff = Math.abs(colHolderofMatrix.get(i) - colHolderofMatrix.get(rowId));
            if(diff == 0 || diff == rowId - i)
                return false;
        }
        return true;
    }
}
/*








base case -- if there is one queen it is always true
constraint-- no Q on same row or col or diagonally
if there is one Q in that row or col no Q and no Q in next row or col

iteration is col based

With this only 2 queens can be on board
Q x x x
x x x x
x x x x
x x x x

Q x x x
x x x x
x Q x x
x x x x

Q x x x
x x Q x
x x x x
x x x x
*/

/*
 Find the no of ways in which a N*N Queens problem can be solved

 1,2 ,3 4 5 6
 */