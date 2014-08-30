package org.exor.SPOJ.LASTDIG;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while(T-- > 0) {
            out.println(s.nextBigInteger()
                         .mod(BigInteger.TEN)
                         .modPow(s.nextBigInteger(), BigInteger.TEN));
        }
        out.flush();
    }
}
