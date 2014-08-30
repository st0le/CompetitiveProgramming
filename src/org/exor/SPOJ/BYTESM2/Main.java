package org.exor.SPOJ.BYTESM2;

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
        final int N = 100;
        int[][] m = new int[N][N];
        for(int testCase = 0, T = nextInt(); testCase < T; testCase++) {
            int R = nextInt(), C = nextInt();
            for(int i = 0; i < R; i++)
                for(int j = 0; j < C; j++) {
                    m[i][j] = nextInt();
                }

            for(int row = 1; row < R; row++) {
                for(int col = 0; col < C; col++) {
                    int a = col > 0 ? m[row - 1][col - 1] : 0;
                    int b = m[row - 1][col];
                    int c = col + 1 < C ? m[row - 1][col + 1] : 0;
                    m[row][col] += Math.max(Math.max(a, b), c);
                }
            }
            int mx = m[R - 1][0];
            for(int i = 1; i < C; i++)
                if(mx < m[R - 1][i])
                    mx = m[R - 1][i];
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
            String line = null;
            while((line = scan.readLine()) != null) {
                if(line.length() > 0)
                    break;
            }
            if(line == null)
                return null;
            st = new StringTokenizer(line);
        }
        return st == null ? null : st.nextToken();
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
