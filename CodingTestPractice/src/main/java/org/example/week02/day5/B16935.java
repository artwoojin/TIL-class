package org.example.week02.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16935 {
    static int N, M, R;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<R; i++) {
            int o = Integer.parseInt(st.nextToken());

            rotate(o);
        }
        print();
    }
    static void rotate(int order) {
        switch(order) {
            case 1: One();
                break;
            case 2: Two();
                break;
            case 3: Three();
                break;
            case 4: Four();
                break;
            case 5: Five();
                break;
            case 6: Six();
                break;
        }
    }
    // 상하 반전
    static void One() {
        for(int j=0; j<M; j++) {
            for(int i=0; i<N/2; i++) {
                int temp = arr[i][j];
                arr[i][j] = arr[N-i-1][j];
                arr[N-i-1][j] = temp;
            }
        }
    }
    // 좌우 반전
    static void Two() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M/2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][M-j-1];
                arr[i][M-j-1] = temp;
            }
        }
    }
    // 오른쪽으로 90도 회전 (시계 방향)
    static void Three() {
        Queue<Integer> que = new LinkedList<>();

        // 가로/세로 길이 변환 시 사용
        int newILen = M;
        int newJLen = N;
        int[][] copy = new int[newILen][newJLen];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                que.add(arr[i][j]);
            }
        }
        for(int j=N-1; j>=0; j--) {
            for(int i=0; i<M; i++) {
                copy[i][j] = que.poll();
            }
        }

        // 가로/세로 변환된 arr을 새로 정의
        N = newILen;
        M = newJLen;
        arr = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                arr[i][j] = copy[i][j];
            }
        }
    }
    // 왼쪽으로 90도 회전 (반시계 방향)
    static void Four() {
        Queue<Integer> que = new LinkedList<>();

        // 가로/세로 길이 변환 시 사용
        int newILen = M;
        int newJLen = N;
        int[][] copy = new int[newILen][newJLen];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                que.add(arr[i][j]);
            }
        }
        for(int j=0; j<N; j++) {
            for(int i=M-1; i>=0; i--) {
                copy[i][j] = que.poll();
            }
        }
        // 가로/세로 변환된 arr을 새로 정의
        N = newILen;
        M = newJLen;
        arr = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                arr[i][j] = copy[i][j];
            }
        }
    }
    // 1->2, 2->3, 3->4, 4->1 이동
    static void Five() {
        int[][] copy = new int[N][M];
        int n = N/2;
        int m = M/2;

        for(int i = 0; i<n; i++) {
            for(int j=0; j<m; j++) {
                copy[i][j+m] = arr[i][j];
            }
        }
        for(int i = 0; i<n; i++) {
            for(int j=0; j<m; j++) {
                copy[i+n][j+m] = arr[i][j+m];
            }
        }
        for(int i = 0; i<n; i++) {
            for(int j=0; j<m; j++) {
                copy[i+n][j] = arr[i+n][j+m];
            }
        }
        for(int i = 0; i<n; i++) {
            for(int j=0; j<m; j++) {
                copy[i][j] = arr[i+n][j];
            }
        }
        // 원본에 복사
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                arr[i][j] = copy[i][j];
            }
        }
    }
    // 1->4, 4->3, 3->2, 2->1 이동
    static void Six() {
        int[][] copy = new int[N][M];
        int n = N/2;
        int m = M/2;
        for(int i = 0; i<n; i++) {
            for(int j=0; j<m; j++) {
                copy[i+n][j+m] = arr[i+n][j];
            }
        }
        for(int i = 0; i<n; i++) {
            for(int j=0; j<m; j++) {
                copy[i][j+m] = arr[i+n][j+m];
            }
        }
        for(int i = 0; i<n; i++) {
            for(int j=0; j<m; j++) {
                copy[i+n][j] = arr[i][j];
            }
        }
        for(int i = 0; i<n; i++) {
            for(int j=0; j<m; j++) {
                copy[i][j] = arr[i][j+m];
            }
        }

        // 원본에 복사
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                arr[i][j] = copy[i][j];
            }
        }
    }
    // 출력 함수
    static void print() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}


