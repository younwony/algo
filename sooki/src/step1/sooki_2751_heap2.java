package step1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 2750 수 정렬하기
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오
 *
 */
public class sooki_2751_heap2 {
    public static int[] heapSort(int[] heap){
        int size = heap.length;
        for (int i = size/2; i>0; i--)
            makeHeap(heap, i, size);

        do {
            int temp = heap[0];
            heap[0] = heap[size-1];
            heap[size-1] = temp;
            size = size -1;
            makeHeap(heap, 1, size);
        } while (size > 1);
        return heap;
    }

    public static void makeHeap(int heap[], int parent, int size){
        int temp = heap[parent-1];
        while (parent <= size/2){   // 자식노드 중 큰 값 위로 올리기
            int child = 2*parent;
            if ((child<size) && (heap[child-1]<heap[child]))    child++;
            if (temp >= heap[child-1])  break;
            else {
                heap[parent-1] = heap[child-1];
                parent = child;
            }
        }
        heap[parent-1] = temp;
    }


    public static void main(String []args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nArr = new int [n];
        for (int i = 0 ; i < n ; i++)
            nArr[i] = sc.nextInt();

        heapSort(nArr);

       for (int i = 0 ; i < n ; i++)
        {
            System.out.println(nArr[i]);
        }
    }
}
