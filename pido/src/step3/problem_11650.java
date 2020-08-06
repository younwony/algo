package com.algorithm.step03;

import java.io.*;
import java.util.*;

public class problem_11650 {

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

        // 이차원 배열이라 일반 sort 라이브러리 사용시 에러남. compare 함수를 사용하여 다시 비교한다.
        Arrays.sort(arr, (a, b) -> {
            if( a[0] == b[0] ) {        // 앞 숫자가 같을경우 두번째 element 비교
                return Integer.compare(a[1], b[1]);
            }else{
                return Integer.compare(a[0], b[0]);
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
