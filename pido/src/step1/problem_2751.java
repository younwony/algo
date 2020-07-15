package com.algorithm.step01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem_2751 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] Narr = new int[N];

        for(int i=0; i < N; i++){
            Narr[i] = Integer.parseInt(br.readLine());
        }

        // 최대힙 생성
        heapSort(Narr, N);

        for(int i=0; i<N; i++){
            System.out.println(Narr[i]);
        }
    }

    public static void heapSort(int arr[], int size){
        maxHeap(arr, size);
        for(int t=size-1; t >= 0; t--){
            swap(arr, t , 0);
            setHeap(arr, 0, t);
        }
    }

    // 자식이 존재하는 부모만 힙처리
    public static void maxHeap(int[] arr, int size){
        for(int i = (size/2)-1; i >= 0; i--){
            setHeap(arr, i, size);
        }
    }

    public static void setHeap(int arr[], int parentIndex, int size){
        int leftIndex = parentIndex * 2 + 1;
        int rightIndex = (parentIndex * 2) + 2;
        int max = parentIndex;

        // 이진트리의 부모가 자식보다 크도록 최대 힙 구현
        if(leftIndex < size && arr[leftIndex] > arr[max]) max = leftIndex;
        if(rightIndex < size && arr[rightIndex] > arr[max])  max = rightIndex;

        if(max != parentIndex){
            swap(arr , parentIndex, max);
            setHeap(arr, max, size);
        }
    }

    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
