package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromicString {
    public static void main(String[] args) {
       List<String> results = new PalindromicString().compute("0204451881");
       results.forEach(System.out::println);
    }

    private List<String> compute(String s) {
        List<String> results  = new ArrayList<>();
        compute(s, 0, "", results);
        return results;
    }

    private void compute(String s, int offset, String prefix,  List<String> results) {
        if(offset == s.length()){
            results.add(prefix);
        }

        for(int i = offset+1; i < s.length(); i++){
            String t = s.substring(offset, i);
            if(isPalindrome(t)) {
                prefix += t;
                compute(s, i, prefix, results);
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
    }

    private boolean isPalindrome(String t) {
        boolean flag = true;
        for(int i = 0, j = t.length()-1; i < j; i++,j--){
                flag &=  (t.charAt(i)==t.charAt(j));
        }
        return flag;
    }
}
