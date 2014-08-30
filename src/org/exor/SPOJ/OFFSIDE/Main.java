package org.exor.SPOJ.OFFSIDE;

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
		while(true){
			int A = nextInt(), D = nextInt();
			if(A == 0 && D== 0) break;
			int minA = nextInt();
			for (int i = 1; i < A; i++)
				minA = Math.min(minA, nextInt());
			int a = nextInt(), b = nextInt();
			int minD = Math.min(a, b), minD2 = Math.max(a, b);
			for (int i = 2; i < D; i++) {
				int c = nextInt();
				if (c < minD2) {
					if (c < minD) {
						minD2 = minD;
						minD = c;
					} else {
						minD2 = c;
					}
				}
			}
			out.println(minA < minD2 ? "Y" : "N");
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
		if (st == null || !st.hasMoreTokens()) {
			String line = null;
			while ((line = scan.readLine()) != null) {
				if (line.length() > 0)
					break;
			}
			if (line == null)
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
