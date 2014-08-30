package org.exor.SPOJ.JAVAC;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private boolean isJavaStyle(String expr) {
        for(int i = 0, l = expr.length(); i < l; i++) {
            char c = expr.charAt(i);
            if(i == 0 && Character.isUpperCase(c))
                return false;
            if(c == '_')
                return false;
        }
        return true;
    }

    private boolean isCPPStyle(String expr) {
        char lastChar = 0;
        for(int i = 0, l = expr.length(); i < l; i++) {
            char c = expr.charAt(i);
            if((i == 0 || i == l - 1) && c == '_')
                return false;
            if(lastChar == c && c == '_')
                return false;

            if(Character.isUpperCase(c))
                return false;
            lastChar = c;
        }
        return true;
    }

    private String J2C(String expr) {
        StringBuilder sb = new StringBuilder();
        for(char c: expr.toCharArray()) {
            if(Character.isUpperCase(c))
                sb.append('_');
            sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }

    private String C2J(String expr) {
        StringBuilder sb = new StringBuilder();
        boolean up_next_char = false;
        for(char c: expr.toCharArray()) {
            if(c == '_')
                up_next_char = true;
            else if(up_next_char) {
                sb.append(Character.toUpperCase(c));
                up_next_char = false;
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public void solve() throws Exception {
        init();
        // ----- solution starts here -----
        String line;
        while((line = scan.readLine()) != null) {
            boolean isJava = isJavaStyle(line);
            boolean isCPP = isCPPStyle(line);
            if(!isJava && !isCPP) {
                out.println("Error!");
            }
            else {
                if(isJava && isCPP) {
                    out.println(line);
                }
                else if(isJava)
                    out.println(J2C(line));
                else
                    out.println(C2J(line));
            }

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
