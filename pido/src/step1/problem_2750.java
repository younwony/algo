package com.algorithm.step01;


import java.io.*;

public class problem_2750 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 입력값
        int[] arr = new int[N]; // 배열 생성

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // Quick Sort
        // 1. middle pivot
        Sort(arr, 0, N-1);


        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }

        br.close();
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
