package com.algorithm.step03;

import java.io.*;
import java.util.*;

public class problem_10816 {

    static int[] arr;
    static int[] Marr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[20000001];     // 상근이 카드수 범위 (-10,000,000 <= S <= 10,000,000)

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[Integer.parseInt(st.nextToken()) + 10000000]++;     // 음수일경우 고려
        }

        int M = Integer.parseInt(br.readLine());
        Marr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            Marr[i] = (arr[Integer.parseInt(st.nextToken())+10000000]);
        }

        for(int i=0; i<M; i++){
            bw.write(Marr[i] + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
