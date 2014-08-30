package org.exor.SPOJ.WORDS1;

import java.io.File;
import java.io.PrintStream;
import java.util.Random;

public class TestGen {

    public static String randomString(int l) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < l; i++)
            sb.append((char)((int)(Math.random() * 26) + 'a'));
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.setOut(new PrintStream(new File("C:\\Users\\332609\\Desktop\\test.txt")));
        Random r = new Random();
        int T = 500;
        System.out.println(T);
        for(int i = 0; i < T; i++) {
            int N = r.nextInt(1000) + 1;
            System.out.println(N);
            for(int j = 0; j < N; j++)
                System.out.println(randomString(r.nextInt(20) + 2));
        }
    }

}
