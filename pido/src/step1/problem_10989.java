package com.algorithm.step01;

import java.io.*;

public class problem_10989 {

    static int[] arr;
    static int[] countArr = new int[10000 + 1]; // 배열 최대값 + 1
    static int[] sortArr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sortArr = new int[arr.length];

        for(int i=0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 카운팅 소트
        countingSort(sortArr);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<N; i++){
            bw.write(Integer.toString(arr[i])+"\n");
        }

        br.close();
        bw.close();
    }

    public static void countingSort(int[] sortArr){

        // 생성한 배열의 값(arr[])을 해당하는 인덱스(countArr[])에 카운트
        for(int i=0; i < arr.length; i++){
            countArr[arr[i]-1]++;
        }

        int j =0;
        for(int i=1; i <= countArr.length; i++){
            while(countArr[i-1] > 0){   // countArr 배열 값이 있을 경우
                arr[j] = i;
                countArr[i-1]--;    // 하나씩 제거
                j++;
            }
        }
    }
}
