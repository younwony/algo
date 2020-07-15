package step1;

import java.util.Arrays;

/**
 * 힙정렬
 * 이지수
 */
public class HeapSort {
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
        System.out.println(Arrays.toString(heap));
    }

    public static void main (String args[]){
        int[] dataList = {87, 23, 40, 31, 27, 4, 53, 15, 72};
        int size = dataList.length;

        System.out.print("\n*** Sort 자료 : ");

        for (int i = 0; i < size; i++)
            System.out.print(dataList[i] + " ");
        System.out.println("\n");

        System.out.println("******** Heap Sort 진행 과정 ********");

        heapSort(dataList);
    }

}
