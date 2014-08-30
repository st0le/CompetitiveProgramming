package org.exor.SPOJ.MEOWIST;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private class Node implements Comparable<Node> {
        private final String name;
        private final int age;

        public Node(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Node o) {
            if(age == o.age)
                return name.compareTo(o.name);
            return o.age - age;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public void solve() throws Exception {
        init();
        // ----- solution starts here -----
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        while(true) {
            String name = nextToken();
            if(name != null) {
                pq.add(new Node(name, nextInt()));
            }
            else
                break;
        }
        while(!pq.isEmpty()) {
            out.println(pq.remove());
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
