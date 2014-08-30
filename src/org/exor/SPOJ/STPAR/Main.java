package org.exor.SPOJ.STPAR;

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
        int[] stack = new int[1000 + 5];
        while(true) {
            int N = nextInt(), top = -1, cur = 1, index = 0;
            Arrays.fill(stack, 0);
            if(N == 0)
                break;
            int[] arr = nextIntArray(N);
            while(cur <= N) {
                if(top != -1 && stack[top] == cur)
                    cur = stack[top--] + 1; // pop off stack
                else if(index < arr.length && arr[index] == cur) {
                    index++;
                    cur++;
                }
                else if(index < arr.length && arr[index] > cur) {
                    if(top != -1 && arr[index] > stack[top])
                        break;
                    stack[++top] = arr[index++];
                }
                else
                    break;
            }
            out.println(cur == N + 1 ? "yes" : "no");
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

    public int[] nextIntArray(int size) throws Exception {
        int[] arr = new int[size];
        for(int i = 0; i < size; i++)
            arr[i] = nextInt();
        return arr;
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
