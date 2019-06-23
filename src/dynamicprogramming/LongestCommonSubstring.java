package dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestCommonSubstring {

    private int check(String str1, String str2) {
        //List<List<Integer>> result = new ArrayList(Collections.nCopies(0,new ArrayList()));
        int [][]result = new int[Math.max(str1.length(),str2.length())+1][Math.max(str1.length(),str2.length())+1];
        int maxLength = -1;
        for(int i = 1; i <= str1.length(); i++){
            for(int j = 1; j <= str2.length(); j++){
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    result[i][j] = result[i-1][j-1]+1;
                else
                    result[i][j] = 0;

                maxLength = Math.max(result[i][j], maxLength);
            }
        }
        return  maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubstring().check("JaiSriRam", "JaiSaiRam"));
    }
}
