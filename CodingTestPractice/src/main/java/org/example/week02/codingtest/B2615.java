package org.example.week02.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2615 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[19][19];

        for(int i=0; i < 19; i++) {
            String[] str = br.readLine().split(" ");
            for(int j=0; j < 19; j++) {
                board[i][j] = Integer.parseInt(str[j]);
            }
        }
    }
}
