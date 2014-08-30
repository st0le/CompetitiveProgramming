package org.exor.SPOJ.PPATH;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public boolean isPrime(int n) {
        if(n < 2)
            return false;
        if(n == 2 || n == 3)
            return true;
        if(n % 2 == 0 || n % 3 == 0)
            return false;
        int sqrtN = (int)Math.sqrt(n) + 1;
        for(int i = 5; i <= sqrtN; i += 6) {
            if(n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

    private int d(int a, int b) {
        int c = 0;
        while(a > 0) {
            if(a % 10 == b % 10)
                c++;
            a /= 10;
            b /= 10;
        }
        return c;
    }

    public void solve() throws Exception {
        init();
        // ----- solution starts here -----
        final int N = 1061;
        int[] primes = new int[N];

        for(int i = 1000, c = 0; i < 10000; i++)
            if(isPrime(i))
                primes[c++] = i;
        int[][] w = new int[N][N];
        for(int i = 0; i < N; i++)
            for(int j = i + 1; j < N; j++) {
                w[i][j] = w[j][i] = d(primes[i], primes[j]) == 3 ? 1
                                                                : Integer.MAX_VALUE / 2;
            }

        final int[] d = new int[N];
        for(int testCase = 0, testCases = nextInt(); testCase < testCases; testCase++) {
            Arrays.fill(d, Integer.MAX_VALUE / 2);
            int startPrime = nextInt(), endPrime = nextInt();
            int u = Arrays.binarySearch(primes, startPrime);
            PriorityQueue<Integer> q = new PriorityQueue<Integer>(N,
                                                                  new Comparator<Integer>() {

                                                                      @Override
                                                                      public int compare(Integer o1,
                                                                                         Integer o2) {
                                                                          return d[o1]
                                                                                 - d[o2];
                                                                      }
                                                                  });
            d[u] = 0;
            q.add(u);
            while(!q.isEmpty()) {
                u = q.remove();
                for(int v = 0; v < N; v++) {
                    if(d[v] > d[u] + w[u][v]) {
                        d[v] = d[u] + w[u][v];
                        q.add(v);
                    }
                }
                if(primes[u] == endPrime)
                    break;
            }
            int v = Arrays.binarySearch(primes, endPrime);
            out.println(d[v] == Integer.MAX_VALUE / 2 ? "Impossible" : d[v]);
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
