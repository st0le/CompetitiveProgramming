package org.exor.interviewstreet.practice.insertionsort;

import java.io.File;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class TestGen {

	public static void main(String[] args) throws Exception {
		Random r = new Random();
		PrintStream out = System.out;
		System.setOut(new PrintStream("C:\\Users\\st0le\\Desktop\\test.txt"));
		int T = 1, MAX = 100000;
		int[] arr = new int[MAX];
		System.out.println(T);
		while (T-- > 0) {
			int N = MAX;
			System.out.println(N);
			for (int i = 0; i < N; i++)
				System.out.printf("%d ", arr[i] = N-i/*r.nextInt(MAX)*/);
			System.out.println();
		}
		System.setOut(out);
		new Solution().solve(new Scanner(new File(
				"C:\\Users\\st0le\\Desktop\\test.txt"))
		// new Scanner(System.in)
				);
	}

}
