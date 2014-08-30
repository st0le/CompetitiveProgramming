package org.exor.SPOJ.PALIN;

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
        for(int testCase = 0, T = nextInt(); testCase < T; testCase++) {
            String number = nextToken();
            out.println(nextPalindrome(number));
        }
        // ----- solution ends here -----
        out.flush();
    }

    private String nextPalindrome(String number) {
        int length = number.length();
        int mid = length >> 1;
        char[] palin = number.toCharArray();

        for(int i = 0, l = length - 1; i < l; i++, l--)
            palin[l] = number.charAt(i);
        if(number.compareTo(new String(palin)) >= 0) {
            // increment from middle
            int right = mid, left = length - mid - 1;
            while(right < length) {
                if(palin[right] == '9') {
                    palin[right++] = '0';
                    palin[left--] = '0';
                }
                else {
                    palin[right]++;
                    if(left != right)
                        palin[left]++;
                    break;
                }
            }
            if(right >= length) {
                palin[length - 1] = '1';
                return "1" + new String(palin);
            }
        }
        return new String(palin);
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
