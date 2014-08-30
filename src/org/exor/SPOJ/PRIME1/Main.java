package org.exor.SPOJ.PRIME1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main {

    private int[] primes;

    public void solve() throws Exception {
        init();
        primes = new PrimeSieve().toPrimitiveArray();

        for(int testCase = 0, T = nextInt(); testCase < T; testCase++) {
            int a = nextInt(), b = nextInt();
            printPrimesBetween(a, b);
        }
        // ----- solution ends here -----
        out.flush();
    }

    private void printPrimesBetween(int a, int b) {

        if(b <= primes[primes.length - 1]) {
            int pos = Arrays.binarySearch(primes, a);
            if(pos < 0)
                pos = ~pos;
            while(primes[pos] <= b)
                out.println(primes[pos++]);
        }
        else {

            BitSet ps = new BitSet(b - a);
            int sqrt = (int)Math.sqrt(b);
            for(int pi = 0; primes[pi] <= sqrt; pi++) {
                int prime = primes[pi];
                int firstFactor = a % prime == 0 ? a : a + (prime - a % prime);
                for(int factor = firstFactor; factor <= b; factor += prime) {
                    ps.set(factor - a);
                }
            }
            for(int p = a; p <= b; p++) {
                if(!ps.get(p - a))
                    out.println(p);
            }
        }
        out.println();
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

    // Sieve of Eratosthenes (Optimized using BitSet)
    public class PrimeSieve {
        private final int maxLimit;
        private BitSet primeList;

        public PrimeSieve() {
            maxLimit = 10000000; // default
            beginSieve(maxLimit);
        }

        public PrimeSieve(int mLimit) {
            maxLimit = mLimit;
            beginSieve(maxLimit);
        }

        private void beginSieve(int mLimit) {
            primeList = new BitSet(mLimit >> 1);
            primeList.set(0, primeList.size(), true);

            int sqroot = (int)Math.sqrt(mLimit);
            primeList.clear(0);
            for(int num = 3; num <= sqroot; num += 2) {
                if(primeList.get(num >> 1)) {
                    int inc = num << 1;
                    for(int factor = num * num; factor < mLimit; factor += inc) {
                        // if( ((factor) & 1) == 1)
                        // {
                        primeList.clear(factor >> 1);
                        // }
                    }
                }
            }
        }

        public boolean isPrime(int num) {
            if(num < maxLimit) {
                if((num & 1) == 0)
                    return(num == 2);
                else
                    return primeList.get(num >> 1);
            }
            return false;
        }

        public int countPrimes(int mLimit) {
            int count = (mLimit < 2) ? 0 : 1; // 2 is prime
            for(int num = 3; num < mLimit; num += 2)
                if(primeList.get(num >> 1))
                    count++;
            return count;
        }

        public int countPrimes() {
            return countPrimes(maxLimit);
        }

        public int getMaxLimit() {
            return maxLimit;
        }

        public ArrayList<Integer> toArray() {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(2);
            for(int num = 3; num < maxLimit; num += 2)
                if(primeList.get(num >> 1))
                    list.add(num);
            return list;
        }

        public int[] toPrimitiveArray() {
            if(maxLimit > 2) {
                int[] primes = new int[countPrimes()];
                primes[0] = 2;

                for(int num = 3, c = 1; num < maxLimit; num += 2)
                    if(primeList.get(num >> 1))
                        primes[c++] = num;
                return primes;
            }
            return null;
        }
    }
}
