package org.exor.SPOJ.BSEARCH1;

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
        int N = nextInt(), Q = nextInt();
        int[] arr = new int[N];
        int[] firstInstance = new int[N];
        int uniqueCount = 0;
        for(int i = 0; i < N; i++) {
            int item = nextInt();
            if(uniqueCount == 0 || arr[uniqueCount - 1] != item) {
                arr[uniqueCount] = item;
                firstInstance[uniqueCount] = i;
                uniqueCount++;
            }
        }

        for(int i = 0; i < Q; i++) {
            int pos = Arrays.binarySearch(arr, 0, uniqueCount, nextInt());
            out.println((pos >= 0) ? firstInstance[pos] : -1);
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
        scan = new BufferedReader(new InputStreamReader(System.in),
                                  5 * 1024 * 1024);
        out = new PrintWriter(new BufferedOutputStream(System.out,
                                                       5 * 1024 * 1024));
    }
}
