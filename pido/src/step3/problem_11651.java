package com.algorithm.step03;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem_11651 {

    static int[][] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());    // 점 갯수
        arr = new int[N][2];                        // 좌표 배열

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> {
            if( a[1] == b[1] ) {
                return Integer.compare(a[0], b[0]);
            }else{
                return Integer.compare(a[1], b[1]);
            }
        });

        for(int i=0; i<N; i++){
            bw.write(arr[i][0] + " " + arr[i][1] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
