package org.exor.SPOJ.SUMTRIAN;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public void solve() throws Exception {
        init();
        // ----- solution starts here -----
        int[][] tr = new int[101][];
        for(int i = 0; i < tr.length; i++) {
            tr[i] = new int[i + 1];
        }
        for(int testCase = 0, T = nextInt(); testCase < T; testCase++) {
            int r = nextInt();
            for(int i = 0; i < r; i++) {
                for(int j = 0; j < i + 1; j++)
                    tr[i][j] = nextInt();
            }
            for(int i = 1; i < r; i++) {
                for(int j = 0; j < i + 1; j++)
                    tr[i][j] += Math.max(j < i ? tr[i - 1][j] : 0,
                                         j > 0 ? tr[i - 1][j - 1] : 0);
            }
            int mx = tr[r - 1][0];
            for(int j = 0; j < r; j++)
                if(mx < tr[r - 1][j])
                    mx = tr[r - 1][j];
            out.println(mx);
        }
        // ----- solution ends here -----
        out.flush();
    }

    private StringTokenizer st;
    private BufferedReader scan;
    private PrintWriter out;

    public int nextInt() throws Exception {
        return Integer.valueOf(nextToken());
    }

    public long nextLong() throws Exception {
        return Long.valueOf(nextToken());
    }

    public BigInteger nextBigInteger() throws Exception {
        return new BigInteger(nextToken());
    }

    public float nextFloat() throws Exception {
        return Float.valueOf(nextToken());
    }

    public Double nextDouble() throws Exception {
        return Double.valueOf(nextToken());
    }

    public String nextToken() throws Exception {
        if(st == null || !st.hasMoreTokens()) {
            String line = scan.readLine();
            if(line == null)
                return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

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
