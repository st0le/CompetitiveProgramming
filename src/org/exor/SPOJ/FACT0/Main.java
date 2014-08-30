package org.exor.SPOJ.FACT0;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	private long mulMod(long x, long y, long mod) {
		long ret = 0L;
		x %= mod;
		y %= mod;
		while (y > 0) {
			if ((y & 1) > 0) {
				ret += x;
				ret %= mod;
			}
			y >>= 1;
			x <<= 1;
			x %= mod;
		}
		return ret;
	}

	private long sq(long x, long mod) {
		return mulMod(x, x, mod);
	}

	private long expMod(long base, long exp, long mod) {
		long res = 1L;
		long mp = base;
		while (exp > 0) {
			if ((exp & 1) == 1) {
				res = mulMod(res, mp, mod);
			}
			exp >>= 1;
			mp = sq(mp, mod);
		}
		return res;
	}

	private long gcd(long a, long b) {
		a = Math.abs(a);
		b = Math.abs(b);
		long c;
		while (b > 0) {
			c = a % b;
			a = b;
			b = c;
		}
		return a;
	}

	private long rhoPollard(long p) {
		long x = 2;
		long y = 2;
		long d = 1;
		long c = 2;
		while (d == 1L) {
			x = sq(x, p) + c;
			x %= p;
			y = sq(y, p) + c;
			y %= p;
			y = sq(y, p) + c;
			y %= p;
			d = gcd(Math.abs(x - y), p);
			if (d == p)
				break;
		}
		return d;
	}

	// Miller rabin
	private boolean miller_isprime_1(long p, long a) {
		long ex = p - 1L;
		long r;
		long t;
		if (p < 2)
			return false;
		if (p < 4)
			return true;
		r = 0;
		while (ex % 2L == 0) {
			ex /= 2;
			r++;
		}
		t = expMod(a, ex, p);
		if (t == 1L || t == p - 1L)
			return true;
		while (r > 1) {
			t = sq(t, p);
			if (t == p - 1L)
				return true;
			r--;
		}
		return false;
	}

	long ps[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53,
			59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 0 };

	int miller_isprime(long p) {
		int i;
		for (i = 0; ps[i] != 0; ++i) {
			if (!miller_isprime_1(p, ps[i]))
				return 0;
		}
		return 1;
	}

	public void solve() throws Exception {
		init();
		// ----- solution starts here -----
		long n;
		while ((n = scan.nextLong()) > 0) {
			long f = rhoPollard(n);
			System.out.println(f + "," + n / f);
		}
		// ----- solution ends here -----
		// printRuntimeInfo();
		out.flush();
	}

	private final int BUFFER_SIZE = 5 * 1024 * 1024;
	private PrintWriter out;
	private Scanner scan;

	public void debug(Object... o) {
		System.err.println(Arrays.deepToString(o));
	}

	public static void main(String[] args) throws Exception {
		new Main().solve();
	}

	private void init() {
		scan = new Scanner(System.in);
		out = new PrintWriter(new BufferedOutputStream(System.out, BUFFER_SIZE));
	}
}
