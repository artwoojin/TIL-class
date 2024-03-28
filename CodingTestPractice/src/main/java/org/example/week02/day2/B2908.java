package org.example.week02.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());

        String reverse = sb.reverse().toString();
        int a = Integer.parseInt(reverse.substring(0,3));
        int b = Integer.parseInt(reverse.substring(4,7));

        System.out.println(Math.max(a, b));
    }
}
