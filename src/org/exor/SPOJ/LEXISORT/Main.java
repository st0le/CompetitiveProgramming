package org.exor.SPOJ.LEXISORT;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public void solve() throws Exception {
        init();
        // ----- solution starts here -----
        int[] freq = new int[50000 + 100];
        for(int testCase = 0, T = nextInt(); testCase < T; testCase++) {
            Index index = new Index();
            Arrays.fill(freq, 0);
            for(int i = 0, n = nextInt(); i < n; i++) {
                freq[index.indexOf(nextToken())]++;
            }
            for(String s: index.keys())
                for(int c = 0, l = freq[index.indexOf(s)]; c < l; c++)
                    out.println(s);
        }
        // ----- solution ends here -----
        out.flush();
    }

    private class Index {
        private final Map<String, Integer> map = new TreeMap<String, Integer>();
        private final java.util.List<String> list = new ArrayList<String>();

        public Set<String> keys() {
            return map.keySet();
        }

        public int indexOf(String value) {
            Integer id = map.get(value);
            if(id == null) {
                map.put(value, id = map.size());
                list.add(value);
            }
            return id;
        }
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
