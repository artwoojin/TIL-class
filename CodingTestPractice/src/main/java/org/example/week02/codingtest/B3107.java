package org.example.week02.codingtest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class B3107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        if(input.contains("::")) {
            input = input.replace("::",":zeros:");
        }
        String[] list = input.split(":");

        List<String> preipv6 = new ArrayList<>();
        List<String> fullipv6 = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            preipv6.add(list[i]);
        }
        for (int i = 0; i < preipv6.size(); i++) {
            String str = preipv6.get(i);
            if (str.isEmpty()) continue;
            while (str.length() < 4) {
                str = "0" + str;
            }
            fullipv6.add(str);
        }

        String[] str = new String[8];
        int zero = 8 - fullipv6.size() + 1;
        int index = 0;

        for (int i = 0; i < fullipv6.size(); i++) {
            if (fullipv6.get(i).equals("zeros")) {
                while(zero-- > 0) {
                    str[index] = "0000";
                    index++;
                } // 개수만큼 0000추가
            } else {
                str[index] = fullipv6.get(i);
                index++;
            } // 그 외엔 그대로 더해주기
        }

        for(int i = 0; i < 7; i++) {
            bw.write(str[i] + ":");
        }
        bw.write(str[7] + "\n");
        bw.flush();
        bw.close();
    }
}
