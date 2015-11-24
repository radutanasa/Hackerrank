package com.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by radu on 24/11/15.
 */
public class Solution {

    public static BigInteger fibonacciSq(int a, int b, int n) {
        BigInteger prev2 = BigInteger.valueOf(a);
        BigInteger prev = BigInteger.valueOf(b);
        BigInteger value = null;
        for (int i = 3; i <= n; i++) {
            value = prev.multiply(prev).add(prev2);
            prev2 = prev;
            prev = value;
        }
        return value;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int a = console.nextInt();
        int b = console.nextInt();
        int n = console.nextInt();
        System.out.println(fibonacciSq(a, b, n));
    }
}
