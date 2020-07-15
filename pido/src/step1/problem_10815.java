package com.algorithm.step01;

import java.io.*;
import java.util.StringTokenizer;

public class problem_10815 {

    static StringTokenizer st;
    static int[] Narr;
    static int[] sortArr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());     // N(1 ≤ N ≤ 500,000)
        st = new StringTokenizer(br.readLine());     // -10,000,000 <= st <= 10,000,000

        Narr = new int[N];
        for(int i=0; i<N; i++){
            Narr[i] = Integer.parseInt(st.nextToken());
        }

        sortArr = new int[N];
        mergeSort(0, N-1);  // 병합정렬

        int search;
        int M = Integer.parseInt(br.readLine());    // M(1 ≤ M ≤ 500,000)
        st = new StringTokenizer(br.readLine());    // -10,000,000 <= st <= 10,000,000

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i < M; i++) {
            search = Integer.parseInt(st.nextToken());
            int mid = Search(Narr, N-1, search);
            bw.write(mid+" ");
        }

        br.close();
        bw.close();
    }

    // 이분탐색
    public static int Search(int[] Narr, int r, int search){
        int l = 0;  // 배열 인덱스 0
        int mid;

        while(l <= r){   // 왼쪽 값이 오른쪽값에 역전되기 전까지
            mid = (l+r) / 2;

            if(Narr[mid] > search){ // 찾으려는 값이 중앙값보다 작으면 인덱스 이동
                r = mid - 1;
            }else if(Narr[mid] < search){
                l = mid + 1;
            }else{
                return 1; // search값과 중앙값이 같으면 1 반환
            }
        }
        return 0;   // 없으면 0
    }

    // 분할
    public static void mergeSort(int start, int end){

        if(start < end){
            int middle = (start + end) / 2; // 중간값
            mergeSort(start, middle); // 왼쪽 배열 분할
            mergeSort(middle+1, end); // 오른쪽 배열 분할

            merge(start, middle, end);
        }
    }

    // 병합
    public static void merge(int start, int middle, int end){

        int l = start;      // 왼쪽 배열 시작 index
        int r = middle +1;  // 오른쪽 배열 시작 index
        int M = start;      // 빈 배열 index

        while(l <= middle && r <= end){
            if(Narr[l] <= Narr[r]){   // 왼쪽 <= 오른쪽
                sortArr[M] = Narr[l];
                l++;
            }else{
                sortArr[M] = Narr[r];
                r++;
            }
            M++;
        }

        // 한쪽 배열이 먼저 끝날 경우 남은것 차례로 삽입
        if(l > middle){
            for(int i=r; i<= end; i++){
                sortArr[M] = Narr[i];
                M++;
            }
        }else{
            for(int i=l; i<=middle; i++){
                sortArr[M] = Narr[i];
                M++;
            }
        }

        // 생성한 배열 삽입
        for(int i=start; i<=end; i++){
            Narr[i] = sortArr[i];
        }

    }
}
