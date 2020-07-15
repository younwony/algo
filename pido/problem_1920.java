package com.algorithm.step01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem_1920 {
    public static void main(String[] args) throws IOException {
        int k;
        StringTokenizer st;

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // N 정수 입력값
        st = new StringTokenizer(br.readLine());   // 공백 구분
        int[] Narr = new int[N];     // 배열 생성
        for(int i=0; i < N; i++) {
            Narr[i] = Integer.parseInt(st.nextToken()); // N 배열 생성
        }

        // N배열 Sort
        Sort(Narr, 0, N-1);

        int search;
        int M = Integer.parseInt(br.readLine());    // M 정수 입력값
        st = new StringTokenizer(br.readLine());

        for(int i=0; i < M; i++) {
            search = Integer.parseInt(st.nextToken());
            int mid = Search(Narr, N-1, search);
            System.out.println(mid);
        }
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

    public static void Sort(int arr[], int left, int right){
        if(left <= right){
            int middle = middelPivot(arr,left,right);   // 중앙 pivot 설정
            Sort(arr, left, middle - 1);    // 왼쪽 배열
            Sort(arr, middle + 1, right);    // 오른쪽 배열
        }
    }

    public static int middelPivot(int arr[], int left, int right) {
        int pivot = left;       // 가장 왼쪽 (0)
        int low = left + 1;     // pivot 제외한 가장 왼쪽
        int high = right;       // pivot 제외한 가장 오른쪽

        // low, high 역전되기 전까지
        while(low <= high) {
            // pivot 보다 큰값을 만날때까지
            while (low <= right && arr[low] <= arr[pivot]) low++;

            // pivot 보다 작은값을 만날때까지
            while (high >= (left+1) && arr[pivot] <= arr[high]) high--;

            if(low <= high){    // low 와 high 위치 교환
                swap(arr,low,high);
            }
        }

        // low, high 역전된 후 pivot과 high 위치 교환
        swap(arr,left,high);

        return high;
    }

    public static void swap(int arr[], int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
