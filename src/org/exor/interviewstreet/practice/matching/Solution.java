package org.exor.interviewstreet.practice.matching;

import java.util.Scanner;

public class Solution {

	private final long mod = 1000000007L;
	private boolean[] composites;
	private int MAX;

	public void solve(int N) {
		MAX = 2 * N + 1;
		composites = new boolean[MAX >> 1];
		for (int i = 3, sqrt = (int) Math.sqrt(MAX); i <= sqrt; i += 2) {
			if (!composites[i >> 1])
				for (int j = i * i; j < MAX; j += 2 * i)
					composites[j >> 1] = true;
		}
		long ans = chooseMod(2 * N, N) - chooseMod(2 * N, N + 1);
		if (ans < 0)
			ans += mod;
		System.out.println(ans);
	}

	public long chooseMod(int n, int k) {
		long c = 1;
		int cnt, _n, _k, _r, prime;
		prime = 2;

		cnt = 0;
		_n = n;
		_k = k;
		_r = n - k;
		while (_n > 0) {
			cnt += (_n /= prime) - (_k /= prime) - (_r /= prime);
		}
		c *= powMod(prime, cnt, mod);
		c %= mod;

		for (prime = 3; prime < MAX; prime += 2) {
			if (!composites[prime >> 1]) {
				cnt = 0;
				_n = n;
				_k = k;
				_r = n - k;
				while (_n > 0) {
					cnt += (_n /= prime) - (_k /= prime) - (_r /= prime);
				}
				c *= powMod(prime, cnt, mod);
				c %= mod;
			}
		}
		return c;
	}

	public static long powMod(long a, long b, long c) {
		long x = 1, y = a;
		while (b > 0) {
			if (b % 2 == 1) {
				x = (x * y) % c;
			}
			y = (y * y) % c;
			b /= 2;
		}
		return (x % c);
	}

	public static void main(String[] args) {
		new Solution().solve(new Scanner(System.in).nextInt());
	}

}
