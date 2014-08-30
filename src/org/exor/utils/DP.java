package org.exor.utils;

import java.util.Arrays;

public class DP {

    public int[] longestIncreasingSubsequence(int[] x) {
        int[] lis = new int[x.length];
        Arrays.fill(lis, 1);
        for(int i = 0; i < x.length; i++) {
            for(int j = 0; j < i; j++) {
                if(x[j] < x[i] && lis[j] + 1 > lis[i])
                    lis[i] = lis[j] + 1;
            }
        }
        return lis;
    }

}
