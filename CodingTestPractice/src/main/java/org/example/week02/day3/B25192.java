package org.example.week02.day3;

import java.io.*;
import java.util.HashSet;

public class B25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> enteredMember = new HashSet<>();

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            String chat = br.readLine();

            if (chat.equals("ENTER")) {
                count += enteredMember.size();

                enteredMember.clear();
                continue;
            }
            enteredMember.add(chat);
        }
        System.out.println(count + enteredMember.size());
    }
}
