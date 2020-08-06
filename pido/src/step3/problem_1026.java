package com.algorithm.step03;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class problem_1026 {

    static Integer[] Aarr;
    static int[] Barr;
    static int[] oriArr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 길이
        StringTokenizer st = new StringTokenizer(br.readLine());

        Aarr = new Integer[N];              // 변화하는 A 배열
        Barr = new int[N];                  // 고정되는 B 배열

        for(int i=0; i < N; i++){
            Aarr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(Aarr, Collections.reverseOrder());  // 내림차순 정렬

        st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++){
            Barr[i] = Integer.parseInt(st.nextToken());
        }

        // 원본 B배열 복사... 인데 얕은복사가 되어버린다.
        // int[] oriArr = Barr;
        oriArr = Barr.clone();                          // 원본 B배열 저장(깊은 복사)
        Arrays.sort(Barr);                              // 오름차순 정렬

        int S = getMinValue();
        System.out.print(S);

        br.close();
    }

    // Aarr(DESC), Barr(ASC)
    public static int getMinValue(){
        int S = 0;
        int index = 0;
        for (int i = 0; i < Barr.length; i++) {
            while (Barr[i] != oriArr[index]) {
                //System.out.println(i + ":" + oriArr[index]);
                index ++;
            }
            S += Aarr[i] * oriArr[index];
            index = 0;
        }
        return S;
    }
}
