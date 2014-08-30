package org.exor.SPOJ.TOANDFRO;

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
        char[][] mtx = new char[40][40];
        StringBuilder sb = new StringBuilder();
        while(true) {
            sb.setLength(0);
            int i = 0, j = 0, k = 0, n;
            if((n = nextInt()) == 0)
                break;
            String line = nextToken();
            while(k < line.length()) {
                if(j == n) {
                    i++;
                    j = 0;
                }
                mtx[i][j++] = line.charAt(k++);
            }
            if(j == n) {
                i++;
                j = 0;
            }
            while(j < n)
                mtx[i][j++] = 'x';

            for(int x = 1; x < i; x += 2)
                for(int y = 0, z = n - 1; y < z; y++, z--) {
                    char c = mtx[x][y];
                    mtx[x][y] = mtx[x][z];
                    mtx[x][z] = c;
                }
            for(int y = 0; y < n; y++)
                for(int x = 0; x < i; x++)
                    sb.append(mtx[x][y]);
            out.println(sb.toString());
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
        if(st == null || !st.hasMoreTokens())
            st = new StringTokenizer(scan.readLine());
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
