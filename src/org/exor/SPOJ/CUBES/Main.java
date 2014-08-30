package org.exor.SPOJ.CUBES;

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
        int a, b, c, d;

        public Node(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            if(a != o.a)
                return a - o.a;
            if(b != o.b)
                return b - o.b;
            if(c != o.c)
                return c - o.c;
            if(d != o.d)
                return d - o.d;
            return 0;
        }

        @Override
        public String toString() {
            return String.format("Cube = %d, Triple = (%d,%d,%d)", a, b, c, d);
        }
    }

    public void solve() throws Exception {
        init();
        // ----- solution starts here -----
        int[] cubes = new int[100 + 1];
        for(int i = 0; i < cubes.length; i++)
            cubes[i] = i * i * i;
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        for(int b = 2; b <= 100; b++)
            for(int c = b; c <= 100; c++)
                for(int d = c; d <= 100; d++) {
                    int a = b * b * b + c * c * c + d * d * d;
                    int position = Arrays.binarySearch(cubes, a);
                    if(position >= 0) {
                        pq.add(new Node(position, b, c, d));
                    }
                }
        while(!pq.isEmpty())
            out.println(pq.remove());
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
