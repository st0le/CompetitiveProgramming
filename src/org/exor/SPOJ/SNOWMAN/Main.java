package org.exor.SPOJ.SNOWMAN;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
	public void solve() throws Exception {
		init();
		// ----- solution starts here -----
		double k = (3.0 * 16.0) / (Math.PI * 129);
		for (int testCase = 0, T = Integer.valueOf(scan.readLine()); testCase < T; testCase++) {
			out.println((long) (Math.cbrt(Long.valueOf(scan.readLine()) * k) * 4.5));
		}
		// ----- solution ends here -----
		out.flush();
	}

	private final int BUFFER_SIZE = 5 * 1024 * 1024;
	private BufferedReader scan;
	private PrintWriter out;

	public static void main(String[] args) throws Exception {
		new Main().solve();
	}

	private void init() {
		scan = new BufferedReader(new InputStreamReader(System.in), BUFFER_SIZE);
		out = new PrintWriter(new BufferedOutputStream(System.out, BUFFER_SIZE));
	}

}
