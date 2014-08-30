package org.exor.SPOJ.SUMFOUR;

import java.io.PrintStream;
import java.util.Random;

public class TestGen {

	public static void main(String[] args) throws Exception {
		Random r = new Random();
		System.setOut(new PrintStream("c:\\Users\\st0le\\Desktop\\test.txt"));
		int N = 80000;
		System.out.println(N);
		int MAX = 1 << 28;
		int[] arr = new int[] { 1, -1 };
		for (int i = 0; i < N; i++) {
			System.out.println(String.format("%d %d %d %d", r.nextInt(MAX)
					* arr[r.nextInt(2)], r.nextInt(MAX) * arr[r.nextInt(2)],
					r.nextInt(MAX) * arr[r.nextInt(2)],
					r.nextInt(MAX) * arr[r.nextInt(2)]));

		}

	}

}
