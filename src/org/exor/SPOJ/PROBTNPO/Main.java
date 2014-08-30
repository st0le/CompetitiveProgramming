package org.exor.SPOJ.PROBTNPO;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private int[] memo;

    private int collatz(long n) throws Exception {
        if(n < memo.length) {
            if(memo[(int)n] == -1) {
                memo[(int)n] = collatz(n % 2 == 0 ? n / 2 : 3 * n + 1) + 1;
            }
            return memo[(int)n];
        }
        else {
            return 1 + collatz(n % 2 == 0 ? n / 2 : 3 * n + 1);
        }
    }

    public void solve() throws Exception {
        init();
        // ----- solution starts here -----
        memo = new int[1000000 + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;
        for(int n = memo.length - 1; n >= 2; n--)
            collatz(n);
        String line;
        while((line = scan.readLine()) != null) {
            st = new StringTokenizer(line);
            int i = Integer.valueOf(st.nextToken());
            int j = Integer.valueOf(st.nextToken());
            int mx = Math.max(i, j);
            int maxCycle = Integer.MIN_VALUE;
            for(int n = Math.min(i, j); n <= mx; n++) {
                if(maxCycle < memo[n])
                    maxCycle = memo[n];
            }
            out.println(String.format("%d %d %d", i, j, maxCycle));
        }
        // ----- solution ends here -----
        out.flush();
    }

    private StringTokenizer st;
    private BufferedReader scan;
    private PrintWriter out;

    public void debug(Object... o) {
        System.err.println(Arrays.deepToString(o));
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }

    private void init() {
        scan = new BufferedReader(new InputStreamReader(System.in), 500 * 1024);
        out = new PrintWriter(new BufferedOutputStream(System.out));
    }

}
