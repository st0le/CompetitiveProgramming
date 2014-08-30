package org.exor.utils;

public class xMath {

    public long fibMod(long n, long mod) {
        long[][] mtx = new long[][] { {1, 1}, {1, 0}};
        long[][] res = new long[][] { {1, 0}, {0, 1}};
        long a, b, c, d, e, f, g, h;
        while(n > 0) {
            a = mtx[0][0];
            b = mtx[0][1];
            c = mtx[1][0];
            d = mtx[1][1];
            if(n % 2 == 1) {
                // res *= mtx;
                e = res[0][0];
                f = res[0][1];
                g = res[1][0];
                h = res[1][1];
                res[0][0] = ((a * e) % mod + (b * g) % mod) % mod;
                res[0][1] = ((a * f) % mod + (b * h) % mod) % mod;
                res[1][0] = ((c * e) % mod + (c * g) % mod) % mod;
                res[1][1] = ((c * f) % mod + (d * h) % mod) % mod;
            }
            n >>= 1;
            // mtx = mtx*mtx
            mtx[0][0] = ((a * a) % mod + (b * c) % mod) % mod;
            mtx[0][1] = ((a * b) % mod + (b * d) % mod) % mod;
            mtx[1][0] = ((a * c) % mod + (c * d) % mod) % mod;
            mtx[1][1] = ((b * c) % mod + (d * d) % mod) % mod;
        }
        return res[0][1] % mod;
    }

    public static long powMod(long n, int e, long mod) {
        long r = 1;
        while(e > 0) {
            if(e % 2 == 1) {
                r *= n;
                r %= mod;
            }
            n *= n;
            e >>= 1;
        }
        return r % mod;
    }

    public long countDigits(int N, int d) {
        int n = N;
        long c = 0;
        long pow = 1;
        while(n > 0) {
            int numberBeforeDivideByTen = n / 10;
            int numberAfterDivideByTen = n % 10;
            if(d != 0) {
                c += numberBeforeDivideByTen * pow;
            }
            else {
                c += (numberBeforeDivideByTen - 1) * pow;
            }

            if(numberAfterDivideByTen > d) {
                c += pow;
            }
            else if(numberAfterDivideByTen == d) {
                c += N % pow + 1;
            }
            n = n / 10;
            pow = pow * 10;
        }
        return c;
    }

    public static long choose(int n, int r) {
        if(n < 0 || r < 0 || r > n)
            return 0;
        r = Math.min(r, n - r);
        long c = 1;
        for(int k = 1; k <= r; k++) {
            c *= (n - (r - k));
            c /= k;
        }
        return c;
    }

    public static long factorialLength(long n) {
        double f = 0.5 * Math.log10(2 * Math.PI * n) + n
                   * Math.log10(n / Math.E);
        return (long)f + 1;
    }

}
