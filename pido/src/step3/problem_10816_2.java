package com.algorithm.step03;

import java.io.*;
import java.util.*;

public class problem_10816_2 {

    static int[] arr;
    static int[] Marr;
    static int[] ValArr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];     // 상근이 카드 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        Marr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            Marr[i] = Integer.parseInt(st.nextToken());
        }

        // 힙소트
        heapSort(arr, N);

        Map<Integer, Integer> map = new HashMap<>();
        for(Integer key : arr){
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int index = 0;
        ValArr = new int[M];
        for(int search : Marr){
            ValArr[index] = Search(N-1, search, map);
            index ++;
        }

        for(int i=0; i<M; i++){
            bw.write(ValArr[i] + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    // 이분탐색
    public static int Search(int r, int search, Map map){

        int l = 0;  // 배열 인덱스 0
        int mid;

        Set set = map.entrySet();
        Iterator iter = set.iterator();

        while(l <= r){   // 왼쪽 값이 오른쪽값에 역전되기 전까지
            mid = (l+r) / 2;

            if(arr[mid] > search){ // 찾으려는 값이 중앙값보다 작으면 인덱스 이동
                r = mid - 1;
            }else if(arr[mid] < search){
                l = mid + 1;
            }else{
                while(iter.hasNext()){
                    Map.Entry entry = (Map.Entry) iter.next();
                    Integer key = (Integer) entry.getKey();
                    Integer val = (Integer) entry.getValue();
                    if(key == arr[mid]){
                        //System.out.println("일치: " + arr[mid]);
                        return 1 * val; // search값과 중앙값이 같으면 1 반환
                    }
                }
            }
        }
        return 0;   // 없으면 0
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
